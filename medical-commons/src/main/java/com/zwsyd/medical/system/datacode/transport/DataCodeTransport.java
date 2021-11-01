package com.zwsyd.medical.system.datacode.transport;

import com.zwsyd.medical.base.pojo.vo.PageVO;
import com.zwsyd.medical.base.pojo.vo.QueryPageVO;
import com.zwsyd.medical.system.datacode.pojo.vo.DataCodeVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 数据编码功能 - 数据代码信息传输层接口</b>
 * @author ZhangWei
 * @version 1.0.0
 */
@FeignClient("medical-system-provider")
@RequestMapping("/system/datacode/trans")
public interface DataCodeTransport {
	/**
	 * <b>根据查询分页视图，查询分页信息</b>
	 * @param queryPageVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	PageVO<DataCodeVO> getPage(@RequestBody QueryPageVO<DataCodeVO> queryPageVO) throws Exception;

	/**
	 * <b>根据查询对象查询列表</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	List<DataCodeVO> getList(@RequestBody DataCodeVO queryVO) throws Exception;

	/**
	 * <b>根据编码查询视图对象</b>
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/code")
	DataCodeVO getCode(@RequestParam String code) throws Exception;

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	boolean save(@RequestBody DataCodeVO vo) throws Exception;

	/**
	 * <b>修改对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	boolean update(@RequestBody DataCodeVO vo) throws Exception;

	/**
	 * <b>根据主键查询视图对象</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	DataCodeVO getId(@RequestParam String id) throws Exception;
}
