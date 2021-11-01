package com.zwsyd.medical.system.datacode.dao;

import com.zwsyd.medical.system.datacode.pojo.entity.DataCode;
import com.zwsyd.medical.system.datacode.pojo.entity.DataCodeCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 数据编码功能 - 数据代码信息数据持久层接口</b>
 * @author ZhangWei
 * @version 1.0.0
 */
@Repository
public interface DataCodeDao {
	/**
	 * <b>根据查询对象查询列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<DataCode> findListByQuery(DataCode query) throws Exception;

	/**
	 * <b>保存对象信息</b>
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	int save(DataCode entity) throws Exception;

	/**
	 * <b>修改对象信息</b>
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	int update(DataCode entity) throws Exception ;

}
