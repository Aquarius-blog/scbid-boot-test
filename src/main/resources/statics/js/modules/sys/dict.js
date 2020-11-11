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
    result += "<a class='btn btn-xs green' onclick=\"select('" + row.dict_id + "')\"  title='查看'><span class='glyphicon glyphicon-search'></span></a>";
    result += "<a class='btn btn-xs blue' onclick=\"update('" + row.dict_id + "')\" title='编辑'><span class='glyphicon glyphicon-pencil'></span></a>";
    result += "<a class='btn btn-xs red' onclick=\"del('" + row.dict_id + "')\" title='删除'><span class='glyphicon glyphicon-remove'></span></a>";
    return result;
}

var vm = new Vue({
	el:'#rrapp',
	data:{
        q:{
        	dictName: null
        },
		showList: true,
		title: null,
		dict: {},
		fields:[			
			{field: 'dictName',title: '字典名称',  index: 'dict_name', width: 80 },
			{field: 'dictType',title: '字典类型',  index: 'dict_type', width: 80 }, 			
			{field: 'dictCode', title: '字典码',index: 'dict_code', width: 80 }, 			
			{field: 'dictValue',title: '字典值',  index: 'dict_value', width: 80 }, 			
			{field: 'orderNum',title: '排序',  index: 'order_num', width: 80 }, 			
			{field: 'remark',title: '备注',  index: 'remark', width: 80 },
			{field: 'delFlag',title: '是否删除',  index: 'del_flag', width: 80 }
		],
	},
	methods: {
		query: function () {
			vm.reload(vm.q);
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.dict = {};
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url = vm.dict.id == null ? "/sys/dict/save" : "/sys/dict/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.dict),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "/sys/dict/delete",
                    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								vm.reload();
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(id){
			$.get(baseURL + "/sys/dict/info/"+id, function(r){
                vm.dict = r.dict;
            });
		},
		reload: function (params) {
			$.postForm(baseURL + '/sys/dict/list', params, function(request){
        		$("#table").bootstrapTable('load',request.page);
        	});
		}
	}
});