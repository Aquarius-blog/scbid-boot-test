// 表格数据查询事件及分页查询事件
$(function(){
	if($("#table").length > 0)
	{
		$.InitMainTable("#table", vm.fields, function queryCallback(params){
			params = $.extend(params, vm.q);
		}, function pageCallback(params){
			params = $.extend(params, vm.q);
		});
		$('#table').bootstrapTable('toggleView');
	}
});


//担保申请单
function guaratorTableFormatter(value, row, index) {
	if (row.guaratorName=="成都银行") {
		return "<a  class='btn btn-xs green' onclick=\"openApplicationTableForId('"+ row.orderId+ "')\" ><span class='glyphicon glyphicon-search'></span>担保申请表</a>";
	}
	if (value === null) {
		return "无担保申请单";
	}
}

// 每个模块功能权限设置
function actionFormatter(value, row, index){
	var result = "";
	result += "<a class='btn btn-xs green' onclick=\"alert('" + row.orderId
	        + "')\"title='查看'><span class='glyphicon glyphicon-search'></span></a>";
	return result;
}
//申請
function openApplicationTableForId(orderId){
	window.open("/bond-admin/bond/templates/cdyh/applicationTable?orderId=" + orderId, "orderDpcuments",
	                align = "center",
	                "height=800, width=800, top=0, left=0, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no");
}

//打开凭证页面
function openOrderVoucher(orderId) {
	window.open("/bond-admin/bond/templates/cdyh/voucherTable?orderId="+orderId, "orderDpcuments", align = "center","height=800, width=800, top=0, left=0, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no");
}


// 订单状态
function newOrderStatusFormatter(value, row, index){
	
	if(value == 1)
	{
		color = '#4D4D4D';
		return '<a  style="color: ' + color + '">审核不通过</a>';
	}
	if(value == 2)
	{
		color = '#4D4D4D';
		return '<a  style="color: ' + color + '">审核通过</a>';
	}
	if(value == 3)
	{
		color = '#4D4D4D';
		return '<a  style="color: ' + color + '">已支付</a>';
	}
}

// 订单类型
function newOrderTypeFormatter(value, row, index){
	if(value == 1)
	{
		color = '#4D4D4D';
		return '<a  style="color: ' + color + '">A类订单</a>';
	}
	if(value == 2)
	{
		color = '#4D4D4D';
		return '<a  style="color: ' + color + '">B类订单</a>';
	}
	if(value == 3)
	{
		color = '#4D4D4D';
		return '<a  style="color: ' + color + '">C类订单</a>';
	}
}

//支付类型
function newPayTypeFormatter(value, row, index) {
	if (value == 1) {
		color = '#4D4D4D';
		return '<a  style="color: ' + color + '">支付宝</a>';
	}
	if (value == 2) {
		color = '#4D4D4D';
		return '<a  style="color: ' + color + '">微信</a>';
	}
	if (value == 3) {
		color = '#4D4D4D';
		return '<a  style="color: ' + color + '">银联</a>';
	}
}

//凭证查看
function newOrderVoucherFormatter(value, row, index) {
	if (value === null) {
		return "<a>未生成凭证</a>";
	}
	return "<a  class='btn btn-xs green' onclick=\"openOrderVoucher('"+ row.orderId+ "')\" ><span class='glyphicon glyphicon-search'></span>预览</a>";
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
            projectName : null,
        },
        alipayForm : null,
        fields : [
                {
                    field : 'supplierName',
                    title : '供应商',
                    width : 120
                }, {
                    field : 'projectName',
                    title : '项目名称',
                    width : 120
                }, {
                    field : 'agencyName',
                    title : '代理机构',
                    width : 120
                }, {
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
                    formatter : newOrderTypeFormatter
                }, {
                    title : '担保申请单',
                    width : 80,
                    formatter : guaratorTableFormatter
                }, {
                    field : 'orderVoucher',
                    title : '订单凭证',
                    width : 80,
                    formatter : newOrderVoucherFormatter
                }, {
                    field : 'orderStatus',
                    title : '订单状态',
                    width : 80,
                    formatter : newOrderStatusFormatter
                }, {
                    field : 'payType',
                    title : '支付类型',
                    width : 80,
                    formatter : newPayTypeFormatter
                }, {
                    field : 'orderDate',
                    title : '订单创建时间',
                    width : 80
                },
        ],
    },
    methods : {
        // 查询
        query : function(){
	        if(vm.q.orderNo != null && vm.q.orderNo != "")
	        {
		        vm.reload(vm.q.orderNo);
	        }
	        else
	        {
		        alert("请输入订单编号。。。")
	        }
	        
        },
        // 详情
        itemPage : function(orderId){
	        $('#itemModal').modal('show');
	        vm.getInfo(orderId);
        },
        // 重新加载请求
        reload : function(orderNo){
	        $.ajax({
	            type : "POST",
	            url : "/bond/bondorder/selectOrdersByOrderNo",
	            data : {
		            "orderNo" : orderNo
	            },
	            dataType : "json",
	            success : function(result){
		            vm.bondOrder = {
			            rows : [
				            result.bondOrder
			            ]
		            }
		            $("#table").bootstrapTable('load', vm.bondOrder);
	            }
	        });
        }
    },
    // 创建完毕状态
    created : function(){
	    
    }
});
