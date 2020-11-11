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
	result += "<a class='btn btn-xs green' onclick=\"select('" + row.orderId + "')\"  title='查看'><span class='glyphicon glyphicon-search'></span></a>";
	return result;
}


//担保申请单
function guaratorTableFormatter(value, row, index) {
	if (row.guaratorName=="成都银行") {
		return "<a  class='btn btn-xs green' onclick=\"applicationTable('"+ row.orderId+ "')\" ><span class='glyphicon glyphicon-search'></span>担保申请单</a>";
	}
	if (value === null) {
		return "无担保申请单";
	}
}

/**
 * 接受办理业务
 * @param orderId
 * @returns
 */
function acceptHandle (orderId){
	var url = baseURL + "bond/bondorder/acceptHandle?orderId="+orderId;
	$.get(url,function(r){
		alert(r.msg, function(){
	        vm.reload();
        });
	});
}

//上传保函扫码文件
function uploadBond(orderId){
	var serverPath = baseURL + "bond/bondorder/uploadBond?orderId="+orderId;
	createFilesMultiple("uploader",serverPath,function(stats){
		$('#uploadBondModal').modal('hide');
		vm.reload();
	});//
	$('#uploadBondModal').modal('show');
}

// Vue函数体
var vm = new Vue({
    el : '#rrapp',
    data : {
        title : null,
        bondEnguarators:[],//子结构担保
        orderIds:[],//需要被处理的订单
        guaratorUuid:'',//分配的办理机构
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
        fields : [
        	{field:'orderId',title:'orderId', visible: false, width: 50, key: true},
			{field:'supplierId',title:'供应商主键ID', visible: false, width: 80 },
			{field:'supplierUuid',title:'供应商主键ID', visible: false, width: 80 },
			{field:'supplierName',title:'供应商',  width: 120 },
			{field:'agencyId',title:'代理机构主键ID', visible: false, width: 80 },
			{field:'agencyName',title:'代理机构', width: 120 },
			{field:'guaratorId',title:'担保机构主键ID', visible: false, width: 80 },
			{field:'guaratorName',title:'担保机构', width: 120 },
			
			{field:'saleOrderId',title:'售卖主键',visible: false, width: 80 },
			{field:'projectId',title:'项目主键', visible: false,width: 80 },
			{field:'projectCode',title:'项目编号', width: 80 },
			{field:'projectName',title:'项目名称', width: 200 },
			{field:'packageId',title:'项目分包主键',visible: false, width: 80 },
			{field:'packagesNum',title:'分包编号', width: 80 },
			{field:'packagesName',title:'分包名称', width: 80 },
			{field:'bondMoney',title:'保证金金额',visible: false, width: 80 },
			
			{field:'orderNo',title:'订单编号',visible: false, width: 80 },
			{field:'orderMoney',title:'保函申请金额', width: 80 },
			
			{field:'eigenCode',title:'企业中征码(贷款卡号)', width: 80 },
			{field:'person',title:'单位负责人', width: 80 },
			{field:'telephone',title:'单位负责人电话', width: 80 },
			
			{field:'guaratorTable',title:'担保申请单',visible: false, width: 80 ,formatter:guaratorTableFormatter},
			{field:'orderVoucher',title:'保函文件', width: 80 ,formatter:orderVoucherFormatter},
			{field:'orderStatus',title:'订单状态', width: 80,formatter: orderStatusFormatter},
			{field:'payType',title:'支付类型',visible: false, width: 80,formatter: payTypeFormatter},
			{field:'orderDate',title:'订单创建时间', width: 80 },
			{field:'updateUesrName',title:'最后修改人', width: 80 },
			{field:'updateDate',title:'最后修改时间', width: 80 },
        ],
    },
    methods : {
        // 查询
        query : function(){
	        vm.reload(vm.q);
        },
        //查询子担保结构数据信息
        queryGuarator:function(){
        	$.get(baseURL + "/sys/user/queryGuarator", function(r){
        		vm.bondEnguarators = r.userEntities;
        	});
        },
        
        //选择办理机构
        selectGuarator: function(){
        	var rows = getSelectedRows();
	        // 只分配状态为待处理的订单
        	this.orderIds = [];
        	for ( var index in rows) {
				if (rows[index].orderStatus===1) {
					this.orderIds.push(rows[index].orderId);
				}
			}
        	if(this.orderIds.length==0){
        		alert("选择的所有订单不在待处理状态!");
        	}else{
        		$('#selectGuaratorModal').modal('show');
        	}
        },
        //选择机构
        changeGuarator: function(event){
        	vm.guaratorUuid = event.target.value;
        },
        //保存订单处理机构
        saveChangeGuarator: function(){
        	var data = [];
        	data.push({name:'guaratorUuid',value:vm.guaratorUuid});
        	data.push({name:'orderIds',value:vm.orderIds});
        	console.log(data);
        	$.post(baseURL + "/bond/bondorder/saveChangeGuarator",data, function(r){
        		$('#selectGuaratorModal').modal('hide');
        		vm.reload();
        	});
        },
        // 凭证生成
        voucher : function(){
	        var orderId = getSelectedRow().orderId;
	        var orderStatus = getSelectedRow().orderStatus;
	        // 状态为3才能执行
	        if(orderStatus === 3)
	        {
		        $.get(baseURL + "/bond/bondorder/voucher?orderId=" + orderId, function(r){
			        if(r.code === 0)
			        {
				        alert(r.msg, function(){
					        vm.reload();
				        });
			        }
			        else
			        {
				        alert(r.msg);
			        }
		        });
	        }
	        else
	        {
		        alert("该订单状态未支付!");
	        }
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
       
        // 导出请求
        exportPage : function(){
        	 $.postForm(baseURL + '/bond/bondenguarator/guaranteeOrderList', this.q, function(request){
   		       downloadExl(request.page.rows);
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
			    		$('#itemModal').modal('hide');	
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
       
        uploadBondPost : function(orderIds){
	        confirm('确定已经办理完成当前申请的保函？', function(){
		        $.syncPost(baseURL + "/bond/bondorder/uploadBond", JSON.stringify(orderIds), function(r){
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
        // 重新加载请求
        reload : function(params){
	        $.postForm(baseURL + '/bond/bondenguarator/guaranteeOrderList', params, function(request){
		        $("#table").bootstrapTable('load', request.page);
	        });
        }
    },
    // 创建完毕状态
    created : function(){
	    this.queryGuarator();
    }
});
