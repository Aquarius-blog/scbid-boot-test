// 表格数据查询事件及分页查询事件
$(function(){
	if($("#table").length > 0)
	{
		$.InitMainTable("#table", vm.fields, function queryCallback(params){
			params = $.extend(params, vm.q);
			vm.reload(params);
		}, function pageCallback(params){
			params = $.extend(params, vm.q);
			vm.reload(params);
		});
		vm.reload(null);
	}
});

// 每个模块功能权限设置
function actionFormatter(value, row, index){
	var result = "";
	// 待支付订单
	if(row.orderStatus == 1)
	{
		result += "<a class='btn btn-xs green' onclick=\"orderCheck('" + row.orderId
		        + "')\"title='审核'><span class='glyphicon glyphicon-hourglass'></span></a>";
	}
	if(row.orderStatus == 2)
	{
		result += "<a class='btn btn-xs green' onclick=\"orderPay('" + row.orderId
		        + "')\"title='支付'><span class='glyphicon glyphicon-usd'></span></a>";
	}
	if(row.orderStatus == 3)
	{
		result += "<a class='btn btn-xs green' onclick=\"downloadInvoice('" + row.invoiceUuid
		        + "')\"title='发票'><span class='glyphicon glyphicon-download-alt'></span></a>";
	}
	else
	{
		result += "<a class='btn btn-xs green' onclick=\"select('" + row.orderId
		        + "')\"title='查看'><span class='glyphicon glyphicon-search'></span></a>";
		result += "<a class='btn btn-xs blue' onclick=\"update('" + row.orderId
		        + "')\"title='编辑'><span class='glyphicon glyphicon-pencil'></span></a>";
		result += "<a class='btn btn-xs red' onclick=\"del('" + row.orderId
		        + "')\" title='删除'><span class='glyphicon glyphicon-remove'></span></a>";
	}
	return result;
}

// 支付页面
function orderPay(orderId){
	$('#orderPayModal').modal('show');
	vm.getInfo(orderId);
}
// 发票下载及查看
function downloadInvoice(invoiceUuid){
	layer.open({
	    type : 2,
	    area : [
	            '700px', '530px'
	    ],
	    content : baseURL + "/utils/getInvoiceUrl?listId=" + invoiceUuid // 这里content是一个普通的String
	});
}
// 担保申请单
function guaratorTableFormatter(value, row, index){
	if(row.guaratorName == "成都银行")
	{
		return "<a  class='btn btn-xs green' onclick=\"applicationTable('" + row.orderId
		        + "')\" ><span class='glyphicon glyphicon-search'></span>担保申请单</a>";
	}
	if(value === null)
	{
		return "无担保申请单";
	}
}

// Vue函数体
var vm = new Vue({
    el : '#rrapp',
    data : {
        title : null,
        q : {
            orderId : null,
            supplierId : null,
            agencyId : null,
            guaratorId : null,
            orderNo : null,
            orderMoney : null,
            orderType : null,
            orderVoucher : null,
            orderStatus : null,
            payType : null,
            orderDate : null,
            updateUesrName : null,
            updateDate : null,
        },
        bondOrder : {
            orderId : null,
            supplierId : null,
            supplierName : null,
            agencyId : null,
            agencyName : null,
            guaratorId : null,
            guaratorName : null,
            orderNo : null,
            orderMoney : null,
            orderType : null,
            orderVoucher : null,
            orderStatus : null,
            payType : null,
            orderDate : null,
            updateUesrName : null,
            updateDate : null,
        },
        alipayForm : null,
        fields : [
                // {field:'orderId',title:'orderId', width: 50, key: true},
                // {field:'supplierId',title:'供应商主键ID', width: 80 },
                {
                    field : 'supplierName',
                    title : '供应商',
                    width : 120
                },
                // {field:'agencyId',title:'代理机构主键ID', width: 80 },
                {
                    field : 'agencyName',
                    title : '代理机构',
                    width : 120
                },
                // {field:'guaratorId',title:'担保机构主键ID', width: 80 },
                {
                    field : 'guaratorName',
                    title : '担保机构',
                    width : 120
                }, {
                    field : 'orderNo',
                    title : '订单编号',
                    width : 80
                }, {
                    field : 'orderMoney',
                    title : '订单金额',
                    width : 80
                }, {
                    field : 'orderType',
                    title : '订单类型',
                    width : 80,
                    formatter : orderTypeFormatter
                }, {
                    field : 'guaratorTable',
                    title : '担保申请单',
                    width : 80,
                    formatter : guaratorTableFormatter
                }, {
                    field : 'orderVoucher',
                    title : '订单凭证',
                    width : 80,
                    formatter : orderVoucherFormatter
                }, {
                    field : 'orderStatus',
                    title : '订单状态',
                    width : 80,
                    formatter : orderStatusFormatter
                }, {
                    field : 'payType',
                    title : '支付类型',
                    width : 80,
                    formatter : payTypeFormatter
                }, {
                    field : 'orderDate',
                    title : '订单创建时间',
                    width : 80
                },
        // {field:'updateUesrName',title:'最后修改人', width: 80 },
        // {field:'updateDate',title:'最后修改时间', width: 80 },
        ],
    },
    methods : {
        // 查询
        query : function(){
	        vm.reload(vm.q);
        },
        // 新增
        add : function(){
	        vm.title = "新增";
	        vm.bondOrder = {};
	        $('#itemModal').modal('show');
        },
        // 导入
        importPage : function(){
	        $('#importModal').modal('show');
        },
        // 导入请求
        importPost : function(){
	        $.syncPost(baseURL + "/bond/bondorder/import", JSON.stringify(vm.fields), function(r){
		        if(r.code === 0)
		        {
			        alert('操作成功', function(){
				        $('#importModal').modal('hide');
				        vm.reload();
			        });
		        }
		        else
		        {
			        alert(r.msg);
		        }
	        });
        },
        // 导出
        exportPage : function(){
	        $('#exportModal').modal('show');
        },
        // 导出请求
        exportPage : function(){
	        
	        $.syncPost(baseURL + "/bond/bondorder/export", JSON.stringify(vm.fields), function(r){
		        if(r.code === 0)
		        {
			        alert('操作成功', function(){
				        $('#exportModal').modal('hide');
				        vm.reload();
			        });
		        }
		        else
		        {
			        alert(r.msg);
		        }
	        });
        },
        // 修改
        update : function(event){
	        var row = getSelectedRow();
	        var orderId = row.orderId;
	        if(orderId == null)
	        {
		        return;
	        }
	        vm.title = "修改";
	        vm.itemPage(orderId);
        },
        // 详情
        itemPage : function(orderId){
	        $('#itemModal').modal('show');
	        vm.getInfo(orderId);
        },
        // 新增OR修改
        saveOrUpdate : function(event){
	        var url = vm.bondOrder.orderId == null ? "/bond/bondorder/save" : "/bond/bondorder/update";
	        $.syncPost(baseURL + url, JSON.stringify(vm.bondOrder), function(r){
		        if(r.code === 0)
		        {
			        alert('操作成功', function(){
				        vm.reload();
			        });
		        }
		        else
		        {
			        alert(r.msg);
		        }
	        });
        },
        // 删除
        del : function(event){
	        var rows = getSelectedRows();
	        var orderIds = [];
	        rows.forEach(function(value, index, array){
		        orderIds.push(array[index].orderId);
	        });
	        if(orderIds == null)
	        {
		        return;
	        }
	        vm.delPost(orderIds);
        },
        // 删除请求
        delPost : function(orderIds){
	        confirm('确定要删除选中的记录？', function(){
		        $.syncPost(baseURL + "/bond/bondorder/delete", JSON.stringify(orderIds), function(r){
			        if(r.code === 0)
			        {
				        alert('操作成功', function(){
					        vm.reload();
				        });
			        }
			        else
			        {
				        alert(r.msg);
			        }
		        });
	        });
        },
        // 明细请求
        getInfo : function(orderId){
	        $.get(baseURL + "/bond/bondorder/info/" + orderId, function(r){
		        vm.bondOrder = r.bondOrder;
	        });
        },
        // 支付宝支付
        alipay : function(){
	        $.syncPost(baseURL + "/bond/alipay", JSON.stringify(vm.bondOrder), function(r){
		        
		        if(r.message)
		        {
			        alert(r.message);
			        return;
		        }
		        
		        var params = "?dn=1";
		        var product = r.product;
		        var result = Base64.encode(JSON.stringify(product));
		        var key = Base64.encode(result);
		        var data = {
		        	key:key,
		        	result:result
		        }
		        var params = "?dn=2";
		        for( var key in data){
		        	params = params + '&' + '' + key + '=' + data[key] + '';
		        }
		        var form = document.createElement('form');
		        form.action = r.alipayPayUrl + params;
		        form.target = '_blank';
		        form.method = 'POST';
		        document.body.appendChild(form);
		        form.submit();
		        //window.open(r.alipayPayUrl + params);
		        
		       /* layer.open({
		            type : 2,
		            area : [
		                    '700px', '530px'
		            ],
		            content : r.alipayPayUrl + params // 这里content是一个普通的String
		        });*/
	        });
        },
        // 微信支付
        weixinpay : function(){
	        $.syncPost(baseURL + "/bond/weixin", JSON.stringify(vm.bondOrder), function(r){
		        if(r.message)
		        {	
			        alert(r.message);
			        return;
		        }
		        var params = "?dn=1";
		        var product = r.product;
		        
		        var result = Base64.encode(JSON.stringify(product));
		        var key = Base64.encode(result);
		        
		        var data = {
		        	key:key,
		        	result:result
		        }
		        var params = "?dn=2";
		        for( var key in data){
		        	params = params + '&' + '' + key + '=' + data[key] + '';
		        }
		        
		        var form = document.createElement('form');
		        form.action = r.weixinPayUrl + params;
		        form.target = '_blank';
		        form.method = 'POST';
		        document.body.appendChild(form);
		        form.submit();
		        
		        //window.open(r.weixinPayUrl + params);
		        
		        /*layer.open({
		            type : 2,
		            area : [
		                    '700px', '530px'
		            ],
		            content : r.weixinPayUrl + params // 这里content是一个普通的String
		        });*/
	        });
        },
        // 银联支付
        unionpay : function(){
	        alert("支付对接中...");
        },
        // 重新加载请求
        reload : function(params){
	        $.postForm(baseURL + '/bond/bondensupplier/orders', params, function(request){
		        $("#table").bootstrapTable('load', request.page);
	        });
        }
    },
    // 创建完毕状态
    created : function(){
	    
    }
});
