package com.zwsyd.medical.base.util;

import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;

import java.util.Properties;

/**
 * <b>系统基础信息 - 系统常量类</b>
 * <p>
 *
 * </p>
 * @author ZhangWei
 * @version 1.0.0
 * @since 1.0.0
 */
public class BaseConstants {
	private static Properties props = new Properties();

	//使用静态代码块加载配置信息
	static{
		try {
			props.load(BaseConstants.class.getClassLoader().getResourceAsStream("props/base/base.properties"));
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * <b>分页信息：默认当前页码</b>
	 */
	public static final Integer PAGE_NUM = Integer.parseInt(props.getProperty("base.page.num"));
	/**
	 * <b>分页信息：默认每页显示数量</b>
	 */
	public static final Integer PAGE_SIZE = Integer.parseInt(props.getProperty("base.page.size"));
	/**
	 * <b>加密密钥信息</b>
	 */
	public static final String SECRET_KEY = props.getProperty("base.secret.key");
	/**
	 *<b>默认用户信息有效时间</b>
	 */
	public static final Long EXPIRE_SECOND= Long.parseLong(props.getProperty("base.expire.second"));
}
