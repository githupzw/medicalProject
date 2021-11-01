package com.zwsyd.medical.system.datacode.controller;

import com.zwsyd.medical.base.controller.BaseController;
import com.zwsyd.medical.base.pojo.vo.PageVO;
import com.zwsyd.medical.base.pojo.vo.QueryPageVO;
import com.zwsyd.medical.base.pojo.vo.ResponseVO;
import com.zwsyd.medical.system.datacode.pojo.vo.DataCodeCategoryVO;
import com.zwsyd.medical.system.datacode.transport.DataCodeCategoryTransport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 数据编码功能 - 数据代码类别信息控制层类</b>
 * @author ZhangWei
 * @version 1.0.0
 */
@Api(value = "数据代码类别信息控制层类" ,tags = "智慧医疗信息平台 - 系统功能 - 数据编码功能 - 数据代码类别信息控制层类")
@RestController("dataCodeCategoryController")
@RequestMapping("/system/datacode/category")
public class DataCodeCategoryController extends BaseController {
	@Autowired
	private DataCodeCategoryTransport transport;

	/**
	 * <b>根据查询对象进行分页查询</b>
	 * @param pageNum
	 * @param pageSize
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "根据查询对象进行分页查询", tags = "根据查询对象进行分页查询")
	@PostMapping("/page/{pageNum}/{pageSize}")
	public ResponseVO queryByPage(@PathVariable("pageNum") Integer pageNum,
	                              @PathVariable("pageSize") Integer pageSize,
	                              @RequestBody DataCodeCategoryVO queryVO)
			throws Exception{
		//根据分页信息和查询对象创建查询分页视图
		QueryPageVO<DataCodeCategoryVO> queryPageVO = new QueryPageVO<DataCodeCategoryVO>(queryVO,pageNum,pageSize);
		//进行分页查询获得分页试图
		PageVO<DataCodeCategoryVO> pageVO = transport.getByPage(queryPageVO);
		return ResponseVO.getSuccessResponseVO(pageVO);

	}

	/**
	 * <b>根据查询对象查询列表</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "根据查询对象查询列表",tags = "根据查询对象查询列表")
	@RequestMapping("/list")
	public ResponseVO queryListByQuery(@RequestBody DataCodeCategoryVO queryVO) throws Exception{
		return null;
	}

	/**
	 * <b>保存对象信息</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "保存对象信息", tags = "保存对象信息")
	@RequestMapping("/save")
	public ResponseVO save(@RequestBody DataCodeCategoryVO vo) throws Exception{
		//校验用户所给定的信息必须存在
		if(vo.getName() != null && !"".equals(vo.getName().trim())
				&& vo.getCode() != null && !"".equals(vo.getCode().trim())){
			//校验编码是否唯一
			if(transport.getByCode(vo.getCode()) == null){
				//对应的类别信息有效，进行保存
				if(transport.save(vo)){
					return ResponseVO.getSuccessResponseVO("保存成功");
				}else {
					return ResponseVO.getErrorResponseVO("保存失败");
				}
			}else {
				return ResponseVO.getErrorResponseVO("该类别编码已被使用");
			}
		}else {
			return ResponseVO.getErrorResponseVO("未填写类别名称和编码");
		}
	}

	/**
	 * <b>修改对象信息</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "修改对象信息",tags = "修改对象信息")
	@PostMapping("/update")
	public ResponseVO update(@RequestBody DataCodeCategoryVO vo) throws Exception{
		return null;
	}

	/**
	 * <b>根据主键查询对象</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "根据主键查询对象",tags = "根据主键查询对象")
	@GetMapping("/id/{id}")
	public ResponseVO queryById(@PathVariable("id") String id) throws Exception{
		return null;
	}

	/**
	 * <b>按照编码查询对象</b>
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "按照编码查询对象",tags = "按照编码查询对象")
	@GetMapping("/code/{code}")
	public ResponseVO queryByCode(@PathVariable("code") String code) throws Exception{
		return null;
	}
}
