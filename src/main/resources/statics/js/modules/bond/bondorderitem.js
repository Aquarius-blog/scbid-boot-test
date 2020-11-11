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
    result += "<a class='btn btn-xs green' onclick=\"select('" + row.orderItemId + "')\"  title='查看'><span class='glyphicon glyphicon-search'></span></a>";
    result += "<a class='btn btn-xs blue' onclick=\"update('" + row.orderItemId + "')\" title='编辑'><span class='glyphicon glyphicon-pencil'></span></a>";
    result += "<a class='btn btn-xs red' onclick=\"del('" + row.orderItemId + "')\" title='删除'><span class='glyphicon glyphicon-remove'></span></a>";
    return result;
}

//Vue函数体
var vm = new Vue({
	el:'#rrapp',
	data:{
		title: null,
		q: {
			orderItemId:null,
			orderId:null,
			projectId:null,
			orderItemDate:null,
			},
		bondOrderItem: {
				orderItemId:null,
				orderId:null,
				projectId:null,
				orderItemDate:null,
				},
		fields:[
			{field:'orderItemId',title:'orderItemId', width: 50, key: true},
			{field:'orderId',title:'订单主键ID', width: 80 },
			{field:'projectId',title:'项目主键ID', width: 80 },
			{field:'orderItemDate',title:'订单明细创建时间', width: 80 },
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
			vm.bondOrderItem = {};
			$('#itemModal').modal('show');
		},
		//导入
        importPage: function(){
        	$('#importModal').modal('show');
        },
        //导入请求
        importPost: function(){
        	$.syncPost(baseURL + "/bond/bondorderitem/import", JSON.stringify(vm.fields), function(r){
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
        	
		    $.syncPost(baseURL + "/bond/bondorderitem/export", JSON.stringify(vm.fields), function(r){
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
			var orderItemId = row.orderItemId;
			if(orderItemId == null){
				return ;
			}
            vm.title = "修改";
            vm.itemPage(orderItemId);
		},
		//详情
		itemPage: function (orderItemId) {
        	 $('#itemModal').modal('show');
             vm.getInfo(orderItemId);
        },
        //新增OR修改
		saveOrUpdate: function (event) {
			var url = vm.bondOrderItem.orderItemId == null ? "/bond/bondorderitem/save" : "/bond/bondorderitem/update";
			$.syncPost(baseURL + url, JSON.stringify(vm.bondOrderItem), function(r){
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
            var orderItemIds = [];
            rows.forEach(function(value, index, array) {
            	orderItemIds.push(array[index].orderItemId);
			});
            if(orderItemIds == null){
                return ;
            }
            vm.delPost(orderItemIds);
		},
		//删除请求
		delPost: function (orderItemIds) {
        	confirm('确定要删除选中的记录？', function(){
        		$.syncPost(baseURL + "/bond/bondorderitem/delete", JSON.stringify(orderItemIds), function(r){
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
		getInfo: function(orderItemId){
			$.get(baseURL + "/bond/bondorderitem/info/"+orderItemId, function(r){
                vm.bondOrderItem = r.bondOrderItem;
            });
		},
		//重新加载请求
		reload: function (params) {
            $.postForm(baseURL + '/bond/bondorderitem/list', params, function(request){
        		$("#table").bootstrapTable('load',request.page);
        	});
		}
	},
	//创建完毕状态
    created: function(){
    	
    }
});