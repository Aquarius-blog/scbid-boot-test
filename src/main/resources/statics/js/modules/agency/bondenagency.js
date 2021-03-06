//每个模块功能权限设置
function actionFormatter(value, row, index) {
    var result = "";
    result += "<a class='btn btn-xs green' onclick=\"select('" + row.agencyId + "')\"  title='查看'><span class='glyphicon glyphicon-search'></span></a>";
    result += "<a class='btn btn-xs blue' onclick=\"update('" + row.agencyId + "')\" title='编辑'><span class='glyphicon glyphicon-pencil'></span></a>";
    result += "<a class='btn btn-xs red' onclick=\"del('" + row.agencyId + "')\" title='删除'><span class='glyphicon glyphicon-remove'></span></a>";
    return result;
}

//Vue函数体
var vm = new Vue({
	el:'#rrapp',
	data:{
		title: null,
		q: {
			agencyId:null,
			agencyUuid:null,
			agencyScale:null,
			agencyName:null,
			agencyPhone:null,
			agencyPostcode:null,
			agencyCapital:null,
			agencySort:null,
			agencyFaxes:null,
			agencyTaxpayerNo:null,
			agencyBankNumber:null,
			agencyAddress:null,
			agencyLicenseImg:null,
			agencyLicenseNo:null,
			agencyIndustry:null,
			agencyLegalPepre:null,
			agencyEstabDate:null,
			agencyOpenatingPeriod:null,
			agencyRegAdress:null,
			agencyCompanyType:null,
			agencyBankAccount:null,
			agencyRegNumber:null,
			agencyLegalPhone:null,
			agencyRemarks:null,
			agencyStatus:null,
			agencyDate:null,
			agencyUserId:null,
			updateUesrName:null,
			updateDate:null,
			},
		bondEnagency: {
				agencyId:null,
				agencyUuid:null,
				agencyScale:null,
				agencyName:null,
				agencyPhone:null,
				agencyPostcode:null,
				agencyCapital:null,
				agencySort:null,
				agencyFaxes:null,
				agencyTaxpayerNo:null,
				agencyBankNumber:null,
				agencyAddress:null,
				agencyLicenseImg:null,
				agencyLicenseNo:null,
				agencyIndustry:null,
				agencyLegalPepre:null,
				agencyEstabDate:null,
				agencyOpenatingPeriod:null,
				agencyRegAdress:null,
				agencyCompanyType:null,
				agencyBankAccount:null,
				agencyRegNumber:null,
				agencyLegalPhone:null,
				agencyRemarks:null,
				agencyStatus:null,
				agencyDate:null,
				agencyUserId:null,
				updateUesrName:null,
				updateDate:null,
				},
		fields:[
			//{field:'agencyId',title:'agencyId', width: 50, key: true},
			//{field:'agencyUuid',title:'担保机构UUID', width: 80 },
			//{field:'agencyScale',title:'公司规模 0微型，1小型，2中型，3大型', width: 80 },
			{field:'agencyName',title:'代理机构全称', width: 80 },
			{field:'agencyPhone',title:'代理机构公司电话', width: 80 },
			//{field:'agencyPostcode',title:'代理机构公司邮编', width: 80 },
			//{field:'agencyCapital',title:'代理机构公司注册资本', width: 80 },
			//{field:'agencySort',title:'代理机构执性质', width: 80 },
			//{field:'agencyFaxes',title:'代理机构传真', width: 80 },
			//{field:'agencyTaxpayerNo',title:'代理机构纳税人识别号', width: 80 },
			//{field:'agencyBankNumber',title:'银行账号', width: 80 },
			//{field:'agencyAddress',title:'供应商公司地址', width: 80 },
			{field:'agencyLicenseImg',title:'执照号图片', width: 80 },
			{field:'agencyLicenseNo',title:'执照号', width: 80 },
			//{field:'agencyIndustry',title:'行业', width: 80 },
			//{field:'agencyLegalPepre',title:'法人代表', width: 80 },
			//{field:'agencyEstabDate',title:'公司成立日期', width: 80 },
			//{field:'agencyOpenatingPeriod',title:'营业期限', width: 80 },
			{field:'agencyRegAdress',title:'注册地址', width: 80 },
			//{field:'agencyCompanyType',title:'公司类型', width: 80 },
			//{field:'agencyBankAccount',title:'开户行', width: 80 },
			//{field:'agencyRegNumber',title:'注册证号', width: 80 },
			//{field:'agencyLegalPhone',title:'法人电话', width: 80 },
			//{field:'agencyRemarks',title:'备注', width: 80 },
			//{field:'agencyStatus',title:'代理机构状态', width: 80 },
			//{field:'agencyDate',title:'代理机构创建时间', width: 80 },
			//{field:'agencyUserId',title:'代理机构监管人id', width: 80 },
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
			vm.bondEnagency = {};
			$('#itemModal').modal('show');
		},
		//导入
        importPage: function(){
        	$('#importModal').modal('show');
        },
        //导入请求
        importPost: function(){
        	$.syncPost(baseURL + "/bond/bondenagency/import", JSON.stringify(vm.fields), function(r){
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
        	
		    $.syncPost(baseURL + "/bond/bondenagency/export", JSON.stringify(vm.fields), function(r){
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
			var agencyId = row.agencyId;
			if(agencyId == null){
				return ;
			}
            vm.title = "修改";
            vm.itemPage(agencyId);
		},
		//详情
		itemPage: function (agencyId) {
        	 $('#itemModal').modal('show');
             vm.getInfo(agencyId);
        },
        //新增OR修改
		saveOrUpdate: function (event) {
			var url = vm.bondEnagency.agencyId == null ? "/bond/bondenagency/save" : "/bond/bondenagency/update";
			$.syncPost(baseURL + url, JSON.stringify(vm.bondEnagency), function(r){
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
            var agencyIds = [];
            rows.forEach(function(value, index, array) {
            	agencyIds.push(array[index].agencyId);
			});
            if(agencyIds == null){
                return ;
            }
            vm.delPost(agencyIds);
		},
		//删除请求
		delPost: function (agencyIds) {
        	confirm('确定要删除选中的记录？', function(){
        		$.syncPost(baseURL + "/bond/bondenagency/delete", JSON.stringify(agencyIds), function(r){
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
		getInfo: function(agencyId){
			$.get(baseURL + "/bond/bondenagency/info/"+agencyId, function(r){
                vm.bondEnagency = r.bondEnagency;
            });
		},
		//重新加载请求
		reload: function (params) {
            $.syncPost(baseURL + '/bond/bondenagency/list', JSON.stringify(params), function(request){
        		$("#table").bootstrapTable('load',request.page);
        	});
		}
	},
	//创建完毕状态
    created: function(){
    	var table = InitMainTable("#table",this.fields,baseURL + '/bond/bondenagency/list');
		table.init();
    }
});