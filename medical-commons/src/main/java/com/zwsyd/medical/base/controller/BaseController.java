package com.zwsyd.medical.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <b>系统基础信息类 - 控制层基础类</b>
 * <p>
 *     控制层基础类依赖注入了如下信息：<br/>
 *     1、HttpServletRequest<br/>
 *     2、HttpServletResponse<br/>
 *     3、HttpSession<br/>
 *     其余所有功能控制层类<b>都必须继承于本控制层基础类</b>
 * </p>
 * @author ZhangWei
 * @version 1.0.0
 * @since 1.0.0
 */
@Controller("baseController")
public class BaseController {
	@Autowired
	protected HttpServletRequest httpServletRequest;
	@Autowired
	protected HttpServletResponse httpServletResponse;
	@Autowired
	protected HttpSession httpSession;
}
