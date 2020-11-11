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
			isDelete:null,
			operator:null,
			operateTime:null,
			creater:null,
			createTime:null,
			domainAuth:null,
			remark:null,
			projectId:null,
			projectName:null,
			packageId:null,
			supplierId:null,
			supplierName:null,
			supplierLinkmanId:null,
			supplierLinkman:null,
			invoiceNumber:null,
			type:null,
			receiptNumber:null,
			isPayTheDeposit:null,
			marginSource:null,
			tenderNewSource:null,
			marginOther:null,
			tenderNewOther:null,
			depositAmount:null,
			isPending:null,
			enderNewOther:null,
			creatorId:null,
			billsStatus:null,
			isJoinOpenBid:null,
			channelSerialNo:null,
			payStyle:null,
			saleOrderId:null,
			saleOrder:null,
		  },
		title: null,
		tenderBidBookSaleRecord: {
				listId:null,
				isDelete:null,
				operator:null,
				operateTime:null,
				creater:null,
				createTime:null,
				domainAuth:null,
				remark:null,
				projectId:null,
				projectName:null,
				packageId:null,
				supplierId:null,
				supplierName:null,
				supplierLinkmanId:null,
				supplierLinkman:null,
				invoiceNumber:null,
				type:null,
				receiptNumber:null,
				isPayTheDeposit:null,
				marginSource:null,
				tenderNewSource:null,
				marginOther:null,
				tenderNewOther:null,
				depositAmount:null,
				isPending:null,
				enderNewOther:null,
				creatorId:null,
				billsStatus:null,
				isJoinOpenBid:null,
				channelSerialNo:null,
				payStyle:null,
				saleOrderId:null,
				saleOrder:null,
				},
		fields:[
			//{field:'listId',title:'listId', width: 50, key: true},
			//{field:'isDelete',title:'是否被删除', width: 80 },
			//{field:'operator',title:'操作人', width: 80 },
			//{field:'operateTime',title:'操作时间', width: 80 },
			//{field:'creater',title:'创建人', width: 80 },
			//{field:'createTime',title:'创建时间', width: 80 },
			//{field:'domainAuth',title:'域权限', width: 80 },
			//{field:'remark',title:'备注', width: 80 },
			//{field:'projectId',title:'项目id', width: 80 },
			{field:'projectName',title:'项目名称', width: 200 },
			//{field:'packageId',title:'分包id', width: 80 },
			//{field:'supplierId',title:'供应商id', width: 80 },
			{field:'supplierName',title:'供应商', width: 120 },
			//{field:'supplierLinkmanId',title:'供应商联系人id', width: 80 },
			{field:'supplierLinkman',title:'供应商联系人', width: 80 },
			{field:'invoiceNumber',title:'发票号', width: 80 },
			//{field:'type',title:'信息类型,线上售卖还是线下售卖', width: 80 },
			//{field:'receiptNumber',title:'发票号', width: 80 },
			{field:'isPayTheDeposit',title:'是否缴纳保证金', width: 80 },
			{field:'marginSource',title:'保证金来源', width: 80 },
			//{field:'tenderNewSource',title:'标书款来源', width: 80 },
			//{field:'marginOther',title:'保证金来源的其他选择', width: 80 },
			//{field:'tenderNewOther',title:'标书款来源的其他', width: 80 },
			//{field:'depositAmount',title:'保证金金额', width: 80 },
			//{field:'isPending',title:'是否是待处理', width: 80 },
			//{field:'enderNewOther',title:'标书款来源其他', width: 80 },
			//{field:'creatorId',title:'创建人ID', width: 80 },
			//{field:'billsStatus',title:'是否生成了退还单【BLWhetherEnum】', width: 80 },
			//{field:'isJoinOpenBid',title:'是否参加开标 BLWhetherEnum', width: 80 },
			//{field:'channelSerialNo',title:'保证金交易流水', width: 80 },
			//{field:'payStyle',title:'支付方式 PayTypeEnum', width: 80 },
			//{field:'saleOrderId',title:'', width: 80 },
			//{field:'saleOrder',title:'订单编号', width: 80 },
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
			vm.tenderBidBookSaleRecord = {};
			$("#saveOrUpdate").show();
			$('#itemModal').modal('show');
		},
		//导入
        importPage: function(){
        	$('#importModal').modal('show');
        },
        //导入请求
        importPost: function(){
        	$.syncPost(baseURL + "/manage/tenderbidbooksalerecord/importFile", JSON.stringify(vm.fields), function(r){
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
		    $.syncPost(baseURL + "/manage/tenderbidbooksalerecord/exportFile", JSON.stringify(vm.fields), function(r){
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
			var url = vm.tenderBidBookSaleRecord.listId == null ? "/manage/tenderbidbooksalerecord/save" : "/manage/tenderbidbooksalerecord/update";
			$.syncPost(baseURL + url, JSON.stringify(vm.tenderBidBookSaleRecord), function(r){
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
        		$.syncPost(baseURL + "/manage/tenderbidbooksalerecord/delete", JSON.stringify(listIds), function(r){
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
			$.get(baseURL + "/manage/tenderbidbooksalerecord/info/"+listId, function(r){
                vm.tenderBidBookSaleRecord = r.tenderBidBookSaleRecord;
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
        				alert('操作成功', function(){
        	                vm.reload();
        	            });
        	        }else{
        	        	alert(r.msg);
        	        }
        		});
        	});
		},
		//重新加载请求
		reload: function (params) {
            $.postForm(baseURL + '/manage/tenderbidbooksalerecord/list', params, function(request){
        		$("#table").bootstrapTable('load',request.page);
        	});
		}
	},
	//创建完毕状态
    created: function(){
    	
    }
});