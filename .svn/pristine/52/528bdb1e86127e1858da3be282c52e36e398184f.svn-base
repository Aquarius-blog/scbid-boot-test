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
    result += "<a class='btn btn-xs green' onclick=\"select('" + row.orderStatusId + "')\"  title='查看'><span class='glyphicon glyphicon-search'></span></a>";
    result += "<a class='btn btn-xs blue' onclick=\"update('" + row.orderStatusId + "')\" title='编辑'><span class='glyphicon glyphicon-pencil'></span></a>";
    result += "<a class='btn btn-xs red' onclick=\"del('" + row.orderStatusId + "')\" title='删除'><span class='glyphicon glyphicon-remove'></span></a>";
    return result;
}

//Vue函数体
var vm = new Vue({
	el:'#rrapp',
	data:{
		title: null,
		q: {
			orderStatusId:null,
			orderId:null,
			orderNo:null,
			orderStatus:null,
			orderStatusDate:null,
			updateUesrName:null,
			updateDate:null,
			},
		bondOrderStatus: {
				orderStatusId:null,
				orderId:null,
				orderNo:null,
				orderStatus:null,
				orderStatusDate:null,
				updateUesrName:null,
				updateDate:null,
				},
		fields:[
			{field:'orderStatusId',title:'orderStatusId', width: 50, key: true},
			{field:'orderId',title:'订单主键ID', width: 80 },
			{field:'orderNo',title:'订单编号', width: 80 },
			{field:'orderStatus',title:'订单状态', width: 80 },
			{field:'orderStatusDate',title:'订单状态记录创建时间', width: 80 },
			{field:'updateUesrName',title:'最后修改人', width: 80 },
			{field:'updateDate',title:'最后修改时间', width: 80 },
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
			vm.bondOrderStatus = {};
			$('#itemModal').modal('show');
		},
		//导入
        importPage: function(){
        	$('#importModal').modal('show');
        },
        //导入请求
        importPost: function(){
        	$.syncPost(baseURL + "/bond/bondorderstatus/import", JSON.stringify(vm.fields), function(r){
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
        	
		    $.syncPost(baseURL + "/bond/bondorderstatus/export", JSON.stringify(vm.fields), function(r){
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
			var orderStatusId = row.orderStatusId;
			if(orderStatusId == null){
				return ;
			}
            vm.title = "修改";
            vm.itemPage(orderStatusId);
		},
		//详情
		itemPage: function (orderStatusId) {
        	 $('#itemModal').modal('show');
             vm.getInfo(orderStatusId);
        },
        //新增OR修改
		saveOrUpdate: function (event) {
			var url = vm.bondOrderStatus.orderStatusId == null ? "/bond/bondorderstatus/save" : "/bond/bondorderstatus/update";
			$.syncPost(baseURL + url, JSON.stringify(vm.bondOrderStatus), function(r){
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
            var orderStatusIds = [];
            rows.forEach(function(value, index, array) {
            	orderStatusIds.push(array[index].orderStatusId);
			});
            if(orderStatusIds == null){
                return ;
            }
            vm.delPost(orderStatusIds);
		},
		//删除请求
		delPost: function (orderStatusIds) {
        	confirm('确定要删除选中的记录？', function(){
        		$.syncPost(baseURL + "/bond/bondorderstatus/delete", JSON.stringify(orderStatusIds), function(r){
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
		getInfo: function(orderStatusId){
			$.get(baseURL + "/bond/bondorderstatus/info/"+orderStatusId, function(r){
                vm.bondOrderStatus = r.bondOrderStatus;
            });
		},
		//重新加载请求
		reload: function (params) {
            $.postForm(baseURL + '/bond/bondorderstatus/list', params, function(request){
        		$("#table").bootstrapTable('load',request.page);
        	});
		}
	},
	//创建完毕状态
    created: function(){
    	
    }
});