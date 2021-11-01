package com.zwsyd.medical.system.datacode.service;

import com.zwsyd.medical.base.pojo.vo.PageVO;
import com.zwsyd.medical.system.datacode.pojo.vo.DataCodeVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 数据编码功能 - 数据代码信息业务层接口</b>
 * @author ZhangWei
 * @version 1.0.0
 */
public interface DataCodeService {
	/**
	 * <b>根据查询分页视图，查询分页信息</b>
	 * @param queryVO
	 * @param pageVO
	 * @return
	 * @throws Exception
	 */
	PageVO<DataCodeVO> getPage(DataCodeVO queryVO, PageVO<DataCodeVO> pageVO) throws Exception;
	/**
	 * <b>根据查询对象查询列表</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	List<DataCodeVO> getList(DataCodeVO queryVO) throws Exception;

	/**
	 * <b>根据编码查询视图对象</b>
	 * @param code
	 * @return
	 * @throws Exception
	 */
	DataCodeVO getByCode(String code) throws Exception;

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	boolean save(DataCodeVO vo) throws Exception;

	/**
	 * <b>修改对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	boolean update(DataCodeVO vo) throws Exception;

	/**
	 * <b>根据主键查询视图对象</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	DataCodeVO getById(String id) throws Exception;
}
