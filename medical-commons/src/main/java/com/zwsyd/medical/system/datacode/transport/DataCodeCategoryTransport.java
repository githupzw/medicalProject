package com.zwsyd.medical.system.datacode.transport;

import com.zwsyd.medical.base.pojo.vo.PageVO;
import com.zwsyd.medical.base.pojo.vo.QueryPageVO;
import com.zwsyd.medical.system.datacode.pojo.vo.DataCodeCategoryVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 数据编码功能 - 数据代码类别信息传输层接口</b>
 * @author ZhangWei
 * @version 1.0.0
 */
@FeignClient(name = "medical-system-provider")
@RequestMapping("/system/datacode/category/trans")
public interface DataCodeCategoryTransport {
	/**
	 * <b>根据查询对象分页查询</b>
	 * @param queryPageVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	PageVO<DataCodeCategoryVO> getByPage(@RequestBody QueryPageVO<DataCodeCategoryVO> queryPageVO) throws Exception;

	/**
	 * <b>根据编码查询对象</b>
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/code")
	DataCodeCategoryVO getByCode(@RequestParam String code) throws Exception;

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	boolean save(@RequestBody DataCodeCategoryVO vo) throws Exception;

	/**
	 * <b>根据主键获得视图对象</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	DataCodeCategoryVO getById(@RequestBody String id) throws Exception;
}
