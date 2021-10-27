package com.zwsyd.medical.system.info.pojo.entity;

import com.zwsyd.medical.base.pojo.entity.BaseEntity;



/**
 * <b>智慧医疗信息平台 - 系统用户身份信息实体</b>
 * @author ZhangWei
 * @version 1.0.0
 */
public class Identity extends BaseEntity {
	private static final long serialVersionUID = -1303510156260568777L;
	private String id;                      //主键
	private String name;                    //身份名称
	private String code;                    //身份编码
	private String tableName;               //对应数据表名

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

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
}
