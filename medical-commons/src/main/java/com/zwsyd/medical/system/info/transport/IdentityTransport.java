package com.zwsyd.medical.system.info.transport;

import com.zwsyd.medical.base.pojo.vo.PageVO;
import com.zwsyd.medical.base.pojo.vo.QueryPageVO;
import com.zwsyd.medical.system.info.pojo.entity.Identity;
import com.zwsyd.medical.system.info.pojo.vo.IdentityVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <b>智慧医疗信息平台 - 系统用户身份信息传输层接口</b>
 * @author ZhangWei
 * @version 1.0.0
 */
@FeignClient(name = "medical-system-provider")
@RequestMapping("/system/info/identity/trans")
public interface IdentityTransport {
	/**
	 * <b>根据查询对象进行分页查询</b>
	 * @param queryPageVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	PageVO<IdentityVO> getPage(@RequestBody QueryPageVO<IdentityVO> queryPageVO) throws Exception;
}
