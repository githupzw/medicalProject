package com.zwsyd.medical.system.datacode.pojo.vo;

import com.zwsyd.medical.base.pojo.vo.BaseVO;
import com.zwsyd.medical.system.datacode.pojo.entity.DataCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.BeanUtils;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 数据编码功能 - 数据代码信息视图</b>
 * @author ZhangWei
 * @version 1.0.0
 */
@ApiModel("数据代码信息视图")
public class DataCodeVO extends BaseVO {
	private static final long serialVersionUID = 1992614045681576558L;
	@ApiModelProperty("主键")
	private String id;                                  //主键
	@ApiModelProperty("所属代码类别")
	private DataCodeCategoryVO dataCategoryVO;              //所属代码类别
	@ApiModelProperty("数据代码名称")
	private String name;                                //数据代码名称
	@ApiModelProperty("数据代码编码")
	private String code;                                //数据代码编码

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public DataCodeCategoryVO getDataCategoryVO() {
		return dataCategoryVO;
	}

	public void setDataCategoryVO(DataCodeCategoryVO dataCategoryVO) {
		this.dataCategoryVO = dataCategoryVO;
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
	 * <b>根据实体对象创建视图对象</b>
	 * @param entity
	 * @return
	 */
	public static DataCodeVO getVOFromEntity(DataCode entity){
		//创建实体对象
		DataCodeVO vo = new DataCodeVO();
		if(entity != null){
			BeanUtils.copyProperties(entity,vo );
			//判断关联属性对象是否存在
			if(entity.getDataCategory() != null){
				//创建关联属性视图对象
				DataCodeCategoryVO parentVO = new DataCodeCategoryVO();
				//进行属性切换
				parentVO = DataCodeCategoryVO.getVOFromEntity(entity.getDataCategory());
				vo.setDataCategoryVO(parentVO);
			}
			//切换所有的继承对象属性
			vo.setStatus(entity.getStatus());
			vo.setCreateUser(entity.getCreateUser());
			vo.setCreateTime(entity.getCreateTime());
			vo.setUpdateUser(entity.getUpdateUser());
			vo.setUpdateTime(entity.getUpdateTime());
		}
		return vo;

	}
}
