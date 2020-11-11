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
			jobId: null
		},
		fields: [			
            {field: 'logId',title: '日志ID',width: 50, key: true },
			{field: 'jobId',title: '任务ID',  width: 50},
			{field: 'beanName',title: 'bean名称', width: 60 },
			{field: 'methodName',title: '方法名称',  width: 60 },
			{field: 'params',title: '参数',  width: 60 },
			{field: 'status',title: '状态', width: 50, formatter: function(value, options, row){
				return value === 0 ? 
					'<span class="label label-success">成功</span>' :
					'<span class="label label-danger pointer" onclick="vm.showError('+row.logId+')">失败</span>';
			}},
			{name: 'times',title: '耗时(单位：毫秒)',  width: 70 },
			{name: 'createTime',title: '执行时间', width: 80 }
        ],
	},
	methods: {
		query: function () {
			vm.reload(vm.q);
		},
		showError: function(logId) {
			$.get(baseURL + "/sys/scheduleLog/info/"+logId, function(r){
				parent.layer.open({
				  title:'失败信息',
				  closeBtn:0,
				  content: r.log.error
				});
			});
		},
		back: function (event) {
			history.go(-1);
		},
		reload: function (params) {
			$.postForm(baseURL + '/sys/scheduleLog/list', params, function(request){
        		$("#table").bootstrapTable('load',request.page);
        	});
		}
	}
});

