package com.zwsyd.medical.system.info.service;

import com.zwsyd.medical.base.pojo.vo.PageVO;
import com.zwsyd.medical.system.info.pojo.vo.IdentityVO;

/**
 * <b>智慧医疗信息平台 - 系统用户身份信息业务层接口</b>
 * @author ZhangWei
 * @version 1.0.0
 */
public interface IdentityService {
	/**
	 * <b>根据查询对象进行分页查询</b>
	 * @param pageVO
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	PageVO<IdentityVO> getPage(PageVO<IdentityVO> pageVO, IdentityVO queryVO) throws Exception;
}
