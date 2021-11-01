package com.zwsyd.medical.system.datacode.pojo.entity;

import com.zwsyd.medical.base.pojo.entity.BaseEntity;
import com.zwsyd.medical.system.datacode.pojo.vo.DataCodeCategoryVO;
import com.zwsyd.medical.system.datacode.pojo.vo.DataCodeVO;
import org.springframework.beans.BeanUtils;


/**
 * <b>智慧医疗信息平台 - 系统功能 - 数据编码功能 - 数据代码信息实体</b>
 * @author ZhangWei
 * @version 1.0.0
 */
public class DataCode extends BaseEntity {
	private static final long serialVersionUID = -6540667599981073786L;
	private String id;                                  //主键
	private DataCodeCategory dataCategory;              //所属代码类别
	private String name;                                //数据代码名称
	private String code;                                //数据代码编码

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public DataCodeCategory getDataCategory() {
		return dataCategory;
	}

	public void setDataCategory(DataCodeCategory dataCategory) {
		this.dataCategory = dataCategory;
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
	public static DataCode getEntityFromVO(DataCodeVO vo){
		//创建实体对象
		DataCode entity = new DataCode();
		if(vo != null){
			BeanUtils.copyProperties(vo, entity);
			//判断关联属性视图对象，并且进行属性切换
			if(vo.getDataCategoryVO() != null){
				DataCodeCategory parentEntity = DataCodeCategory.getEntityFromVO(vo.getDataCategoryVO());
				entity.setDataCategory(parentEntity);
			}
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
