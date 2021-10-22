package com.zwsyd.medical.base.pojo.enums;


import java.util.Properties;

/**
 * <b>系统基础信息类 - 系统枚举信息常量类</b>
 * <p>
 *     本枚举信息常量类只为系统相应的枚举类型准备
 * </p>
 */
class BaseEnumConstans {
	private static Properties props = new Properties();

	//使用静态代码块加载配置信息
	static {
		try {
			props.load(BaseEnumConstans.class.getClassLoader().getResourceAsStream("props/base/enums.properties"));
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * <b>系统状态：启用</b>
	 */
	static final String ENUM_STATUS_ENABLE = props.getProperty("enum.status.enable");
	/**
	 * <b>系统状态：禁用</b>
	 */
	static final String ENUM_STATUS_DISABLE = props.getProperty("enum.status.disable");
	/**
	 * <b>系统响应编码：系统响应成功</b>
	 */
	static final Integer ENUM_RESPONSE_CODE_SUCCESS = Integer.parseInt(props.getProperty("enum.response.code.success"));
	/**
	 * <b>系统响应编码：用户未认证</b>
	 */
	static final Integer ENUM_RESPONSE_CODE_UNAUTH = Integer.parseInt(props.getProperty("enum.response.code.unauth"));
	/**
	 * <b>系统响应编码：系统业务处理错误</b>
	 */
	static final Integer ENUM_RESPONSE_CODE_ERROR = Integer.parseInt(props.getProperty("enum.response.code.error"));
	/**
	 * <b>系统响应编码：系统响应异常</b>
	 */
	static final Integer ENUM_RESPONSE_CODE_EXCEPTION = Integer.parseInt(props.getProperty("enum.response.code.exception"));
}
