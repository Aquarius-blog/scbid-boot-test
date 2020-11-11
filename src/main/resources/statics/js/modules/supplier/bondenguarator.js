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
    result += "<a class='btn btn-xs green' onclick=\"select('" + row.guaratorId + "')\"  title='查看'><span class='glyphicon glyphicon-search'></span></a>";
    result += "<a class='btn btn-xs blue' onclick=\"update('" + row.guaratorId + "')\" title='编辑'><span class='glyphicon glyphicon-pencil'></span></a>";
    result += "<a class='btn btn-xs red' onclick=\"del('" + row.guaratorId + "')\" title='删除'><span class='glyphicon glyphicon-remove'></span></a>";
    return result;
}

//Vue函数体
var vm = new Vue({
	el:'#rrapp',
	data:{
		title: null,
		q: {
			guaratorId:null,
			guaratorUuid:null,
			guaratorName:null,
			guaratorScale:null,
			guaratorPhone:null,
			guaratorLicenseNo:null,
			guaratorLicenseImg:null,
			guaratorCapital:null,
			guaratorPostcode:null,
			guaratorSort:null,
			guaratorTaxpayerNo:null,
			guaratorRegNumber:null,
			guaratorLegalPhone:null,
			guaratorFaxes:null,
			guaratorBankAccount:null,
			guaratorBankNumber:null,
			guaratorAddress:null,
			guaratorIndustry:null,
			guaratorLegalPepre:null,
			guaratorEstabDate:null,
			guaratorOpenatingPeriod:null,
			guaratorRegAdress:null,
			guaratorCompanyType:null,
			guaratorStatus:null,
			guaratorRemarks:null,
			guaratorDate:null,
			guaratorUserId:null,
			updateUesrName:null,
			updateDate:null,
			},
		bondEnguarator: {
				guaratorId:null,
				guaratorUuid:null,
				guaratorName:null,
				guaratorScale:null,
				guaratorPhone:null,
				guaratorLicenseNo:null,
				guaratorLicenseImg:null,
				guaratorCapital:null,
				guaratorPostcode:null,
				guaratorSort:null,
				guaratorTaxpayerNo:null,
				guaratorRegNumber:null,
				guaratorLegalPhone:null,
				guaratorFaxes:null,
				guaratorBankAccount:null,
				guaratorBankNumber:null,
				guaratorAddress:null,
				guaratorIndustry:null,
				guaratorLegalPepre:null,
				guaratorEstabDate:null,
				guaratorOpenatingPeriod:null,
				guaratorRegAdress:null,
				guaratorCompanyType:null,
				guaratorStatus:null,
				guaratorRemarks:null,
				guaratorDate:null,
				guaratorUserId:null,
				updateUesrName:null,
				updateDate:null,
				},
		fields:[
			//{field:'guaratorId',title:'guaratorId', width: 50, key: true},
			//{field:'guaratorUuid',title:'全局uuid', width: 80 },
			{field:'guaratorName',title:'担保机构全称', width: 80 },
			//{field:'guaratorScale',title:'公司规模 0微型，1小型，2中型，3大型', width: 80 },
			//{field:'guaratorPhone',title:'担保机构公司电话', width: 80 },
			{field:'guaratorLicenseNo',title:'担保机构执照号', width: 80 },
			{field:'guaratorLicenseImg',title:'担保机构执照号图片', width: 80 },
			//{field:'guaratorCapital',title:'公司注册资本', width: 80 },
			//{field:'guaratorPostcode',title:'邮编', width: 80 },
			//{field:'guaratorSort',title:'公司性质', width: 80 },
			//{field:'guaratorTaxpayerNo',title:'纳税人识别号', width: 80 },
			{field:'guaratorRegNumber',title:'注册证号', width: 80 },
			//{field:'guaratorLegalPhone',title:'法人电话', width: 80 },
			//{field:'guaratorFaxes',title:'传真', width: 80 },
			//{field:'guaratorBankAccount',title:'开户行', width: 80 },
			//{field:'guaratorBankNumber',title:'银行账号', width: 80 },
			{field:'guaratorAddress',title:'公司地址', width: 80 },
			//{field:'guaratorIndustry',title:'行业', width: 80 },
			//{field:'guaratorLegalPepre',title:'法人代表', width: 80 },
			//{field:'guaratorEstabDate',title:'建立时间', width: 80 },
			//{field:'guaratorOpenatingPeriod',title:'营业期限', width: 80 },
			{field:'guaratorRegAdress',title:'注册地址', width: 80 },
			//{field:'guaratorCompanyType',title:'公司类型', width: 80 },
			//{field:'guaratorStatus',title:'担保机构状态', width: 80 },
			//{field:'guaratorRemarks',title:'备注', width: 80 },
			//{field:'guaratorDate',title:'担保机构创建时间', width: 80 },
			//{field:'guaratorUserId',title:'担保机构监管人', width: 80 },
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
			vm.bondEnguarator = {};
			$('#itemModal').modal('show');
		},
		//导入
        importPage: function(){
        	$('#importModal').modal('show');
        },
        //导入请求
        importPost: function(){
        	$.syncPost(baseURL + "/bond/bondenguarator/import", JSON.stringify(vm.fields), function(r){
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
        	
		    $.syncPost(baseURL + "/bond/bondenguarator/export", JSON.stringify(vm.fields), function(r){
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
			var guaratorId = row.guaratorId;
			if(guaratorId == null){
				return ;
			}
            vm.title = "修改";
            vm.itemPage(guaratorId);
		},
		//详情
		itemPage: function (guaratorId) {
        	 $('#itemModal').modal('show');
             vm.getInfo(guaratorId);
        },
        //新增OR修改
		saveOrUpdate: function (event) {
			var url = vm.bondEnguarator.guaratorId == null ? "/bond/bondenguarator/save" : "/bond/bondenguarator/update";
			$.syncPost(baseURL + url, JSON.stringify(vm.bondEnguarator), function(r){
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
            var guaratorIds = [];
            rows.forEach(function(value, index, array) {
            	guaratorIds.push(array[index].guaratorId);
			});
            if(guaratorIds == null){
                return ;
            }
            vm.delPost(guaratorIds);
		},
		//删除请求
		delPost: function (guaratorIds) {
        	confirm('确定要删除选中的记录？', function(){
        		$.syncPost(baseURL + "/bond/bondenguarator/delete", JSON.stringify(guaratorIds), function(r){
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
		getInfo: function(guaratorId){
			$.get(baseURL + "/bond/bondenguarator/info/"+guaratorId, function(r){
                vm.bondEnguarator = r.bondEnguarator;
            });
		},
		//重新加载请求
		reload: function (params) {
            $.postForm(baseURL + '/bond/bondensupplier/guarators', params, function(request){
        		$("#table").bootstrapTable('load',request.page);
        	});
		}
	},
	//创建完毕状态
    created: function(){
    	
    }
});