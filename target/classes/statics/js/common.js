var baseURL = "../../";
var $tableId;
var $table;
// 工具集合Tools
window.T = {};

// 获取请求参数
// 使用示例
// location.href = http://localhost:8080/index.html?id=123
// T.p('id') --> 123;
var url = function(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null;
};
T.p = url;

// 全局配置
$.ajaxSetup({
	dataType : "json",
	cache : false
});

// 重写alert
window.alert = function(msg, callback) {
	parent.layer.alert(msg, function(index) {
		parent.layer.close(index);
		if (typeof (callback) === "function") {
			callback("ok");
		}
	});
}

// 重写confirm式样框
window.confirm = function(msg, callback) {
	parent.layer.confirm(msg, {
		btn : [ '确定', '取消' ]
	}, function(index) {// 确定事件
		parent.layer.close(index);
		if (typeof (callback) === "function") {
			callback("ok");
		}
	});
}

/**
 * alert
 */
window.swalalert = function(msg) {
	swal({
		title: msg,
	    text: "",
	    type: "warning"
	}); 
};
/**
 * swaltable
 */
window.swaltable = function(msg,list) {
	var trs = "<table>";
	for ( var index in list) {
		var tr = '';
		if(list[index].code==200){
			tr = '<tr style="color: green;"><th>'+list[index].msg+'</th><th>'+list[index].obj+'</th></tr>';
		}else{
			tr = '<tr style="color: red;"><th>'+list[index].msg+'</th><th>'+list[index].obj+'</th></tr>';
		}
		trs = trs + tr;
	}
	trs = trs + "</table>";
	swal({
		title: msg,
		text: trs,
		html: true,
	}); 
};

/**
 * swalimg
 */
window.swalimg = function(msg,filePath) {
	var trs = '<img alt="'+filePath+'" src="'+filePath+'" width="50%">';
	swal({
		title: msg,
		text: trs,
		html: true,
	}); 
};

/**
 * success
 */
window.swalsuccess = function(msg) {
	swal({
		title: msg,
	    text: "",
	    type: "success"
	}); 
};

/**
 * error
 */
window.swalerror = function(msg) {
	swal({
		title: msg,
	    text: "",
	    type: "error"
	}); 
};

/**
 * confirm
 */
window.swalconfirm = function(msg,callback) {
	swal({
		title: msg,
	    text: "",
	    type: "warning",
	    showCancelButton: true,                //是否显示“取消”按钮。
	    cancelButtonText:"取消",            //按钮内容
	    cancelButtonColor:"#B9B9B9",
	 
	    showConfirmButton: true,               //是否显示“确认”按钮。
	    confirmButtonColor: "#DD6B55",
	    confirmButtonText: "确认",
	 
	    closeOnConfirm:false,
	    closeOnCancel:true                //点击返回上一步操作
	},
	function(isConfirm){
		callback(isConfirm);
		swal.close();
	});		
};

/**
 * 
 */
window.layerOpenPage = function(title,url){
	layer.open({
	  title:title,
	  type: 2, 
	  area: ['90%', '90%'],
	  content: url
	});
}

$(function() {
	$(".icon-picker").iconPicker();
});
// 对Date的扩展，将 Date 转化为指定格式的String
// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
// 例子：
// (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
// (new Date()).Format("yyyy-M-d h:m:s.S") ==> 2006-7-2 8:9:4.18
Date.prototype.Format = function(fmt) { // author: meizz
	var o = {
		"M+" : this.getMonth() + 1, // 月份
		"d+" : this.getDate(), // 日
		"h+" : this.getHours(), // 小时
		"m+" : this.getMinutes(), // 分
		"s+" : this.getSeconds(), // 秒
		"q+" : Math.floor((this.getMonth() + 3) / 3), // 季度
		"S" : this.getMilliseconds()
	// 毫秒
	};
	if (/(y+)/.test(fmt))
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	for ( var k in o)
		if (new RegExp("(" + k + ")").test(fmt))
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]): (("00" + o[k]).substr(("" + o[k]).length)));
	return fmt;
}
// var time1 = new Date().Format("yyyy-MM-dd");var time2 = new
// Date().Format("yyyy-MM-dd hh:mm:ss");
//时间字段格式化
function dateFormatter(value, row, index) {
	return new Date(value).Format("yyyy-MM-dd hh:mm:ss");
}
// 连接字段格式化
function linkFormatter(value, row, index) {
	return "<a href='" + value + "' title='单击打开连接' target='_blank'>" + value + "</a>";
}
// Email字段格式化
function emailFormatter(value, row, index) {
	return "<a href='mailto:" + value + "' title='单击打开连接'>" + value + "</a>";
}
// 性别字段格式化
function sexFormatter(value) {
	if (value == "女") {
		color = 'Red';
	} else if (value == "男") {
		color = 'Green';
	} else {
		color = 'Yellow';
	}

	return '<div  style="color: ' + color + '">' + value + '</div>';
}

// 订单类型
function orderTypeFormatter(value, row, index) {
	if (value == 1) {
		color = '#4D4D4D';
		return '<div  style="color: ' + color + '">A类订单</div>';
	}
	if (value == 2) {
		color = '#4D4D4D';
		return '<div  style="color: ' + color + '">B类订单</div>';
	}
	if (value == 3) {
		color = '#4D4D4D';
		return '<div  style="color: ' + color + '">C类订单</div>';
	}
}

// 订单状态
function orderStatusFormatter(value, row, index) {
	
	if (value == 1) {
		color = '#4D4D4D';
		return '<div  style="color: ' + color + '">待处理</div>';
	}
	if (value == 2) {
		color = '#4D4D4D';
		return '<div  style="color: ' + color + '">待上传</div>';
	}
	if (value == 3) {
		color = '#4D4D4D';
		return '<div  style="color: ' + color + '">待支付</div>';
	}
	if (value == 4) {
		color = '#4D4D4D';
		return '<div  style="color: ' + color + '">已完成</div>';
	}
	if (value == 11) {
		color = '#4D4D4D';
		return '<div  style="color: ' + color + '">保函条件不足</div>';
	}
	if (value == 500) {
		color = '#4D4D4D';
		return '<div  style="color: ' + color + '">取消办理</div>';
	}
}
// 支付类型
function payTypeFormatter(value, row, index) {
	if (value == 1) {
		color = '#4D4D4D';
		return '<div  style="color: ' + color + '">支付宝</div>';
	}
	if (value == 2) {
		color = '#4D4D4D';
		return '<div  style="color: ' + color + '">微信</div>';
	}
	if (value == 3) {
		color = '#4D4D4D';
		return '<div  style="color: ' + color + '">银联</div>';
	}
}
// 凭证查看
function orderVoucherFormatter(value, row, index) {
	if (value === null) {
		return "<a class='btn btn-xs green'>未上传保函</a>";
	}
	return "<a  class='btn btn-xs green' onclick=\"openOrderFileId('"+ row.orderId+ "')\" ><span class='glyphicon glyphicon-search'></span>预览</a>";
}



//担保申请单
function applicationTable(orderId) {
	window.open(baseURL + "/bond/templates/cdyh/applicationTable?orderId="+orderId, "orderDpcuments", align = "center","height=800, width=800, top=0, left=0, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no");
}
// 打开凭证页面
function openOrderVoucher(orderId) {
	window.open(baseURL + "/bond/templates/cdyh/voucherTable?orderId="+orderId, "orderDpcuments", align = "center","height=800, width=800, top=0, left=0, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no");
}

//打开凭证页面
function openOrderFileId(orderId) {
	$.get(baseURL + "/bond/bondorder/openOrderFileId?orderId="+orderId,function(r){
		$("#readingImageDiv").html('');
		if(r.code==0){
			var urls = r.urls;
			for ( var i in urls) {
				var obj = urls[i];
				if (/\.(gif|jpg|jpeg|png|GIF|JPG|PNG)$/.test(obj.fileSuffix)) { 
					var image = '<img alt="" src="'+obj.url+'" width="100%">';
				}else{
					var image = '<h5><a alt="" href="'+obj.url+'"> '+obj.name+' </a></h5>';
				}
				$("#readingImageDiv").append(image);
			}
			$('#readingImageModal').modal('show');
		}else{
			swalerror(r.msg);
		}
	});
}


// 选择一条记录
function getSelectedRow() {
	var grid = $($tableId);
	var rows = grid.bootstrapTable("getSelections");
	if (rows.length == 0) {
		alert("请选择一条记录");
		return;
	}
	if (rows.length > 1) {
		alert("只能选择一条记录");
		return;
	}
	return rows[0];
}

// 选择多条记录
function getSelectedRows() {
	var grid = $($tableId);
	var rows = grid.bootstrapTable("getSelections");
	console.log(rows);
	if (rows.length == 0) {
		alert("请选择一条记录");
		return;
	}
	return rows;
}

// 判断是否为空
function isBlank(value) {
	return !value || !/\S/.test(value)
}

(function($) {
	/**
	 * 拓展全局静态方法
	 */
	$.extend({
		// 初始化bootstrap-table的内容
		InitMainTable : function(tableId, fields, queryCallback, pageCallback) {
			console.log("=======InitMainTable========");

			var checkbox = {
				checkbox : true,
				visible : true
			};
			var columns = [];
			columns.push(checkbox);

			fields.forEach(function(value, index, array) {
				array[index].align = "center";
				array[index].valign = "middle";
				columns.push(array[index]);
			});

			var operation = {
				title : '操作',
				width : 120,
				align : 'center',
				valign : 'middle',
				formatter : actionFormatter
			};

			columns.push(operation);
			$tableId = tableId;
			// 记录页面bootstrap-table全局变量$table，方便应用
			$table = $(tableId).bootstrapTable(
					{
						method : 'POST', // 请求方式（*）
						// toolbar: '#toolbar', //工具按钮用哪个容器
						height : getHeight(46), // 高度
						striped : false, // 是否显示行间隔色
						cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
						pagination : true, // 是否显示分页（*）
						sortable : true, // 是否启用排序
						sortOrder : "asc", // 排序方式
						sidePagination : "server", // 分页方式：client客户端分页，server服务端分页（*）
						pageNumber : 1, // 初始化加载第一页，默认第一页,并记录
						pageSize : 10, // 每页的记录行数（*）
						pageList : [ 10, 25, 50, 100 ], // 可供选择的每页的行数（*）
						search : true, // 是否显示表格搜索
						strictSearch : true,
						showColumns : true, // 是否显示所有的列（选择显示的列）
						showRefresh : true, // 是否显示刷新按钮
						minimumCountColumns : 2, // 最少允许的列数
						clickToSelect : true, // 是否启用点击选中行
						exportDataType : "all", // 导出文件方式
						showExport : true, // 是否显示导出按钮
						buttonsAlign : "right", // 按钮位置
						exportTypes : ['csv','excel','xlsx'], // 导出文件支持: 'json', 'xml',
													// 'png', 'csv', 'txt',
													// 'sql'，'doc', 'excel',
													// 'xlsx', 'pdf'
						Icons : 'glyphicon glyphicon-export', // 导出文件图标
						// height: 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
						uniqueId : "ID", // 每一行的唯一标识，一般为主键列
						//showToggle : true, // 是否显示详细视图和列表视图的切换按钮
						//cardView : false, // 是否显示详细视图
						//detailView : false, // 是否显示父子表
						// 得到查询的参数
						queryParams : function(params) {
							// 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
							var temp = {
								rows : params.limit, // 页面大小
								page : (params.offset / params.limit) + 1, // 页码
								sort : params.sort, // 排序列名
								sortOrder : params.order
							// 排位命令（desc，asc）
							};
							queryCallback(temp);
						},
						columns : columns,
						// 数据加载成功
						onLoadSuccess : function() {
							layer.msg("加载成功");
						},
						// 数据加载成功
						onLoadError : function() {
							layer.msg("加载数据失败", {
								time : 1500,
								icon : 2
							});
						},
						// 设置在分页事件触发时，传递分页参数给后台，重新加载数据
						onPageChange : function(number, size) {
							var params = {};
							params.start = number;
							params.limit = size;
							pageCallback(params);
						},
						rowStyle : function(row, index) { // 设置行的特殊样式
							// 这里有5个取值颜色['active', 'success', 'info', 'warning',
							// 'danger'];
							var strclass = "";
							if (index == 0) {
								strclass = "warning";
							}
							return {
								classes : strclass
							}
						},
					});
		},


		/** 同步Post * */
		syncPost : function(url, data, successCallback) {
			$.ajax({
				async : false,
				type : 'POST',
				contentType : "application/json",
				url : url,
				data : data,
				// 添加提交进度条
				beforeSend : function(request) {
					console.log(url + "===请求参数===");
					console.log(data);
					index = layer.load();// 加载数据
				},
				success : function(request) {
					layer.close(index);
					successCallback(request);
				},
				error : function(request) {
					layer.close(index);
					layer.msg("加载数据失败", {
						time : 1500,
						icon : 2
					});
				},
				dataType : "json"
			});
		},

		/** 同步Post * */
		postForm : function(url, data, successCallback) {
			$.ajax({
				async : false,
				type : 'POST',
				contentType : "application/x-www-form-urlencoded",
				url : url,
				data : data,
				// 添加提交进度条
				beforeSend : function(request) {
					console.log(url + "===请求参数===");
					console.log(data);
					index = layer.load();// 加载数据
				},
				success : function(request) {
					layer.close(index);
					successCallback(request);
				},
				error : function(request) {
					layer.close(index);
					layer.msg("加载数据失败", {
						time : 1500,
						icon : 2
					});
				},
				dataType : "json"
			});
		},

		/** 异步Post * */
		syncPostWithAsync : function(url, data, successCallback) {
			$.ajax({
				async : true,
				type : 'POST',
				contentType : "application/json",
				url : url,
				data : data,
				beforeSend : function(request) {
					index = layer.load();
				},
				success : function(request) {
					layer.close(index);
					successCallback(request);
				},
				error : function(request) {
					layer.close(index);
					layer.msg("加载数据失败", {
						time : 1500,
						icon : 2
					});
				},
				dataType : "json"
			});
		},
		/** 异步Post * */
		syncPostWithAsync : function(url, data, successCallback) {
			$.ajax({
				async : true,
				type : 'POST',
				contentType : "application/json",
				url : url,
				data : data,
				beforeSend : function(request) {
					index = layer.load();
				},
				success : function(request) {
					layer.close(index);
					successCallback(request);
				},
				error : function(request) {
					layer.close(index);
					layer.msg("加载数据失败", {
						time : 1500,
						icon : 2
					});
				},
				dataType : "json"
			});
		},
		/** Html转义 * */
		encodeHtml : function(s) {
			return (typeof s != "string") ? s : s.replace(
					/"|&|'|<|>|[\x00-\x20]|[\x7F-\xFF]|[\u0100-\u2700]/g,
					function($0) {
						var c = $0.charCodeAt(0), r = [ "&#" ];
						c = (c == 0x20) ? 0xA0 : c;
						r.push(c);
						r.push(";");
						return r.join("");
					});
		},

		/** 获取URL参数 * */
		getUrlPara : function(name) {
			var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
			var r = window.location.search.substr(1).match(reg);
			if (r != null)
				return unescape(r[2]);
			return;
		},

		/** 获取URL QueryString * */
		getUrlParas : function() {
			var url = location.href;
			if (url.indexOf("?") == -1) {
				return;
			}
			return url.substring(url.indexOf("?") + 1, url.length);
		},

		/** 获取Form参数对象-用于Post请求 * */
		getFormParasObj : function(form) {
			var o = {};
			$.each(form.serializeArray(), function(index) {
				if (o[this['name']]) {
					o[this['name']] = o[this['name']] + "," + this['value'];
				} else {
					o[this['name']] = this['value'];
				}
			});
			return o;
		},

		/** 获取Form参数字符-用于get请求 * */
		getFormParasStr : function(form) {
			var o = "";
			$.each(form.serializeArray(), function(index) {
				var key = this['name'], val = this['value'];
				if (val && val.length > 0) {
					o = o + key + "=" + val + "&";
				}
			});
			return o.substring(0, o.length - 1);
		},
		/** 获取浏览器类型 * */
		getBrowser : function() {
			var explorer = window.navigator.userAgent;
			if (explorer.indexOf("MSIE") >= 0) {
				return 'ie';
			} else if (explorer.indexOf("Firefox") >= 0) {
				return 'firefox';
			} else if (explorer.indexOf("Chrome") >= 0) {
				return 'chrome';
			} else if (explorer.indexOf("Opera") >= 0) {
				return 'opera';
			} else if (explorer.indexOf("Safari") >= 0) {
				return 'safari';
			}
		}
	});
})(jQuery);

// 查看
function select(key) {
	if (key == null) {
		return;
	}
	vm.title = "查看";
	$("#saveOrUpdate").hide();
	vm.itemPage(key);
}
// 单一修改
function update(key) {
	if (key == null) {
		return;
	}
	vm.title = "修改";
	$("#saveOrUpdate").show();
	vm.itemPage(key);
}
// 单一删除
function del(key) {
	if (key == null) {
		return;
	}
	vm.title = "删除";
	var userIds = [];
	userIds.push(key);
	vm.delPost(userIds);
}

// 表格高度自适应
function getHeight(nuber) {
	return $(window).height() - nuber;
}

// 初始化选择时间
// id==>绑定元素的id
// func==>回调方法
// 例如dateDefind('date1',function(val){
// vm.bondEnsupplier.supplierEstabDate = val;
// }) 
//vm.bondEnsupplier.supplierEstabDate  为vue的绑定元素 
function dateDefind(id, func) {
	var id = $('#' + id)
	// 初始化
	id.datetimepicker({
		language : 'zh-CN',// 显示中文
		weekStart : 0, // 一周从哪一天开始
		todayBtn : 1, //
		autoclose : 1,
		todayHighlight : 1,
		startView : 2,
		forceParse : 0,
		showMeridian : 1
	});
	// 当选择器隐藏时，讲选择框只赋值给data里面的time
	id.datetimepicker().on('hide', function(ev) {
		func(id.val())
	});
}


/*
 * Generate a random uuid.
 *
 * USAGE: Math.uuid(length, radix)
 *   length - the desired number of characters
 *   radix  - the number of allowable values for each character.
 *
 * EXAMPLES:
 *   // No arguments  - returns RFC4122, version 4 ID
 *   >>> Math.uuid()
 *   "92329D39-6F5C-4520-ABFC-AAB64544E172"
 *
 *   // One argument - returns ID of the specified length
 *   >>> Math.uuid(15)     // 15 character ID (default base=62)
 *   "VcydxgltxrVZSTV"
 *
 *   // Two arguments - returns ID of the specified length, and radix. (Radix must be <= 62)
 *   >>> Math.uuid(8, 2)  // 8 character ID (base=2)
 *   "01001010"
 *   >>> Math.uuid(8, 10) // 8 character ID (base=10)
 *   "47473046"
 *   >>> Math.uuid(8, 16) // 8 character ID (base=16)
 *   "098F4D35"
 */
(function() {
  // Private array of chars to use
  var CHARS = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'.split('');

  Math.uuid = function (len, radix) {
    var chars = CHARS, uuid = [], i;
    radix = radix || chars.length;

    if (len) {
      // Compact form
      for (i = 0; i < len; i++) uuid[i] = chars[0 | Math.random()*radix];
    } else {
      // rfc4122, version 4 form
      var r;

      // rfc4122 requires these characters
      uuid[8] = uuid[13] = uuid[18] = uuid[23] = '-';
      uuid[14] = '4';

      // Fill in random data.  At i==19 set the high bits of clock sequence as
      // per rfc4122, sec. 4.1.5
      for (i = 0; i < 36; i++) {
        if (!uuid[i]) {
          r = 0 | Math.random()*16;
          uuid[i] = chars[(i == 19) ? (r & 0x3) | 0x8 : r];
        }
      }
    }

    return uuid.join('');
  };

  // A more performant, but slightly bulkier, RFC4122v4 solution.  We boost performance
  // by minimizing calls to random()
  Math.uuidFast = function() {
    var chars = CHARS, uuid = new Array(36), rnd=0, r;
    for (var i = 0; i < 36; i++) {
      if (i==8 || i==13 ||  i==18 || i==23) {
        uuid[i] = '-';
      } else if (i==14) {
        uuid[i] = '4';
      } else {
        if (rnd <= 0x02) rnd = 0x2000000 + (Math.random()*0x1000000)|0;
        r = rnd & 0xf;
        rnd = rnd >> 4;
        uuid[i] = chars[(i == 19) ? (r & 0x3) | 0x8 : r];
      }
    }
    return uuid.join('');
  };

  // A more compact, but less performant, RFC4122v4 solution:
  Math.uuidCompact = function() {
    return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
      var r = Math.random()*16|0, v = c == 'x' ? r : (r&0x3|0x8);
      return v.toString(16);
    });
  };
})();


/**
 * 封装WebUploader多上传
 * @param jQuery
 * @param WebUploader
 * @returns
 */
(function(jQuery,WebUploader){
	//param  setting  Global variable
    var $ = jQuery;
    ///var rootx=this;  这个this是 window！
    var msgHint={img:'选择图片',file:'选择文件',text:''};
    var btnTxt={img:'',file:'确认上传',text:''};
    var picker='pick';
    var extendsion='gif,jpg,jpeg,bmp,png,pdf';
    //文件过滤类型
    var filesMimeTypes={
    	"txt":"text/*",//图片类型
		"img":"image/*",//图片类型
		"doc":"application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document",//word类型
		"xls":"application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",//excel类型
		"ppt":"application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",//ppt类型
		"pdf":"application/pdf",//pdf类型
		"zip":"application/zip",//zip类型
		"csv":"application/csv"//csv类型
    };
    var uploadId='upload';
    var imgTitle='Images';
    var filePickerId = "filePicker";
  //generate random string
    function randomString(len){
         len=len||32;
         var chars='ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz';
         var maxPos=chars.length;
         var pwd='';
         for(var i=0;i<len;i++){
             //Math.random()  乘以最大长度然后取整，就能生成随机的一位字符
             //随机的其实是这个index 下标
             pwd+=chars.charAt(Math.floor(Math.random()*maxPos));
         }
         return pwd;
     }

    //判断传入是否为对象
    function isObject(obj){
        var type=typeof obj;
        return type==='function'||type==='object'&&!!obj;
    }
    
    //读取配置
    function render(options){
        var classObj={};
        var item=document.getElementById(options.divId);
        var hintx=(options.type==='img')?msgHint['img']:msgHint['file'];
        var buttonText=(options.type==='img')?btnTxt['img']:btnTxt['file'];
        //generating random ID of picker and uploader
        
        uploadId+=randomString(5);//上传主键ID
        
        picker+=randomString(5);
    	
        //class  或者 id名的 长度限制？
        options.uploadId = uploadId;
        options.picker = picker;
        //如果上传数量大于1
        var uploadDom='<div class="uploader queueList">';
        uploadDom+= '<div id='+uploadId+'>';
        if(options.number>1){
        	filePickerId+=randomString(5);
        	options.filePickerId = filePickerId;
        	uploadDom+='<div id='+filePickerId+'></div>'
        }
        uploadDom+='<div id='+picker+'></div> </div> </div>'
        
        item.innerHTML+=uploadDom;
    }
    
    /**
     * 批量文件上传
     */
    //初始化，创建上传实例 
    function initUploader(options){
    	
    	var $wrap = $('#'+options.divId);
    	
        if(!isObject(options)){
        	swal("error! it is not an object!");
            return ;
        }
        //判断是否支持WebUploader上传
        else if ( !WebUploader.Uploader.support('flash') && WebUploader.browser.ie ) {
             // flash 安装了但是版本过低。
             if (flashVersion) {
                    (function(container) {
                        window['expressinstallcallback'] = function( state ) {
                            switch(state) {
                                case 'Download.Cancelled':
                                	swal('您取消了更新！');
                                    break;

                                case 'Download.Failed':
                                	swal('安装失败');
                                    break;

                                default:
                                	swal('安装已成功，请刷新！');
                                    break;
                            }
                            delete window['expressinstallcallback'];
                        };

                        var swf = 'expressInstall.swf';
                        // insert flash object
                        var html = '<object type="application/' + 'x-shockwave-flash" data="' +  swf + '" ';

                        if (WebUploader.browser.ie) {
                            html += 'classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" ';
                        }

                        html += 'width="100%" height="100%" style="outline:0">'  +
                            '<param name="movie" value="' + swf + '" />' +
                            '<param name="wmode" value="transparent" />' +
                            '<param name="allowscriptaccess" value="always" />' +
                        '</object>';
                        container.html(html);
                    })($wrap);
                // 压根就没有安转。
                } else {
                    $wrap.html('<a href="http://www.adobe.com/go/getflashplayer" target="_blank" border="0"><img alt="get flash player" src="http://www.adobe.com/macromedia/style_guide/images/160x41_Get_Flash_Player.jpg" /></a>');
                }
                return;
            } else if (!WebUploader.Uploader.support()) {
            	swal( 'Web Uploader 不支持您的浏览器！');
                return;
            }else{
            	//render the html first!
            	render(options); //render the html dom
            	//common setting
            	var settings={
                    method:'POST',
                    swf:'/statics/plugins/ueditor1.4.3.3/third-party/webuploader/Uploader.swf',// swf文件路径
                    server:options.serverPath,// 文件接收服务端。
                    // 选择文件的按钮。可选。
                    paste: '#'+options.divId,//指定监听paste事件的容器，如果不指定，不启用此功能。此功能为通过粘贴来添加截屏的图片。
                    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
                    pick: {
                        id: '#'+options.picker, // picker id 
                        label: '<i class="fa fa-sign-in"></i>'+options.uploadText
                    },
                    //dnd: '#'+options.uploadId,//指定Drag And Drop拖拽的容器，如果不指定，则不启动
                    chunked:true,//是否分块上传
                    chunkRetry:3,//某个分片由于网络问题出错，允许自动重传多少次
                    chunkSize:512 * 1024,//如果要分片，分多大一片？ 默认大小为5M.
                    disableGlobalDnd: true,
                    fileNumLimit: options.number,//验证文件总数量, 超出则不允许加入队列
                    fileSizeLimit:options.fileSizeLimit||102400, 
                    duplicate :true,//支持上传重复文件
                    fileSingleSizeLimit: 1024 * 1024 * 1024    //1024M 验证单个文件大小是否超出限制, 超出则不允许加入队
            	};
            	
            	if(options.type==='img'){
            		settings['auto'] = options.auto;
            		settings['accept']={
                    title:imgTitle,
                    extensions:extendsion,
                    mimeTypes:'image/*'
                };
            		
	            }else if(options.type==='file'){
	            	//判断上传控件类型
	            	var mimeTypes = "";
	            	for (var type in filesMimeTypes) {
						if(options.extensions.indexOf(type)!=-1){
							mimeTypes = mimeTypes+filesMimeTypes[type]+",";
						}
					}
	                settings['resize']=false;
	                settings['auto'] = options.auto;
	                settings['accept']={
                        title:'Files',
                        extensions:options.extensions,
                        mimeTypes:mimeTypes.substring(0,mimeTypes.length-1)
	                };
	            }
	            var uploader = WebUploader.create(settings);
        }
        return uploader;
    }
    
	/**
	 * 单个文件上传
	 */
	function createUpload(options,callBack){
        var uploader = initUploader(options);
        /**
         * 不管成功或者失败，文件上传完成时触发。
         */
        uploader.on('uploadComplete',function(file){
        	$("#"+options.divId).empty();
        	createFileInput(options.divId,callBack);
        });
        /**
         * 上传过程中触发，携带上传进度。
         */
        uploader.on('uploadProgress',function(file,percentage){
        	console.log(percentage);
        });
        
        /**
         * 当一批文件添加进队列以后触发
         */
        uploader.on('fileQueued',function( file ) {

        });
        /**
         * 当文件被移除队列后触发
         */
        uploader.on('fileDequeued', function( file ) {

        });
        /**
         * 当文件上传成功时触发
         */
        uploader.on('uploadSuccess',function(file,response){
			if (response.code="200") {
				layer.alert(response.msg,function(){
					if (callBack) {
		        		callBack(response);
		        		createFileInput(options.divId,callBack);
		        		layer.close(layer.index);
		        		//location.reload();
					}
				});
        		$.messager.show("Upload",response.msg);
			}else{
				layer.alert("文件上传失败!",function(){
					if (callBack) {
		        		callBack(response);
		        		location.reload();
					}
				});
			}
        	/*setTimeout(function(){
				location.reload();
			}, 1000);*/
        });
        /**
         * 当文件上传出错时触发
         */	
        uploader.on('uploadError',function(file,reason){
        	if (callBack) {
        		callBack(reason);
			}else{
				swal("Upload", "文件上传失败!", "error");
			}
        });
        
        /**
         * 当validate不通过时，会以派送错误事件的形式通知调用者
         */
        uploader.on('error', function(type){
        	uploader.reset();
        });
    }
	$.fn.createUpload = createUpload;
    
/**
 * 批量文件上传插件方法
 */
function createFilesMultiple(options,callBack){

	 var item=document.getElementById(options.divId);
	
	 uploadId+=randomString(5);//上传主键ID
        
     picker+=randomString(5);
	
     options.uploadId = uploadId;
     options.picker = picker;
     
	var html =
		'<div class="queueList">'+
        '<div id="'+uploadId+'" class="placeholder">'+
		'<div id="'+picker+'"></div>'+
		'<p>或将文件拖到这里，单次最多可选'+options.number+'份文件</p>'+
		'</div>'+
		'</div>'+
		'<div class="statusBar" style="display:none;">'+
		'<div class="progress">'+
		'<span class="text">0%</span>'+
        '<span class="percentage"></span>'+
		'</div><div class="info"></div>'+
		'<div class="btns">'+
		'<div id="'+picker+'_2"></div><div class="uploadBtn">开始上传</div>'+
		'</div>'+
		'</div>'; 
	
	item.innerHTML+=html;
	
	var $wrap = $('#'+options.divId),

	
	// 文件容器
	$queue = $('<ul class="filelist"></ul>').appendTo($wrap.find('.queueList')),

	// 状态栏，包括进度和控制按钮
	$statusBar = $wrap.find('.statusBar'),

	// 文件总体选择信息。
	$info = $statusBar.find('.info'),

	// 上传按钮
	$upload = $wrap.find('.uploadBtn'),

	// 没选择文件之前的内容。
	$placeHolder = $wrap.find('.placeholder'),

	$progress = $statusBar.find('.progress').hide(),

	// 添加的文件数量
	fileCount = 0,

	// 添加的文件总大小
	fileSize = 0,

	// 优化retina, 在retina下这个值是2
	ratio = window.devicePixelRatio || 1,

	// 缩略图大小
	thumbnailWidth = 110 * ratio, thumbnailHeight = 110 * ratio,

	// 可能有pedding, ready, uploading, confirm, done.
	state = 'pedding',

	// 所有文件的进度信息，key为file id
	percentages = {},
	// 判断浏览器是否支持文件的base64
	isSupportBase64 = (function() {
		var data = new Image();
		var support = true;
		data.onload = data.onerror = function() {
			if (this.width != 1 || this.height != 1) {
				support = false;
			}
		}
		data.src = "data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///ywAAAAAAQABAAACAUwAOw==";
		return support;
	})(),

	// 检测是否已经安装flash，检测flash的版本
	flashVersion = (function() {
		var version;

		try {
			version = navigator.plugins['Shockwave Flash'];
			version = version.description;
		} catch (ex) {
			try {
				version = new ActiveXObject('ShockwaveFlash.ShockwaveFlash').GetVariable('$version');
			} catch (ex2) {
				version = '0.0';
			}
		}
		version = version.match(/\d+/g);
		return parseFloat(version[0] + '.' + version[1], 10);
	})(),

	supportTransition = (function() {
		var s = document.createElement('p').style, r = 'transition' in s
				|| 'WebkitTransition' in s || 'MozTransition' in s
				|| 'msTransition' in s || 'OTransition' in s;
		s = null;
		return r;
	})();

	if (!WebUploader.Uploader.support('flash') && WebUploader.browser.ie) {

		// flash 安装了但是版本过低。
		if (flashVersion) {
			(function(container) {
				window['expressinstallcallback'] = function(state) {
					switch (state) {
					case 'Download.Cancelled':
						alert('您取消了更新！')
						break;

					case 'Download.Failed':
						alert('安装失败')
						break;

					default:
						alert('安装已成功，请刷新！');
						break;
					}
					delete window['expressinstallcallback'];
				};

				var swf = 'expressInstall.swf';
				// insert flash object
				var html = '<object type="application/'
						+ 'x-shockwave-flash" data="' + swf + '" ';

				if (WebUploader.browser.ie) {
					html += 'classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" ';
				}

				html += 'width="100%" height="100%" style="outline:0">'
						+ '<param name="movie" value="'
						+ swf
						+ '" />'
						+ '<param name="wmode" value="transparent" />'
						+ '<param name="allowscriptaccess" value="always" />'
						+ '</object>';

				container.html(html);

			})($wrap);

			// 压根就没有安转。
		} else {
			$wrap.html('<a href="http://www.adobe.com/go/getflashplayer" target="_blank" border="0"><img alt="get flash player" src="http://www.adobe.com/macromedia/style_guide/images/160x41_Get_Flash_Player.jpg" /></a>');
		}

		return;
	} else if (!WebUploader.Uploader.support()) {
		alert('Web Uploader 不支持您的浏览器！');
		return;
	}

	var settings={
        method:'POST',
        swf:'/statics/plugins/webuploader/Uploader.swf',// swf文件路径
        server:options.serverPath,// 文件接收服务端。
        // 选择文件的按钮。可选。
        paste: '#'+options.divId,//指定监听paste事件的容器，如果不指定，不启用此功能。此功能为通过粘贴来添加截屏的图片。
        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
        pick: {
            id: '#'+options.picker, // picker id 
            label: '点击选择文件'
        },
        dnd: '#'+options.uploadId,//指定Drag And Drop拖拽的容器，如果不指定，则不启动
        chunked:false,//是否分块上传
        chunkRetry:3,//某个分片由于网络问题出错，允许自动重传多少次
        chunkSize:512 * 1024,//如果要分片，分多大一片？ 默认大小为5M.
        disableGlobalDnd: true,
        fileNumLimit: options.number,//验证文件总数量, 超出则不允许加入队列
        fileSizeLimit:options.fileSizeLimit||102400, 
        duplicate :true,//支持上传重复文件
        fileSingleSizeLimit: 1024 * 1024 * 1024    //1024M 验证单个文件大小是否超出限制, 超出则不允许加入队
    };
	
	// WebUploader实例
	var uploader = WebUploader.create(settings);

	// 拖拽时不接受 js, txt 文件。
	uploader.on('dndAccept', function(items) {
		var denied = false, len = items.length, i = 0,
		// 修改js类型
		unAllowed = 'text/plain;application/javascript ';

		for (; i < len; i++) {
			// 如果在列表里面
			if (~unAllowed.indexOf(items[i].type)) {
				denied = true;
				break;
			}
		}

		return !denied;
	});

	uploader.on('dialogOpen', function() {
		console.log('here');
	});

	// uploader.on('filesQueued', function() {
	// uploader.sort(function( a, b ) {
	// if ( a.name < b.name )
	// return -1;
	// if ( a.name > b.name )
	// return 1;
	// return 0;
	// });
	// });

	// 添加“添加文件”的按钮，
	uploader.addButton({
		id : '#'+picker+'_2',
		label : '继续添加'
	});

	uploader.on('ready', function() {
		window.uploader = uploader;
	});

	// 当有文件添加进来时执行，负责view的创建
	function addFile(file) {
		var $li = $('<li id="' + file.id + '">' + '<p class="title">'
				+ file.name + '</p>' + '<p class="imgWrap"></p>'
				+ '<p class="progress"><span></span></p>' + '</li>'),

		$btns = $(
				'<div class="file-panel">'
						+ '<span class="cancel">删除</span>'
						+ '<span class="rotateRight">向右旋转</span>'
						+ '<span class="rotateLeft">向左旋转</span></div>')
				.appendTo($li), $prgress = $li.find('p.progress span'), $wrap = $li
				.find('p.imgWrap'), $info = $('<p class="error"></p>'),

		showError = function(code) {
			switch (code) {
			case 'exceed_size':
				text = '文件大小超出';
				break;

			case 'interrupt':
				text = '上传暂停';
				break;

			default:
				text = '上传失败，请重试';
				break;
			}

			$info.text(text).appendTo($li);
		};

		if (file.getStatus() === 'invalid') {
			showError(file.statusText);
		} else {
			// @todo lazyload
			$wrap.text('预览中');
			uploader.makeThumb(file, function(error, src) {
				var img;

				if (error) {
					$wrap.text('不能预览');
					return;
				}

				if (isSupportBase64) {
					img = $('<img src="' + src + '">');
					$wrap.empty().append(img);
				} else {
					$.ajax('upload', {
						method : 'POST',
						data : src,
						dataType : 'json'
					}).done(function(response) {
						if (response.result) {
							img = $('<img src="' + response.result + '">');
							$wrap.empty().append(img);
						} else {
							$wrap.text("预览出错");
						}
					});
				}
			}, thumbnailWidth, thumbnailHeight);

			percentages[file.id] = [ file.size, 0 ];
			file.rotation = 0;
		}

		file.on('statuschange', function(cur, prev) {
			if (prev === 'progress') {
				$prgress.hide().width(0);
			} else if (prev === 'queued') {
				$li.off('mouseenter mouseleave');
				$btns.remove();
			}

			// 成功
			if (cur === 'error' || cur === 'invalid') {
				console.log(file.statusText);
				showError(file.statusText);
				percentages[file.id][1] = 1;
			} else if (cur === 'interrupt') {
				showError('interrupt');
			} else if (cur === 'queued') {
				$info.remove();
				$prgress.css('display', 'block');
				percentages[file.id][1] = 0;
			} else if (cur === 'progress') {
				$info.remove();
				$prgress.css('display', 'block');
			} else if (cur === 'complete') {
				$prgress.hide().width(0);
				$li.append('<span class="success"></span>');
			}

			$li.removeClass('state-' + prev).addClass('state-' + cur);
		});

		$li.on('mouseenter', function() {
			$btns.stop().animate({
				height : 30
			});
		});

		$li.on('mouseleave', function() {
			$btns.stop().animate({
				height : 0
			});
		});

		$btns.on('click', 'span', function() {
			var index = $(this).index(), deg;

			switch (index) {
			case 0:
				uploader.removeFile(file);
				return;

			case 1:
				file.rotation += 90;
				break;

			case 2:
				file.rotation -= 90;
				break;
			}

			if (supportTransition) {
				deg = 'rotate(' + file.rotation + 'deg)';
				$wrap.css({
					'-webkit-transform' : deg,
					'-mos-transform' : deg,
					'-o-transform' : deg,
					'transform' : deg
				});
			} else {
				$wrap.css('filter',
						'progid:DXImageTransform.Microsoft.BasicImage(rotation='
								+ (~~((file.rotation / 90) % 4 + 4) % 4)
								+ ')');
				// use jquery animate to rotation
				// $({
				// rotation: rotation
				// }).animate({
				// rotation: file.rotation
				// }, {
				// easing: 'linear',
				// step: function( now ) {
				// now = now * Math.PI / 180;

				// var cos = Math.cos( now ),
				// sin = Math.sin( now );

				// $wrap.css( 'filter',
				// "progid:DXImageTransform.Microsoft.Matrix(M11=" + cos +
				// ",M12=" + (-sin) + ",M21=" + sin + ",M22=" + cos +
				// ",SizingMethod='auto expand')");
				// }
				// });
			}

		});

		$li.appendTo($queue);
	}

	// 负责view的销毁
	function removeFile(file) {
		var $li = $('#' + file.id);

		delete percentages[file.id];
		updateTotalProgress();
		$li.off().find('.file-panel').off().end().remove();
	}

	function updateTotalProgress() {
		var loaded = 0, total = 0, spans = $progress.children(), percent;

		$.each(percentages, function(k, v) {
			total += v[0];
			loaded += v[0] * v[1];
		});

		percent = total ? loaded / total : 0;

		spans.eq(0).text(Math.round(percent * 100) + '%');
		spans.eq(1).css('width', Math.round(percent * 100) + '%');
		updateStatus();
	}

	function updateStatus() {
		var text = '', stats;

		if (state === 'ready') {
			text = '选中' + fileCount + '个文件，共'
					+ WebUploader.formatSize(fileSize) + '。';
		} else if (state === 'confirm') {
			stats = uploader.getStats();
			if (stats.uploadFailNum) {
				text = '已成功上传'
						+ stats.successNum
						+ '个文件至XX目录，'
						+ stats.uploadFailNum
						+ '个文件上传失败，<a class="retry" href="#">重新上传</a>失败文件或<a class="ignore" href="#">忽略</a>'
			}

		} else {
			stats = uploader.getStats();
			text = '共' + fileCount + '个文件（'
					+ WebUploader.formatSize(fileSize) + '），已上传'
					+ stats.successNum + '个文件';

			if (stats.uploadFailNum) {
				text += '，失败' + stats.uploadFailNum + '个文件';
			}
		}

		$info.html(text);
	}

	function setState(type,file,percentage) {
		var stats;
		console.log(type);
		$upload.removeClass('state-' + state);
		$upload.addClass('state-' + type);
		state = type;
		switch (state) {
		case 'pedding':
			$placeHolder.removeClass('element-invisible');
			$queue.hide();
			$statusBar.addClass('element-invisible');
			uploader.refresh();
			break;
		case 'ready':
			$placeHolder.addClass('element-invisible');
			$('#filePicker2').removeClass('element-invisible');
			$queue.show();
			$statusBar.removeClass('element-invisible');
			uploader.refresh();
			break;
		case 'uploading':
			$('#'+picker+'_2').addClass('element-invisible');
			$progress.show();
			$upload.text('暂停上传');
			break;
		case 'paused':
			$progress.show();
			$upload.text('继续上传');
			break;
		case 'confirm':
			$progress.hide();
			$('#'+picker+'_2').removeClass('element-invisible');
			$upload.text('开始上传');
			stats = uploader.getStats();
			if (stats.successNum && !stats.uploadFailNum) {
				setState('finish');
				return;
			}
			break;
		case 'finish':
			stats = uploader.getStats();
			if (stats.successNum) {
				callBack(stats);//上传后回调
				swalsuccess('上传成功');
			} else {
				// 没有成功的文件，重设
				state = 'done';
				location.reload();
			}
			break;
		case 'uploadSuccess':
			callBack(percentage);//上传后回调
			break;
		}
		updateStatus();
	}

	uploader.onUploadProgress = function(file, percentage) {
		var $li = $('#' + file.id), $percent = $li.find('.progress span');

		$percent.css('width', percentage * 100 + '%');
		percentages[file.id][1] = percentage;
		updateTotalProgress();
	};

	uploader.onFileQueued = function(file) {
		fileCount++;
		fileSize += file.size;

		if (fileCount === 1) {
			$placeHolder.addClass('element-invisible');
			$statusBar.show();
		}

		addFile(file);
		setState('ready');
		updateTotalProgress();
	};

	uploader.onFileDequeued = function(file) {
		fileCount--;
		fileSize -= file.size;

		if (!fileCount) {
			setState('pedding');
		}

		removeFile(file);
		updateTotalProgress();

	};

	uploader.on('all', function(type,file,percentage) {
		var stats;
		switch (type) {
		case 'uploadSuccess':
			setState(type,file,percentage);
			break;
		case 'uploadFinished':
			setState('confirm');
			break;
		case 'startUpload':
			setState('uploading');
			break;
		case 'stopUpload':
			setState('paused');
			break;
		}
	});

	uploader.onError = function(code) {
		alert('Eroor: ' + code);
	};

	$upload.on('click', function() {
		if ($(this).hasClass('disabled')) {
			return false;
		}

		if (state === 'ready') {
			uploader.upload();
		} else if (state === 'paused') {
			uploader.upload();
		} else if (state === 'uploading') {
			uploader.stop();
		}
	});

	$info.on('click', '.retry', function() {
		uploader.retry();
	});

	$info.on('click', '.ignore', function() {
		alert('todo');
	});

	$upload.addClass('state-' + state);
	updateTotalProgress();

}

$.fn.createFilesMultiple = createFilesMultiple;

})(jQuery,WebUploader);

/**
 * 多文件上传插件
 * @returns
 */
function createFilesMultiple(divId,serverPath,callBack){
	if (document.getElementById(divId)) {
		$("#"+divId).empty();
		var uploader_1 = {
			serverPath : serverPath,// 提交服务端的URL
			number : 300,//
			divId : divId,// 你要在页面哪个div下创建这个上传组件
			fileSizeLimit : 1024 * 1024 * 1024,// 所有文件的总上传大小不超过这个值
			thumbnailSize : 100,
			extensions: 'gif,jpg,jpeg,bmp,png,pdf,doc,docx,txt,xls,xlsx,ppt,pptx,zip,mp3,mp4,text,csv',//上传文件限定类型
			auto:false,//是否直传
	 	};
		$.fn.createFilesMultiple(uploader_1,callBack);
	}
}

/**
 * 单个文件上传插件
 * @returns
 */
function createFileInput(divId,serverPath,callBack){
	if (document.getElementById(divId)) {
		var type = $("#"+divId).data("type");
		var number = $("#"+divId).data("number");
		var title = $("#"+divId).data("title");
		var auto = $("#"+divId).data("auto");
		var extensions = $("#"+divId).data("extendsion");
		$("#"+divId).empty();
		var uploader_1 = {
				serverPath : serverPath,// 提交服务端的URL
				number : number,// 创建的上传实例个数，默认1个。
				type : type,// img or file 上传图片 or 上传普通文件
				divId : divId,// 你要在页面哪个div下创建这个上传组件
				fileSizeLimit : 1024 * 1024 * 1024,// 所有文件的总上传大小不超过这个值
				uploadText : title, // 标签显示的文本
				thumbnailSize : 100,
				extensions: 'gif,jpg,jpeg,bmp,png,pdf,doc,docx,txt,xls,xlsx,ppt,pptx,zip,mp3,mp4,text,csv',//上传文件限定类型
				auto:auto,//是否直传
		 	};
		if (extensions) {
			uploader_1.extensions = extensions;//上传文件限定类型
		}
		$.fn.createUpload(uploader_1,callBack);
	}
	
}

/*
 * 导入
 */
var wb;//读取完成的数据
var rABS = false; //是否将文件读取为二进制字符串

function importf(obj) {//导入
    if(!obj.files) {
        return;
    }
    var f = obj.files[0];
    var reader = new FileReader();
    reader.onload = function(e) {
        var data = e.target.result;
        if(rABS) {
            wb = XLSX.read(btoa(fixdata(data)), {//手动转化
                type: 'base64'
            });
        } else {
            wb = XLSX.read(data, {
                type: 'binary'
            });
        }
        //wb.SheetNames[0]是获取Sheets中第一个Sheet的名字
        //wb.Sheets[Sheet名]获取第一个Sheet的数据
		
		document.getElementById("hf").download = wb.SheetNames[0]+".xlsx";
		
		var jsono = XLSX.utils.sheet_to_json(wb.Sheets[wb.SheetNames[0]]);
		
		//格式化需要替换的数据信息
		
		for(var i=0;i<jsono.length;i++){
			var object = jsono[i];
			console.log(object);
			var total = 0;
			for(var key in object){
				console.log(key);
				var str = object[key];
				
				
				str = substringByStr(str);
				if(str.indexOf(';')>-1){
					var list = str.split(';');
					console.log(list);
					
					for(var index in list){
						console.log(index);
						total = total + Number(list[index]);
					}
					
				}
				
				object[key] = str;
											
			}
			object[wb.SheetNames[0]] = total;
		}
		
		downloadExl(jsono);
        //document.getElementById("demo").innerHTML= JSON.stringify( XLSX.utils.sheet_to_json(wb.Sheets[wb.SheetNames[0]]));
    };
    if(rABS) {
        reader.readAsArrayBuffer(f);
    } else {
        reader.readAsBinaryString(f);
    }
}

function substringByStr(str) {
	if(str.indexOf('<')>-1&&str.indexOf('>')>-1){
		
		var start = str.indexOf('<');
		var end = str.indexOf('>');
		var str1 = str.substring(start,end+1);
		
		str = str.replace(str1,';');
		
		str = substringByStr(str);
	}
	console.log(str);
	
	
	return str;
}

function fixdata(data) { //文件流转BinaryString
    var o = "",
        l = 0,
        w = 10240;
    for(; l < data.byteLength / w; ++l) o += String.fromCharCode.apply(null, new Uint8Array(data.slice(l * w, l * w + w)));
    o += String.fromCharCode.apply(null, new Uint8Array(data.slice(l * w)));
    return o;
}

/**
 * 导出
 */
var tmpDown; //导出的二进制对象
function downloadExl(json, type) {
    var tmpdata = json[0];
    json.unshift({});
    var keyMap = []; //获取keys
    //keyMap =Object.keys(json[0]);
    for (var k in tmpdata) {
        keyMap.push(k);
        json[0][k] = k;
    }
  var tmpdata = [];//用来保存转换好的json 
        json.map((v, i) => keyMap.map((k, j) => Object.assign({}, {
            v: v[k],
            position: (j > 25 ? getCharCol(j) : String.fromCharCode(65 + j)) + (i + 1)
        }))).reduce((prev, next) => prev.concat(next)).forEach((v, i) => tmpdata[v.position] = {
            v: v.v
        });
        var outputPos = Object.keys(tmpdata); //设置区域,比如表格从A1到D10
        var tmpWB = {
            SheetNames: ['mySheet'], //保存的表标题
            Sheets: {
                'mySheet': Object.assign({},
                    tmpdata, //内容
                    {
                        '!ref': outputPos[0] + ':' + outputPos[outputPos.length - 1] //设置填充区域
                    })
            }
        };
        tmpDown = new Blob([s2ab(XLSX.write(tmpWB, 
            {bookType: (type == undefined ? 'xlsx':type),bookSST: false, type: 'binary'}//这里的数据是用来定义导出的格式类型
            ))], {
            type: ""
        }); //创建二进制对象写入转换好的字节流
    var href = URL.createObjectURL(tmpDown); //创建对象超链接
    var timestamp = Date.parse(new Date());
    document.getElementById("exportPageHref").download = timestamp+".xlsx";
    document.getElementById("exportPageHref").href = href; //绑定a标签
    document.getElementById("exportPageHref").click(); //模拟点击实现下载
    setTimeout(function() { //延时释放	
        URL.revokeObjectURL(tmpDown); //用URL.revokeObjectURL()来释放这个object URL
    }, 100);
}

function s2ab(s) { //字符串转字符流
    var buf = new ArrayBuffer(s.length);
    var view = new Uint8Array(buf);
    for (var i = 0; i != s.length; ++i) view[i] = s.charCodeAt(i) & 0xFF;
    return buf;
}
 // 将指定的自然数转换为26进制表示。映射关系：[0-25] -> [A-Z]。
function getCharCol(n) {
    let temCol = '',
    s = '',
    m = 0
    while (n > 0) {
        m = n % 26 + 1
        s = String.fromCharCode(m + 64) + s
        n = (n - m) / 26
    }
    return s
}

