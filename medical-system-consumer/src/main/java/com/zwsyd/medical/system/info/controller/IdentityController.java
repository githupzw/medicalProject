package com.zwsyd.medical.system.info.controller;


import com.zwsyd.medical.base.controller.BaseController;
import com.zwsyd.medical.base.pojo.vo.PageVO;
import com.zwsyd.medical.base.pojo.vo.QueryPageVO;
import com.zwsyd.medical.base.pojo.vo.ResponseVO;
import com.zwsyd.medical.system.info.pojo.entity.Identity;
import com.zwsyd.medical.system.info.pojo.vo.IdentityVO;
import com.zwsyd.medical.system.info.transport.IdentityTransport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * <b>智慧医疗信息平台 - 系统用户身份信息控制层</b>
 * @author ZhangWei
 * @version 1.0.0
 */
@Api("智慧医疗信息平台 - 系统用户身份信息交互接口")
@RestController("identityController")
@RequestMapping("/system/info/identity")
public class IdentityController extends BaseController {
	@Autowired
	private IdentityTransport transport;

	/**
	 * <b>根据查询对象，分页查询</b>
	 * @param pageNum
	 * @param pageSize
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	//tags 是中文显示  notes 是英文显示
	@ApiOperation(value = "根据查询对象，分页查询", tags = "根据查询对象，分页查询")
	@PostMapping("/page/{pageNum}/{pageSize}")
	public ResponseVO<PageVO<IdentityVO>> queryPage(
			@PathVariable("pageNum") Integer pageNum,
			@PathVariable("pageSize") Integer pageSize,
			@RequestBody IdentityVO queryVO) throws Exception{
		//根据分页信息创建分页视图对象
		//PageVO<IdentityVO> pageVO = new PageVO<IdentityVO>(pageNum,pageSize);
		//根据查询视图和分页视图创建 QueryPageVO 对象
		QueryPageVO<IdentityVO> queryPageVO = new QueryPageVO<IdentityVO>(queryVO, pageNum, pageSize);
		//调用传输层，根据查询视图，和分页信息进行分页查询
		PageVO<IdentityVO> pageVO = transport.getPage(queryPageVO);
		//得到分页对象，创建对应的响应对象
		return ResponseVO.getSuccessResponseVO(pageVO);
	}
}
