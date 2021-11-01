package com.zwsyd.medical.system.datacode.pojo.entity;

import com.zwsyd.medical.base.pojo.entity.BaseEntity;
import com.zwsyd.medical.system.datacode.pojo.vo.DataCodeCategoryVO;
import org.springframework.beans.BeanUtils;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 数据编码功能 - 数据代码类别信息实体</b>
 * @author ZhangWei
 * @version 1.0.0
 */
public class DataCodeCategory extends BaseEntity {
	private static final long serialVersionUID = 1230737066816627178L;
	private String id;                      //主键
	private String name;                    //姓名
	private String code;                    //编码

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * <b>根据视图对象创建实体对象</b>
	 * @param vo
	 * @return
	 */
	public static DataCodeCategory getEntityFromVO(DataCodeCategoryVO vo){
		//创建实体对象
		DataCodeCategory entity = new DataCodeCategory();
		if(vo != null){
			BeanUtils.copyProperties(vo, entity);
			//切换所有的继承对象属性
			entity.setStatus(vo.getStatus());
			entity.setCreateUser(vo.getCreateUser());
			entity.setCreateTime(vo.getCreateTime());
			entity.setUpdateUser(vo.getUpdateUser());
			entity.setUpdateTime(vo.getUpdateTime());
		}
		return entity;

	}
}
