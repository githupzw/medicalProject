package com.zwsyd.medical.system.info.dao;

import com.zwsyd.medical.system.info.pojo.entity.Identity;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * <b>智慧医疗信息平台 - 系统用户身份信息数据持久层接口</b>
 * @author ZhangWei
 * @version 1.0.0
 */
@Repository
public interface IdentityDao {
	/**
	 * <b>根据查询对象查询列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<Identity> findListByQuery(Identity query) throws Exception;

	/**
	 * <b>保存对象</b>
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	int save(Identity entity) throws Exception;

	/**
	 * <b>修改对象</b>
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	int update(Identity entity) throws Exception;
}
