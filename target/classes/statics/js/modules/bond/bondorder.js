//表格数据查询事件及分页查询事件
$(function () {
	if($("#table").length>0){ 
		console.log($("#table"));
		$.InitMainTable("#table",vm.fields,function queryCallback(params){
			params = $.extend(params, vm.q);
			vm.reload(params);
		},function pageCallback(params){
			params = $.extend(params, vm.q);
			vm.reload(params);
		});
		vm.reload(null);
	}
});


//每个模块功能权限设置
function actionFormatter(value, row, index) {
    var result = "";
    result += "<a class='btn btn-xs green' onclick=\"select('" + row.orderId + "')\"  title='查看'><span class='glyphicon glyphicon-search'></span></a>";
    result += "<a class='btn btn-xs blue' onclick=\"update('" + row.orderId + "')\" title='编辑'><span class='glyphicon glyphicon-pencil'></span></a>";
    result += "<a class='btn btn-xs red' onclick=\"del('" + row.orderId + "')\" title='删除'><span class='glyphicon glyphicon-remove'></span></a>";
    return result;
}

//Vue函数体
var vm = new Vue({
	el:'#rrapp',
	data:{
		title: null,
		q: {
			orderId:null,
			supplierId:null,
			agencyId:null,
			guaratorId:null,
			orderNo:null,
			orderMoney:null,
			orderType:null,
			orderVoucher:null,
			orderStatus:null,
			payType:null,
			orderDate:null,
			updateUesrName:null,
			updateDate:null,
			},
		bondOrder: {
				orderId:null,
				supplierId:null,
				agencyId:null,
				guaratorId:null,
				orderNo:null,
				orderMoney:null,
				orderType:null,
				orderVoucher:null,
				orderStatus:null,
				payType:null,
				orderDate:null,
				updateUesrName:null,
				updateDate:null,
				},
		fields:[
			//{field:'orderId',title:'orderId', width: 50, key: true},
			//{field:'supplierId',title:'供应商主键ID', width: 80 },
			//{field:'agencyId',title:'代理机构主键ID', width: 80 },
			//{field:'guaratorId',title:'担保机构主键ID', width: 80 },
			{field:'orderNo',title:'订单编号', width: 80 },
			{field:'orderMoney',title:'订单金额', width: 80 },
			{field:'orderType',title:'订单类型', width: 80,formatter:orderTypeFormatter},
			{field:'orderVoucher',title:'订单凭证', width: 80,formatter:orderVoucherFormatter},
			{field:'orderStatus',title:'订单状态', width: 80,formatter: orderStatusFormatter},
			{field:'payType',title:'支付类型', width: 80,formatter: payTypeFormatter},
			{field:'orderDate',title:'订单创建时间', width: 80 },
			//{field:'updateUesrName',title:'最后修改人', width: 80 },
			//{field:'updateDate',title:'最后修改时间', width: 80 },
		],
	},
	methods: {
		//查询
		query: function () {
			vm.reload(vm.q);
		},
		//新增
		add: function(){
			vm.title = "新增";
			vm.bondOrder = {};
			$('#itemModal').modal('show');
		},
		//导入
        importPage: function(){
        	$('#importModal').modal('show');
        },
        //导入请求
        importPost: function(){
        	$.syncPost(baseURL + "/bond/bondorder/import", JSON.stringify(vm.fields), function(r){
    			if(r.code === 0){
    				alert('操作成功', function(){
    					$('#importModal').modal('hide');
    	                vm.reload();
    	            });
    	        }else{
    	        	alert(r.msg);
    	        }
    		});	
        },
        //导出
        exportPage: function(){
		   $('#exportModal').modal('show');
		},
		//导出请求
        exportPage: function(){
        	
		    $.syncPost(baseURL + "/bond/bondorder/export", JSON.stringify(vm.fields), function(r){
    			if(r.code === 0){
    				alert('操作成功', function(){
    					$('#exportModal').modal('hide');
    	                vm.reload();
    	            });
    	        }else{
    	        	alert(r.msg);
    	        }
    		});	
		},
		//修改
		update: function (event) {
			var row = getSelectedRow();
			var orderId = row.orderId;
			if(orderId == null){
				return ;
			}
            vm.title = "修改";
            vm.itemPage(orderId);
		},
		//详情
		itemPage: function (orderId) {
        	 $('#itemModal').modal('show');
             vm.getInfo(orderId);
        },
        //新增OR修改
		saveOrUpdate: function (event) {
			var url = vm.bondOrder.orderId == null ? "/bond/bondorder/save" : "/bond/bondorder/update";
			$.syncPost(baseURL + url, JSON.stringify(vm.bondOrder), function(r){
        		if(r.code === 0){
        			alert('操作成功', function(){
                        vm.reload();
                    });
                }else{
                	alert(r.msg);
                }
        	});
		},
		//删除
		del: function (event) {
			var rows = getSelectedRows();
            var orderIds = [];
            rows.forEach(function(value, index, array) {
            	orderIds.push(array[index].orderId);
			});
            if(orderIds == null){
                return ;
            }
            vm.delPost(orderIds);
		},
		//删除请求
		delPost: function (orderIds) {
        	confirm('确定要删除选中的记录？', function(){
        		$.syncPost(baseURL + "/bond/bondorder/delete", JSON.stringify(orderIds), function(r){
        			if(r.code === 0){
        				alert('操作成功', function(){
        	                vm.reload();
        	            });
        	        }else{
        	        	alert(r.msg);
        	        }
        		});
        	});
        },
        //明细请求
		getInfo: function(orderId){
			$.get(baseURL + "/bond/bondorder/info/"+orderId, function(r){
                vm.bondOrder = r.bondOrder;
            });
		},
		//重新加载请求
		reload: function (params) {
            $.postForm(baseURL + '/bond/bondorder/list', params, function(request){
        		$("#table").bootstrapTable('load',request.page);
        	});
		}
	},
	//创建完毕状态
    created: function(){
    	
    }
});