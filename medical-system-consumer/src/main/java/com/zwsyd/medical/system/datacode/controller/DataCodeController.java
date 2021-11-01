package com.zwsyd.medical.system.datacode.controller;

import com.zwsyd.medical.base.controller.BaseController;

import com.zwsyd.medical.base.pojo.vo.PageVO;
import com.zwsyd.medical.base.pojo.vo.QueryPageVO;
import com.zwsyd.medical.base.pojo.vo.ResponseVO;
import com.zwsyd.medical.system.datacode.pojo.vo.DataCodeVO;
import com.zwsyd.medical.system.datacode.transport.DataCodeCategoryTransport;
import com.zwsyd.medical.system.datacode.transport.DataCodeTransport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * <b>智慧医疗信息平台 - 系统功能 - 数据编码功能 - 数据代码信息控制层类</b>
 * @author ZhangWei
 * @version 1.0.0
 */
@Api(value = "数据代码信息控制层类",tags = "智慧医疗信息平台 - 系统功能 - 数据编码功能 - 数据代码信息控制层类")
@RestController("dataCodeController")
@RequestMapping("/system/datacode")
public class DataCodeController extends BaseController {
	@Autowired
	private DataCodeTransport transport;
	@Autowired
	private DataCodeCategoryTransport categoryTransport;

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
	public ResponseVO queryPage(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize,
	                            @RequestBody DataCodeVO queryVO) throws Exception{
		//根据分页信息和查询视图信息，创建 queryPageVO 对象
		QueryPageVO<DataCodeVO> queryPageVO = new QueryPageVO<DataCodeVO>(queryVO,pageNum,pageSize);
		//进行分页查询，获得分页对象
		PageVO<DataCodeVO> pageVO = transport.getPage(queryPageVO);
		return ResponseVO.getSuccessResponseVO(pageVO);
	}

	/**
	 * <b>根据查询对象查询列表</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "根据查询对象查询列表", tags = "根据查询对象查询列表")
	@PostMapping("/list")
	public ResponseVO queryList(@RequestBody DataCodeVO queryVO) throws Exception {
		return ResponseVO.getSuccessResponseVO(transport.getList(queryVO));
	}

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "保存对象",tags = "保存对象")
	@PostMapping("/save")
	public ResponseVO save(@RequestBody DataCodeVO vo) throws Exception{
		//判断用户所填写的数据是否存在
		if(vo.getName() != null && !"".equals(vo.getName().trim())
				&& vo.getCode() != null && !"".equals(vo.getCode().trim())){
			if(vo.getDataCategoryVO() != null && vo.getDataCategoryVO().getId() != null){
				//校验所给定的数据编码类别存在
				if (categoryTransport.getById(vo.getDataCategoryVO().getId()) != null){
					//判断编码是否被占用
					if (transport.getCode(vo.getCode()) == null){
						//保存数据
						if (transport.save(vo)){
							return ResponseVO.getSuccessResponseVO("添加成功");
						}
						return ResponseVO.getErrorResponseVO("添加失败");
					}
					return ResponseVO.getErrorResponseVO("该编码已被使用");
				}
				return ResponseVO.getErrorResponseVO("未选择有效的数据编码类别信息");
			}
			return ResponseVO.getErrorResponseVO("未选择对应的数据编码类别信息");
		}
		return ResponseVO.getErrorResponseVO("未填写有效的名称和编码");
	}

	/**
	 * <b>修改对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "修改对象",tags = "修改对象")
	@PostMapping("/update")
	public ResponseVO update(@RequestBody DataCodeVO vo) throws Exception {
		//判断用户所填写的数据是否存在
		if(vo.getName() != null && !"".equals(vo.getName().trim())
				&& vo.getCode() != null && !"".equals(vo.getCode().trim())){
			if(vo.getDataCategoryVO() != null && vo.getDataCategoryVO().getId() != null){
				//校验所给定的数据编码类别存在
				if (categoryTransport.getById(vo.getDataCategoryVO().getId()) != null){
					//判断编码是否被占用
					if (transport.getCode(vo.getCode()) == null || transport.getCode(vo.getCode()).getId() == vo.getId()){
						//保存数据
						if (transport.update(vo)){
							return ResponseVO.getSuccessResponseVO("添加成功");
						}
						return ResponseVO.getErrorResponseVO("添加失败");
					}
					return ResponseVO.getErrorResponseVO("该编码已被使用");
				}
				return ResponseVO.getErrorResponseVO("未选择有效的数据编码类别信息");
			}
			return ResponseVO.getErrorResponseVO("未选择对应的数据编码类别信息");
		}
		return ResponseVO.getErrorResponseVO("未填写有效的名称和编码");
	}

	/**
	 * <b>根据编码查询对象</b>
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "根据编码查询对象",tags = "根据编码查询对象")
	@GetMapping("/code/{code}")
	public ResponseVO queryByCode(@PathVariable("code") String code) throws Exception{
		return ResponseVO.getSuccessResponseVO(transport.getCode(code));
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
		return ResponseVO.getSuccessResponseVO(transport.getId(id));
	}
}
