package com.zwsyd.medical.system.datacode.transport.impl;

import com.zwsyd.medical.base.pojo.vo.PageVO;
import com.zwsyd.medical.base.pojo.vo.QueryPageVO;
import com.zwsyd.medical.system.datacode.pojo.vo.DataCodeVO;
import com.zwsyd.medical.system.datacode.service.DataCodeService;
import com.zwsyd.medical.system.datacode.transport.DataCodeTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 数据编码功能 - 数据代码信息传输层接口实现类</b>
 * @author ZhangWei
 * @version 1.0.0
 */
@RestController("dataCodeTransport")
@RequestMapping("/system/datacode/trans")
public class DataCodeTransportImpl implements DataCodeTransport {
	@Autowired
	private DataCodeService service;

	/**
	 * <b>根据查询分页视图，查询分页信息</b>
	 * @param queryPageVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	@Override
	public PageVO<DataCodeVO> getPage(@RequestBody QueryPageVO<DataCodeVO> queryPageVO) throws Exception {
		//根据提取 QueryPageVO 数据，获得相应的查询视图和分页视图
		DataCodeVO queryVO = queryPageVO.getQueryVO();
		PageVO<DataCodeVO> pageVO = queryPageVO.getPageVO();
		return service.getPage(queryVO,pageVO);
	}

	/**
	 * <b>根据查询对象查询列表</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	@Override
	public List<DataCodeVO> getList(@RequestBody DataCodeVO queryVO) throws Exception {
		return service.getList(queryVO);
	}

	/**
	 * <b>根据编码查询视图对象</b>
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/code")
	public DataCodeVO getCode(@RequestParam String code) throws Exception{
		return service.getByCode(code);
	}

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	public boolean save(@RequestBody DataCodeVO vo) throws Exception{
		return service.save(vo);
	}

	/**
	 * <b>修改对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	public boolean update(@RequestBody DataCodeVO vo) throws Exception{
		return service.update(vo);
	}

	/**
	 * <b>根据主键查询视图对象</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	public DataCodeVO getId(@RequestParam String id) throws Exception {
		return service.getById(id);
	}
}
