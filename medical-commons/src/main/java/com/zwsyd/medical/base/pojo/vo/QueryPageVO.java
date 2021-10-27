package com.zwsyd.medical.base.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
/**
 * <b>系统基础信息类 - 分页查询视图信息</b>
 * <p>
 *     分页视图信息包含以下属性：<br/>
 *     1、查询视图：queryVO<br/>
 *     2、分页视图：pageVO<br/>
 * </p>
 * @author ZhangWei
 * @version 1.0.0
 * @since 1.0.0
 */
@ApiModel("分页查询视图信息")
public class QueryPageVO<E extends BaseVO> implements Serializable {
	private static final long serialVersionUID = 4482312323016566763L;
	@ApiModelProperty("查询视图")
	private E queryVO;                      //查询视图
	@ApiModelProperty("分页视图")
	private PageVO<E> pageVO;               //分页视图

	public QueryPageVO() {
	}

	public QueryPageVO(E queryVO, PageVO<E> pageVO) {
		this.queryVO = queryVO;
		this.pageVO = pageVO;
	}

	public QueryPageVO(E queryVO, Integer pageNum, Integer pageSize){
		PageVO<E> pageVO = new PageVO<E>(pageNum,pageSize);
		this.queryVO = queryVO;
		this.pageVO = pageVO;
	}

	public E getQueryVO() {
		return queryVO;
	}

	public void setQueryVO(E queryVO) {
		this.queryVO = queryVO;
	}

	public PageVO<E> getPageVO() {
		return pageVO;
	}

	public void setPageVO(PageVO<E> pageVO) {
		this.pageVO = pageVO;
	}
}
