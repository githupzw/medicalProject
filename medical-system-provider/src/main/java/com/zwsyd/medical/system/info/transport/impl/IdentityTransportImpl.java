package com.zwsyd.medical.system.info.transport.impl;

import com.zwsyd.medical.base.pojo.vo.PageVO;
import com.zwsyd.medical.base.pojo.vo.QueryPageVO;
import com.zwsyd.medical.system.info.pojo.vo.IdentityVO;
import com.zwsyd.medical.system.info.service.IdentityService;
import com.zwsyd.medical.system.info.transport.IdentityTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b>智慧医疗信息平台 - 系统用户身份信息传输层接口实现类</b>
 * @author ZhangWei
 * @version 1.0.0
 */
@RestController("identityTransport")
@RequestMapping("/system/info/identity/trans")
public class IdentityTransportImpl implements IdentityTransport {
	@Autowired
	private IdentityService service;
	/**
	 * <b>根据查询对象进行分页查询</b>
	 * @param queryPageVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	public PageVO<IdentityVO> getPage(@RequestBody QueryPageVO<IdentityVO> queryPageVO) throws Exception {
		//分别将 QueryPageVO 中的数据进行获取
		PageVO<IdentityVO> pageVO = queryPageVO.getPageVO();
		IdentityVO queryVO = queryPageVO.getQueryVO();
		return service.getPage(pageVO, queryVO);

	}
}
