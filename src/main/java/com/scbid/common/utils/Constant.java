package com.scbid.common.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 常量
 */
public class Constant {

	
	/**
	 * 菜单按钮集合
	 */
	public static List<String>  buttons = new ArrayList<String>();
	
	static {
		buttons.add("新增");
		buttons.add("修改");
		buttons.add("删除");
		buttons.add("导入");
		buttons.add("导出");
	}
	
	/**
	 * 系统角色
	 */
	public enum RoleType {
		/**
		 * 系统管理员
		 */
		SYSTEM_ADMIN(0),
		/**
		 * 平台管理员
		 */
		SUPER_ADMIN(1),
		/**
		 * 代理机构
		 */
		AGENCY_ADMIN(2),
		/**
		 * 担保机构
		 */
		GUARATOR_ADMIN(3),
		/**
		 * 供应商
		 */
		SUPPLIER_ADMIN(4),
		/**
		 * 担保机构分部角色
		 */
		GUARATOR_USER(5);
		
		private int value;

		RoleType(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}

	/**
	 * 菜单类型
	 */
	public enum MenuType {
		/**
		 * 目录
		 */
		CATALOG(0),
		/**
		 * 菜单
		 */
		MENU(1),
		/**
		 * 按钮
		 */
		BUTTON(2);

		private int value;

		MenuType(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}

	/**
	 * 定时任务状态
	 */
	public enum ScheduleStatus {
		/**
		 * 暂停
		 */
		NORMAL(0),
		/**
		 * 正常
		 */
		PAUSE(1);

		private int value;

		ScheduleStatus(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}

	/**
	 * @Title: Constant.java
	 * @Description: TODO
	 * @Package com.scbid.common.utils
	 * @Author: wangyun
	 * @Date: 2018年5月24日
	 * @Copyright: 四川国际招标有限责任公司 注意：本内容仅限于必朗科技内部传阅，禁止外泄以及用于其他的商业目的
	 */
	public enum BLWhetherEnum {

		/**
		 * 是
		 */
		YES("是", 1),
		/**
		 * 否
		 */
		NO("否", 2);

		/** 描述 */
		private String name;
		/** 枚举值 */
		private Integer value;

		private BLWhetherEnum(String name, Integer value) {
			this.name = name;
			this.value = value;
		}

		public Integer getValue() {
			return value;
		}

		public String getName() {
			return name;
		}

	}

	public enum InvoiceCategoryEnum {

		INVOICE_CATEGORY_ORDINARY("普通增值税发票", "普");

		/**
		 * 描述
		 */
		private String name;
		/**
		 * 类别
		 */
		private String category;

		private InvoiceCategoryEnum(String name, String category) {
			this.name = name;
			this.category = category;
		}

		public String getName() {
			return name;
		}

		public String getCategory() {
			return category;
		}

	}

	public enum InvoiceStatusEnum {

		INVOICE_STATUS_PENDING_INVOICE("待开票", "0"), INVOICE_STATUS_INVOICED("已开票", "1");

		/**
		 * 描述
		 */
		private String name;
		/**
		 * 状态
		 */
		private String status;

		private InvoiceStatusEnum(String name, String status) {
			this.name = name;
			this.status = status;
		}

		public String getName() {
			return name;
		}

		public String getStatus() {
			return status;
		}

	}

	public enum InvoiceTypeCodeEnum {

		INVOICE_TYPE_CODE_BID_BOOK("其他现代服务", "3049900000000000000");

		/**
		 * 描述
		 */
		private String name;
		/**
		 * 类型编码
		 */
		private String code;

		private InvoiceTypeCodeEnum(String name, String code) {
			this.name = name;
			this.code = code;
		}

		public String getName() {
			return name;
		}

		public String getCode() {
			return code;
		}

	}

	public enum InvoiceTaxRateEnum {

		INVOICE_TAX_RATE_SIX("税率百分之六", 0.06f);

		/**
		 * 描述
		 */
		private String name;
		/**
		 * 税率
		 */
		private Float taxRate;

		private InvoiceTaxRateEnum(String name, Float taxRate) {
			this.name = name;
			this.taxRate = taxRate;
		}

		public String getName() {
			return name;
		}

		public Float getTaxRate() {
			return taxRate;
		}

	}

	/**
	 * 云服务商
	 */
	public enum CloudService {
		/**
		 * 七牛云
		 */
		QINIU(1),
		/**
		 * 阿里云
		 */
		ALIYUN(2),
		/**
		 * 腾讯云
		 */
		QCLOUD(3);

		private int value;

		CloudService(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}

	/**
	 * @author 程云 删除状态
	 */
	public enum DeleteStatus {
		/**
		 * 未删除
		 */
		UNDELETED(0),
		/**
		 * 逻辑删除
		 */
		DELETED(1);

		private int value;

		DeleteStatus(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}

	/**
	 * 
	 * @Title: Constant.java
	 * @Description: 保证金项目状态
	 * @Package com.scbid.common.utils
	 * @Author: wangyun
	 * @Date: 2018年5月19日
	 * @Copyright: 四川国际招标有限责任公司 注意：本内容仅限于必朗科技内部传阅，禁止外泄以及用于其他的商业目的
	 */
	public enum ProjectStatus {
		/**
		 * 
		 */
		STATUS_0(0),
		/**
		 * 待申请
		 */
		STATUS_1(1),
		/**
		 * 申请中
		 */
		STATUS_2(2),
		/**
		 * 审核通过
		 */
		STATUS_3(3),
		/**
		 * 审核未通过
		 */
		STATUS_4(4),
		/**
		 * 
		 */
		STATUS_5(5),
		/**
		 * 
		 */
		STATUS_6(6);
		private int value;
		ProjectStatus(int value) {
			this.value = value;
		}
		public int getValue() {
			return value;
		}
	}

	public enum OrderStatus {
		/**
		 */
		STATUS_0(0),
		/**
		 * 待支付
		 */
		STATUS_1(1),
		/**
		 * 审核通过
		 */
		STATUS_2(2),
		/**
		 * 完成
		 */
		STATUS_3(3),
		/**
		 */
		STATUS_4(4),
		/**
		 * 
		 */
		STATUS_5(5),
		/**
		 * 
		 */
		STATUS_6(6);
		private int value;
		OrderStatus(int value) {
			this.value = value;
		}
		public int getValue() {
			return value;
		}
	}
	/**
	 * @Title: Constant.java
	 * @Description: 支付类型
	 * @Package com.scbid.common.utils
	 * @Author: wangyun
	 * @Date: 2018年5月25日
	 * @Copyright: 四川国际招标有限责任公司 注意：本内容仅限于必朗科技内部传阅，禁止外泄以及用于其他的商业目的
	 */
	public enum PayType {
		/**
		 * 支付宝支付
		 */
		STATUS_1(1),
		/**
		 * 微信支付
		 */
		STATUS_2(2),
		/**
		 * 银联支付
		 */
		STATUS_3(3);
		private int value;
		PayType(int value) {
			this.value = value;
		}
		public int getValue() {
			return value;
		}
	}
	/**
	 * Bucket地址
	 */
	public enum OssBucket {
		/**
		 * 开发环境使用
		 */
		scbid_dev("scbid-dev"),
		/**
		 * 测试环境使用
		 */
		scbid_test("scbid-test"),
		/**
		 * 生产环境使用
		 */
		scbid_net("scbid-net"),
		/**
		 * 发票专用
		 */
		scbid_invoice("scbid-invoice");
		private String value;
		OssBucket(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
	}

	/**
	 * oss目录
	 * 
	 * @Title: Constant.java
	 * @Description: TODO
	 * @Package com.scbid.common.utils
	 * @Author: wangyun
	 * @Date: 2018年5月25日
	 * @Copyright: 四川国际招标有限责任公司 注意：本内容仅限于必朗科技内部传阅，禁止外泄以及用于其他的商业目的
	 */
	public enum OssMenu {
		/**
		 * #系统模板文件目录
		 */
		model("model"),
		/**
		 * #系统采购文件目录
		 */
		purchase("purchase"),
		/**
		 * #系统公告文件目录
		 */
		notice("notice"),
		/**
		 * #系统信用文件目录
		 */
		credit("credit");
		private String value;
		OssMenu(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
	}

	public enum OssType {
		upload(1), getUrl(2), delete(3), download(4);
		private int value;
		OssType(int value) {
			this.value = value;
		}
		public int getValue() {
			return value;
		}
	}

}
