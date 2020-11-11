// 表格数据查询事件及分页查询事件
$(function(){
	if($("#table").length > 0)
	{
		console.log($("#table"));
		$.InitMainTable("#table", vm.fields, function queryCallback(params){
			params = $.extend(params, vm.q);
			vm.reload(params);
		}, function pageCallback(params){
			params = $.extend(params, vm.q);
			vm.reload(params);
		});
		vm.reload(null);
	}
});

// 每个模块功能权限设置
function actionFormatter(value, row, index){
	var result = "";
	result += "<a class='btn btn-xs green' onclick=\"select('" + row.userId
	        + "')\"  title='查看'><span class='glyphicon glyphicon-search'></span></a>";
	result += "<a class='btn btn-xs blue' onclick=\"update('" + row.userId
	        + "')\" title='编辑'><span class='glyphicon glyphicon-pencil'></span></a>";
	result += "<a class='btn btn-xs red' onclick=\"del('" + row.userId
	        + "')\" title='删除'><span class='glyphicon glyphicon-remove'></span></a>";
	return result;
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
// Vue功能代码
var vm = new Vue({
    // 页面id
    el : '#rrapp',
    // 数据信息
    data : {
        q : {
            userId : null,
            roleId : null,
            roleName : null,
            entUuid : null,
            entName : null,
            loginNo : null,
            userSurname : null,
            userStatus : null
        },
        title : null,
        roleList : {},
        user : {
            userId : null,
            roleId : null,
            roleName : null,
            entUuid : null,
            entName : null,
            loginNo : null,
            userSurname : null,
            userStatus : null,
            roleIdList : []
        },
        fields : [
                {
                    field : 'userId',
                    title : '用户主键',
                    index : "user_id",
                    width : 45,
                    key : true
                },
                // { field: 'roleId',title: '角色主键', width: 75 },
                {
                    field : 'roleName',
                    title : '角色名称',
                    width : 75
                },
                // { field: 'entUuid',title: '所属公司主键', width: 75 },
                {
                    field : 'entName',
                    title : '所属公司',
                    width : 75
                },
                {
                    field : 'loginNo',
                    title : '登录账号',
                    width : 75
                },
                {
                    field : 'userSurname',
                    title : '用户姓',
                    width : 75
                },
                {
                    field : 'userName',
                    title : '用户名',
                    width : 75
                },
                {
                    field : 'userEmail',
                    title : '邮箱',
                    width : 90
                },
                {
                    field : 'userMobile',
                    title : '手机号',
                    width : 100
                },
                {
                    field : 'userStatus',
                    title : '状态',
                    width : 60,
                    formatter : function(value, options, row){
	                    return value === 0 ? '<span class="btn btn-warning">禁用</span>'
	                            : '<span class="btn btn-success">正常</span>';
                    }
                }, {
                    field : 'userTime',
                    title : '创建时间',
                    width : 85
                }, {
                    field : 'updateUesrName',
                    title : '最后修改人',
                    width : 85
                }, {
                    field : 'updateDate',
                    title : '最后修改时间',
                    width : 85
                }
        ],
    },
    // 函数
    methods : {
        // 查询
        query : function(){
	        // 查询条件
	        vm.reload(vm.q);
        },
        // 新增页面
        add : function(){
	        vm.title = "新增";
	        vm.roleList = {};
	        vm.user = {
	            userId : null,
	            roleId : null,
	            roleName : null,
	            entUuid : null,
	            entName : null,
	            loginNo : null,
	            userSurname : null,
	            userStatus : 1,
	            roleIdList : [],
	            deptId : null,
	            deptName : null,
	        };
	        // 获取角色信息
	        this.getRoleList();
	        $("#saveOrUpdate").show();
	        $('#itemModal').modal('show');
	        //获得部门
	        vm.getDept();
        },
        //功能权限分配
        menuTree: function () {
        	vm.title = "功能权限分配";
        	var selected = $('#table').bootstrapTable('getSelections');
            if (selected.length == 0) {
                alert("请选择一条记录");
                return null;
            } else {
                var userId = selected[0].userId;
                $('#menuTreeModal').modal('show');
                vm.getMenuTree(userId);
            }
        },
        //加载菜单树
        getMenuTree: function(userId) {
            $.get(baseURL + "/sys/menu/list", function(r){
                menu_ztree = $.fn.zTree.init($("#menuTree"), menu_setting, r);
                //展开所有节点
                menu_ztree.expandAll(true);

                if(userId != null){
                	vm.userId = userId;
                    vm.getRole(userId);
                }
            });
        },
        //获取角色明细
        getRole: function(userId){
            $.get(baseURL + "/sys/role/userId/"+userId, function(r){
                vm.role = r.role;
                //勾选角色所拥有的菜单
                var menuIds = vm.role.menuIdList;
                for(var i=0; i<menuIds.length; i++) {
                    var node = menu_ztree.getNodeByParam("menuId", menuIds[i]);
                    menu_ztree.checkNode(node, true, false);
                }
            });
        },
        //功能权限修改
        roleUpdate: function () {
        	 //获取选择的菜单
        	var url = "/sys/role/updateByUserId";
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
        	var data = [{name:"userId",value:vm.userId},{name:"role",value:JSON.stringify(vm.role)}];
        	 $.post(baseURL + url, data, function(r){
                 if(r.code === 0){
                     alert('操作成功', function(){
                         vm.reload();
                     });
                 }else{
                     alert(r.msg);
                 }
         	 });
        },
        // 导入
        importPage : function(){
	        $('#importModal').modal('show');
	        vm.importPost();
        },
        // 导入请求
        importPost : function(){
	        $.syncPost(baseURL + "/sys/user/import", JSON.stringify(vm.data), function(r){
		        if(r.code === 0)
		        {
			        alert('操作成功', function(){
				        $('#importModal').modal('hide');
				        vm.reload();
			        });
		        }
		        else
		        {
			        alert(r.msg);
		        }
	        });
        },
        // 导出
        exportPage : function(){
	        $('#exportModal').modal('show');
	        vm.importPost();
        },
        // 导出请求
        exportPost : function(){
	        $.syncPost(baseURL + "/sys/user/export", JSON.stringify(vm.data), function(r){
		        if(r.code === 0)
		        {
			        alert('操作成功', function(){
				        $('#exportModal').modal('hide');
				        vm.reload();
			        });
		        }
		        else
		        {
			        alert(r.msg);
		        }
	        });
        },
        // 加载所属公司
        getDept : function(){
	        $.get(baseURL + "/sys/dept/list", function(r){
		        var setting = {
		            showLine : true,
		            checkable : true
		        };
		        ztree = $.fn.zTree.init($("#deptTree"), setting, r);
		        var node = ztree.getNodeByParam("deptId", vm.user.deptId);
		        if(node != null)
		        {	
			        ztree.selectNode(node);
			        vm.user.deptName = node.name;
			        vm.user.deptId = node.id;
		        }
	        })
        },
        // 修改
        update : function(){
	        var row = getSelectedRow();
	        vm.title = "修改";
	        this.getRoleList();
	        vm.itemPage(row.userId);
        },
        // 明细页面
        itemPage : function(userId){
	        $('#itemModal').modal('show');
	        vm.getUser(userId);
	        // 获取角色信息
        },
        // 删除
        del : function(){
	        var rows = getSelectedRows();
	        var userIds = [];
	        rows.forEach(function(value, index, array){
		        userIds.push(array[index].userId);
	        });
	        vm.delPost(userIds);
        },
        // 删除请求
        delPost : function(userIds){
	        confirm('确定要删除选中的记录？', function(){
		        $.syncPost(baseURL + "/sys/user/delete", JSON.stringify(userIds), function(r){
			        if(r.code === 0)
			        {
				        alert('操作成功', function(){
					        vm.reload();
				        });
			        }
			        else
			        {
				        alert(r.msg);
			        }
		        });
	        });
        },
        // 保存和修改
        saveOrUpdate : function(){
	        var url = vm.user.userId == null ? "/sys/user/save" : "/sys/user/update";
	        $.syncPost(baseURL + url, JSON.stringify(vm.user), function(r){
		        if(r.code === 0)
		        {
			        alert('操作成功', function(){
				        vm.reload();
			        });
		        }
		        else
		        {
			        alert(r.msg);
		        }
	        });
        },
        // 解除锁定
        unlock : function(){
	        var rows = getSelectedRows();
	        var userIds = [];
	        rows.forEach(function(value, index, array){
		        userIds.push(array[index].userId);
	        });
	        vm.unlockPost(userIds);
        },
        // 解除锁定请求
        unlockPost : function(userIds){
	        confirm('确定要解除锁定选中的记录？', function(){
		        $.syncPost(baseURL + "/sys/user/unlock", JSON.stringify(userIds), function(r){
			        if(r.code === 0)
			        {
				        alert('操作成功', function(){
					        vm.reload();
				        });
			        }
			        else
			        {
				        alert(r.msg);
			        }
		        });
	        });
        },
        // 密码重置
        resetPassword : function(){
	        var rows = getSelectedRows();
	        var userIds = [];
	        rows.forEach(function(value, index, array){
		        userIds.push(array[index].userId);
	        });
	        vm.resetPasswordPost(userIds);
        },
        // 密码重置请求
        resetPasswordPost : function(userIds){
	        confirm('确定要密码重置选中的记录？', function(){
		        $.syncPost(baseURL + "/sys/user/resetPassword", JSON.stringify(userIds), function(r){
			        if(r.code === 0)
			        {
				        alert('操作成功', function(){
					        vm.reload();
				        });
			        }
			        else
			        {
				        alert(r.msg);
			        }
		        });
	        });
        },
        // 获取用户信息
        getUser : function(userId){
	        $.get(baseURL + "/sys/user/info/" + userId, function(r){
		        vm.user = r.user;
		        vm.user.password = null;
		        // vm.getDept();
	        });
        },
        // 获取权限列表
        getRoleList : function(){
	        $.get(baseURL + "/sys/role/select", function(r){
		        console.log(r.list);
		        vm.roleList = r.list;
	        });
        },
        deptTree : function(){
	        layer.open({
	            type : 1,
	            offset : '50px',
	            skin : 'layui-layer-molv',
	            title : "选择部门",
	            area : [
	                    '300px', '450px'
	            ],
	            shade : 0,
	            shadeClose : false,
	            content : jQuery("#deptLayer"),
	            btn : [
	                    '确定', '取消'
	            ],
	            btn1 : function(index){
		            var node = ztree.getSelectedNodes();
		            // 选择上级部门
		            vm.user.deptId = node[0].id;
		            vm.user.deptName = node[0].name;
		            jQuery("#deptLayer").hide();
		            layer.close(index);
	            }
	        });
        },
        // 重新加载数据
        reload : function(params){
	        $.postForm(baseURL + '/sys/user/list', params, function(request){
		        $("#table").bootstrapTable('load', request.page);
	        });
        }
    },
    // 创建完毕状态
    created : function(){
	    
    }
});
