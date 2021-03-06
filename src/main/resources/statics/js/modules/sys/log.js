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
    result += "<a class='btn btn-xs green' onclick=\"select('" + row.logId + "')\"  title='查看'><span class='glyphicon glyphicon-search'></span></a>";
    result += "<a class='btn btn-xs blue' onclick=\"update('" + row.logId + "')\" title='编辑'><span class='glyphicon glyphicon-pencil'></span></a>";
    result += "<a class='btn btn-xs red' onclick=\"del('" + row.logId + "')\" title='删除'><span class='glyphicon glyphicon-remove'></span></a>";
    return result;
}

var vm = new Vue({
	el:'#rrapp',
	data:{
		q:{
			key: null
		},
		fields:[
			 {field:'logId',title:'', width: 50, key: true }
			,{field:'username',title:'用户名', width: 80 }
			,{field:'operation',title:'用户操作', width: 80 }
			,{field:'method',title:'请求方法', width: 80 }
			,{field:'params',title:'请求参数', width: 80 }
			,{field:'time',title:'执行时长(毫秒)', width: 80 }
			,{field:'ip',title:'IP地址', width: 80 }
			,{field:'createDate',title:'创建时间', width: 80 }
		],
	},
	methods: {
		query: function () {
			vm.reload(vm.q);
		},
		reload: function (params) {
			$.postForm(baseURL + '/sys/log/list',  params, function(request){
        		$("#table").bootstrapTable('load',request.page);
        	});
		}
	}
});