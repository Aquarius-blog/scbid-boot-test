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
    result += "<a class='btn btn-xs green' onclick=\"select('" + row.supplierId + "')\"  title='查看'><span class='glyphicon glyphicon-search'></span></a>";
    /*result += "<a class='btn btn-xs blue' onclick=\"update('" + row.supplierId + "')\" title='编辑'><span class='glyphicon glyphicon-pencil'></span></a>";
    result += "<a class='btn btn-xs red' onclick=\"del('" + row.supplierId + "')\" title='删除'><span class='glyphicon glyphicon-remove'></span></a>";*/
    return result;
}

//Vue函数体
var vm = new Vue({
	el:'#rrapp',
	data:{
		q:{
			supplierId:null,
			supplierUuid:null,
			supplierScale:null,
			supplierName:null,
			supplierPhone:null,
			supplierPostcode:null,
			supplierCapital:null,
			supplierSort:null,
			supplierTaxpayerNo:null,
			supplierFaxes:null,
			supplierLegalPhone:null,
			supplierRegNumber:null,
			supplierBankNumber:null,
			supplierBankAccount:null,
			supplierCompanyType:null,
			supplierRegAdress:null,
			supplierOpenatingPeriod:null,
			supplierEstabDate:null,
			supplierLegalPepre:null,
			supplierIndustry:null,
			supplierAddress:null,
			supplierLicenseNo:null,
			supplierLicenseImg:null,
			supplierRemarks:null,
			supplierStatus:null,
			supplierDate:null,
			supplierUserId:null,
			updateUesrName:null,
			updateDate:null
		},
		title: null,
		bondEnsupplier: {
				supplierId:null,
				supplierUuid:null,
				supplierScale:null,
				supplierName:null,
				supplierPhone:null,
				supplierPostcode:null,
				supplierCapital:null,
				supplierSort:null,
				supplierTaxpayerNo:null,
				supplierFaxes:null,
				supplierLegalPhone:null,
				supplierRegNumber:null,
				supplierBankNumber:null,
				supplierBankAccount:null,
				supplierCompanyType:null,
				supplierRegAdress:null,
				supplierOpenatingPeriod:null,
				supplierEstabDate:null,
				supplierLegalPepre:null,
				supplierIndustry:null,
				supplierAddress:null,
				supplierLicenseNo:null,
				supplierLicenseImg:null,
				supplierRemarks:null,
				supplierStatus:null,
				supplierDate:null,
				supplierUserId:null,
				updateUesrName:null,
				updateDate:null,
				},
		fields:[
			//{field:'supplierId',title:'supplierId', width: 50, key: true},
			//{field:'supplierUuid',title:'供应商uuid 与oa 系统对接', width: 80 },
			//{field:'supplierScale',title:'公司规模 0微型，1小型，2中型，3大型', width: 80 },
			{field:'supplierName',title:'供应商全称', width: 120 },
			//{field:'supplierPhone',title:'供应商公司电话', width: 80 },
			//{field:'supplierPostcode',title:'邮编', width: 80 },
			//{field:'supplierCapital',title:'供应商公司注册资本', width: 80 },
			//{field:'supplierSort',title:'公司性质', width: 80 },
			{field:'supplierTaxpayerNo',title:'纳税人识别号', width: 80 },
			//{field:'supplierFaxes',title:'传真', width: 80 },
			{field:'supplierLegalPhone',title:'法人电话', width: 80 },
			//{field:'supplierRegNumber',title:'注册证号', width: 80 },
			{field:'supplierBankNumber',title:'银行账号', width: 80 },
			{field:'supplierBankAccount',title:'开户行', width: 120 },
			//{field:'supplierCompanyType',title:'公司类型', width: 80 },
			//{field:'supplierRegAdress',title:'注册地址', width: 120 },
			{field:'supplierOpenatingPeriod',title:'营业期限', width: 80 },
			{field:'supplierEstabDate',title:'供应商公司成立日期', width: 80 },
			{field:'supplierLegalPepre',title:'法人代表', width: 80 },
			//{field:'supplierIndustry',title:'行业', width: 80 },
			{field:'supplierAddress',title:'供应商公司地址', width: 80 },
			//{field:'supplierLicenseNo',title:'供应商执照号', width: 80 },
			//{field:'supplierLicenseImg',title:'供应商执照号图片', width: 80 },
			//{field:'supplierRemarks',title:'供应商备注', width: 80 },
			//{field:'supplierStatus',title:'供应商状态(是否通过审核)', width: 80 },
			//{field:'supplierDate',title:'供应商创建时间', width: 80 },
			//{field:'supplierUserId',title:'供应商监管人ID', width: 80 },
			//{field:'updateUesrName',title:'最后修改人', width: 80 },
			//{field:'updateDate',title:'最后修改时间', width: 80 }
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
			vm.bondEnsupplier = {};
			$('#itemModal').modal('show');
		},
		//导入
        importPage: function(){
        	$('#importModal').modal('show');
        },
        //导入请求
        importPost: function(){
        	$.syncPost(baseURL + "/bond/bondensupplier/import", JSON.stringify(vm.fields), function(r){
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
		//导出请求
        exportPage: function(){
        	 $.postForm(baseURL + '/bond/bondenguarator/queryGuaranteeSupplier', this.q, function(request){
   		       downloadExl(request.page.rows);
   	        });
		},
		//修改
		update: function (event) {
			var row = getSelectedRow();
			var supplierId = row.supplierId;
			if(supplierId == null){
				return ;
			}
            vm.title = "修改";
            vm.itemPage(supplierId);
		},
		//详情
		itemPage: function (supplierId) {
        	 $('#itemModal').modal('show');
             vm.getInfo(supplierId);
        },
        //新增OR修改
		saveOrUpdate: function (event) {
			var url = vm.bondEnsupplier.supplierId == null ? "/bond/bondensupplier/save" : "/bond/bondensupplier/update";
			$.syncPost(baseURL + url, JSON.stringify(vm.bondEnsupplier), function(r){
        		if(r.code === 0){
        			alert('操作成功', function(){
        				$('#itemModal').modal('hide');
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
            var supplierIds = [];
            rows.forEach(function(value, index, array) {
            	supplierIds.push(array[index].supplierId);
			});
            if(supplierIds == null){
                return ;
            }
            vm.delPost(supplierIds);
		},
		//删除请求
		delPost: function (supplierIds) {
        	confirm('确定要删除选中的记录？', function(){
        		$.syncPost(baseURL + "/bond/bondensupplier/delete", JSON.stringify(supplierIds), function(r){
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
		getInfo: function(supplierId){
			$.get(baseURL + "/bond/bondensupplier/info/"+supplierId, function(r){
                vm.bondEnsupplier = r.bondEnsupplier;
            });
		},
		//重新加载请求
		reload: function (params) {
			 $.postForm(baseURL + '/bond/bondenguarator/queryGuaranteeSupplier',params, function(request){
        		$("#table").bootstrapTable('load',request.page);
        	});
		}
	},
	//创建完毕状态
    created: function(){
    	
    }
});