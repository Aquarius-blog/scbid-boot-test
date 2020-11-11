//表格数据查询事件及分页查询事件
$(function () {
	if($("#table").length>0){ 
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
    result += "<a class='btn btn-xs green' onclick=\"select('" + row.listId + "')\"  title='查看'><span class='glyphicon glyphicon-search'></span></a>";
    result += "<a class='btn btn-xs blue' onclick=\"update('" + row.listId + "')\" title='编辑'><span class='glyphicon glyphicon-pencil'></span></a>";
    result += "<a class='btn btn-xs red' onclick=\"del('" + row.listId + "')\" title='删除'><span class='glyphicon glyphicon-remove'></span></a>";
    return result;
}

//Vue函数体
var vm = new Vue({
	el:'#rrapp',
	data:{
		q:{
				listId:null,
				creater:null,
				createTime:null,
				operateTime:null,
				operator:null,
				isDelete:null,
				domainAuth:null,
				creatorId:null,
				code:null,
				projectId:null,
				projectName:null,
				bidBookStartTime:null,
				bidBookEndTime:null,
				bidBookStyle:null,
				bidBookPrice:null,
				remark:null,
				projectNature:null,
				purchaseWay:null,
				saleStyle:null,
				openBidTime:null,
				bzjEndTime:null,
				infoId:null,
				purchaseFileUrl:null,
				attachmentUrl:null,
				isAllowedToMail:null,
				},
		title: null,
		saleProject: {
				listId:null,
				creater:null,
				createTime:null,
				operateTime:null,
				operator:null,
				isDelete:null,
				domainAuth:null,
				creatorId:null,
				code:null,
				projectId:null,
				projectName:null,
				bidBookStartTime:null,
				bidBookEndTime:null,
				bidBookStyle:null,
				bidBookPrice:null,
				remark:null,
				projectNature:null,
				purchaseWay:null,
				saleStyle:null,
				openBidTime:null,
				bzjEndTime:null,
				infoId:null,
				purchaseFileUrl:null,
				attachmentUrl:null,
				isAllowedToMail:null,
				},
		fields:[
			//{field:'listId',title:'listId', width: 50, key: true},
			//{field:'creater',title:'创建人', width: 80 },
			//{field:'createTime',title:'创建时间', width: 80 },
			//{field:'operateTime',title:'操作时间 ', width: 80 },
			//{field:'operator',title:'操作人 ', width: 80 },
			//{field:'isDelete',title:'是否删除[BLDeleteEnum] ', width: 80 },
			//{field:'domainAuth',title:'状态[BLStatusEnum]', width: 80 },
			//{field:'creatorId',title:'创建人ID', width: 80 },
			{field:'code',title:'采购项目编号', width: 80 },
			//{field:'projectId',title:'项目ID', width: 80 },
			{field:'projectName',title:'项目名称', width: 200 },
			{field:'bidBookStartTime',title:'标书售卖开始时间', width: 80 ,formatter:dateFormatter},
			{field:'bidBookEndTime',title:'标书售卖结束时间', width: 80,formatter:dateFormatter },
			{field:'bidBookStyle',title:'售卖方式', width: 80 },
			{field:'bidBookPrice',title:'标书售价', width: 80 },
			//{field:'remark',title:'备注', width: 80 },
			//{field:'projectNature',title:'项目性质', width: 80 },
			//{field:'purchaseWay',title:'采购方式', width: 80 },
			//{field:'saleStyle',title:'售卖方式[ApprovalSaleEnum]', width: 80 },
			{field:'openBidTime',title:'开标时间', width: 80 ,formatter:dateFormatter},
			{field:'bzjEndTime',title:'保证金收取截止时间', width: 80,formatter:dateFormatter }
			//{field:'infoId',title:'老OA ID', width: 80 },
			//{field:'purchaseFileUrl',title:'', width: 80 },
			//{field:'attachmentUrl',title:'', width: 80 },
			//{field:'isAllowedToMail',title:'是否允许邮寄', width: 80 },
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
			vm.saleProject = {};
			$("#saveOrUpdate").show();
			$('#itemModal').modal('show');
		},
		//导入
        importPage: function(){
        	$('#importModal').modal('show');
        },
        //导入请求
        importPost: function(){
        	$.syncPost(baseURL + "/manage/saleproject/importFile", JSON.stringify(vm.fields), function(r){
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
        exportPost: function(){
		    $.syncPost(baseURL + "/manage/saleproject/exportFile", JSON.stringify(vm.fields), function(r){
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
			var listId = row.listId;
			if(listId == null){
				return ;
			}
            vm.title = "修改";
            vm.itemPage(listId);
		},
		//详情
		itemPage: function (listId) {
        	 $('#itemModal').modal('show');
             vm.getInfo(listId);
        },
        //新增OR修改
		saveOrUpdate: function (event) {
			var url = vm.saleProject.listId == null ? "/manage/saleproject/save" : "/manage/saleproject/update";
			$.syncPost(baseURL + url, JSON.stringify(vm.saleProject), function(r){
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
            var listIds = [];
            rows.forEach(function(value, index, array) {
            	listIds.push(array[index].listId);
			});
            if(listIds == null){
                return ;
            }
            vm.delPost(listIds);
		},
		//删除请求
		delPost: function (listIds) {
        	confirm('确定要删除选中的记录？', function(){
        		$.syncPost(baseURL + "/manage/saleproject/delete", JSON.stringify(listIds), function(r){
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
		getInfo: function(listId){
			$.get(baseURL + "/manage/saleproject/info/"+listId, function(r){
                vm.saleProject = r.saleProject;
            });
		},
		//设置售卖项目为保函项目
		guarantee:function (){
			var rows = getSelectedRows();
            var listIds = [];
            var projectIds = [];
            rows.forEach(function(value, index, array) {
            	listIds.push(array[index].listId);
            	projectIds.push(array[index].projectId);
			});
            if(listIds == null||projectIds == null){
                return ;
            }
            vm.guaranteePost(listIds,projectIds);
		},
		//设置售卖项目为保函项目请求
		guaranteePost:function (listIds,projectIds){
			var params = {
				listIds:JSON.stringify(listIds),
				projectIds:JSON.stringify(projectIds)
			};
			confirm('确定要设置为保函项目？', function(){
        		$.postForm(baseURL + "/bond/bondenagency/guarantee", params, function(r){
        			if(r.code === 0){
    					var product = r.error;
    					var params = "";
    					for (var key in product){
    						var li = '<li>'+product[key]+'</li>';
    						params = params + li;
    					}
    					if (params.length!=0) {
    						params = params + "<li>已过保证金缴纳时间</li>";
    						alert(params);
    					}else{
    						alert('操作成功');
    					}
        	        }else{
        	        	alert(r.msg);
        	        }
        		});
        	});
		},
		//重新加载请求
		reload: function (params) {
            $.postForm(baseURL + '/manage/saleproject/list', params, function(request){
        		$("#table").bootstrapTable('load',request.page);
        	});
		}
	},
	//创建完毕状态
    created: function(){
    	
    }
});