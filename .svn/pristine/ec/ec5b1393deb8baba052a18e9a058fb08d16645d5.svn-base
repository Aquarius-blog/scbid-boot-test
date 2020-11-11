//表格数据查询事件及分页查询事件

var Menu = {
    id: "roleTable",
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Menu.initColumn = function () {
    var columns = [
        {field: 'selectItem', radio: true},
        { title: '角色ID', field: 'roleId', index: "role_id", width: 45, key: true },
        { title: '角色名称', field: 'roleName', index: "role_name", width: 75 },
        { title: '备注', field: 'remark', width: 100 },
        { title: '创建时间', field: 'createTime', index: "create_time", width: 80}]
    return columns;
};

$(function () {
	 var colunms = Menu.initColumn();
	 var table = new TreeTable(Menu.id, baseURL + "/sys/role/list", colunms);
	 table.setExpandColumn(2);
     table.setIdField("roleId");
     table.setCodeField("roleId");
     table.setParentCodeField("parentId");
     table.setExpandAll(false);
     table.init();
     Menu.table = table;
});

//每个模块功能权限设置
function actionFormatter(value, row, index) {
    var result = "";
    result += "<a class='btn btn-xs green' onclick=\"select('" + row.roleId + "')\"  title='查看'><span class='glyphicon glyphicon-search'></span></a>";
    result += "<a class='btn btn-xs blue' onclick=\"update('" + row.roleId + "')\" title='编辑'><span class='glyphicon glyphicon-pencil'></span></a>";
    return result;
}

function getMenuId () {
    var selected = $('#roleTable').bootstrapTreeTable('getSelections');
    if (selected.length == 0) {
        alert("请选择一条记录");
        return null;
    } else {
        return selected[0].id;
    }
}

//菜单树
var menu_ztree;
var menu_setting = {
    data: {
        simpleData: {
            enable: true,
            idKey: "menuId",
            pIdKey: "parentId",
            rootPId: -1
        },
        key: {
            url:"nourl"
        }
    },
    check:{
        enable:true,
        nocheckInherit:true
    }
};
//Vue功能代码
var vm = new Vue({
    el:'#rrapp',
    data:{
    	q:{
    		roleId:null,
        	roleName:null,
        	remark:null,
        	createTime:null
        },
        title:null,
        role:{
        	roleId:null,
        	roleName:null,
        	remark:null,
        	createTime:null
        },
    	fields:[
    		{ title: '角色ID', field: 'roleId', index: "role_id", width: 45, key: true },
            { title: '角色名称', field: 'roleName', index: "role_name", width: 75 },
            { title: '备注', field: 'remark', width: 100 },
            { title: '创建时间', field: 'createTime', index: "create_time", width: 80}
            ]
    },
    methods: {
        query: function () {
            vm.reload(vm.q);
        },
        add: function(){
            vm.title = "新增";
            vm.role = {roleId:null,roleName:null,remark:null,createTime:null};
            $("#saveOrUpdate").show();
            $('#itemModal').modal('show');
        },
        //功能权限分配
        menuTree: function () {
        	vm.title = "功能权限分配";
        	var roleId = getMenuId();
            if(roleId == null){
                return ;
            }
            $('#menuTreeModal').modal('show');
            vm.getMenuTree(roleId);
        },
        update: function () {
            var roleId = getMenuId();
            if(roleId == null){
                return ;
            }
            vm.title = "修改";
            vm.itemPage(roleId);
        },
        //明细页面
        itemPage: function (roleId) {
        	 $('#itemModal').modal('show');
             vm.getRoleInfo(roleId);//获取角色信息
        },
        //删除
        del: function () {
        	var rows = getSelectedRows("roleTable");
	        var userIds = [];
	        rows.forEach(function(value, index, array) {
	            userIds.push(array[index].userId);
			});
	        vm.delPost(userIds);
        },
       //删除请求
       delPost: function (roleIds) {  
            confirm('确定要删除选中的记录？', function(){
            	$.syncPost(baseURL + "/sys/role/delete", JSON.stringify(roleIds), function(r){
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
        //获取角色明细
        getRoleInfo: function(roleId){
            $.get(baseURL + "/sys/role/info/"+roleId, function(r){
                vm.role = r.role;
            });
        },
        //获取角色明细
        getRole: function(roleId){
            $.get(baseURL + "/sys/role/info/"+roleId, function(r){
                vm.role = r.role;

                //勾选角色所拥有的菜单
                var menuIds = vm.role.menuIdList;
                for(var i=0; i<menuIds.length; i++) {
                    var node = menu_ztree.getNodeByParam("menuId", menuIds[i]);
                    menu_ztree.checkNode(node, true, false);
                }
            });
        },
        //角色新增和修改
        saveOrUpdate: function () {
        	console.log(vm.role);
        	
        	var url = vm.role.roleId  == null ? "/sys/role/save" : "/sys/role/update";
        	vm.saveOrUpdatePost(url);//调用请求
        },
        //功能权限修改
        roleUpdate: function () {
        	 //获取选择的菜单
        	var url = vm.role.roleId == null ? "/sys/role/save" : "/sys/role/update";
        	//获取选中的数据
            var nodes = menu_ztree.getCheckedNodes(true);
            var menuIdList = new Array();
            for(var i=0; i<nodes.length; i++) {
                menuIdList.push(nodes[i].menuId);
            }
            vm.role.menuIdList = menuIdList;

            vm.saveOrUpdatePost(url);//调用请求
        },
        //新增和修改请求
        saveOrUpdatePost:function(url) {
        	 $.syncPost(baseURL + url, JSON.stringify(vm.role), function(r){
                 if(r.code === 0){
                     alert('操作成功', function(){
                         vm.reload();
                     });
                 }else{
                     alert(r.msg);
                 }
         	 });
        },
        //加载菜单树
        getMenuTree: function(roleId) {
            $.get(baseURL + "/sys/menu/list", function(r){
                menu_ztree = $.fn.zTree.init($("#menuTree"), menu_setting, r);
                //展开所有节点
                menu_ztree.expandAll(true);

                if(roleId != null){
                    vm.getRole(roleId);
                }
            });
        },
        //刷新列表数据
        reload: function (params) {
        	$.postForm(baseURL + '/sys/role/list',params, function(request){
        		$("#roleTable").bootstrapTable('load',request.page);
        	});
        }
    },
    //创建完毕状态
    created: function(){
    	
    }
});