package com.zwsyd.medical.base.pojo.vo;


import com.zwsyd.medical.base.pojo.enums.ResponseCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.io.Serializable;
/**
 * <b>系统基础信息类 - 系统响应视图信息</b>
 * <p>
 *     系统响应视图信息包含以下属性：<br/>
 *     1、响应编码：code<br/>
 *     2、响应数据：data<br/>
 *     所有返回前端数据<b>都必须以本响应视图信息返回</b>
 * </p>
 * @param <E>
 * @author ZhangWei
 * @version 1.0.0
 * @since 1.0.0
 */
@ApiModel("系统基础信息类 - 系统响应视图信息")
public class ResponseVO<E> implements Serializable {
	private static final long serialVersionUID = -3029717334502266895L;
	@ApiModelProperty(name = "系统响应编码", example = "2000")
	private Integer code;                       //系统响应编码
	@ApiModelProperty(name = "系统响应数据")
	private E data;                             //系统响应数据
	//为了禁止其他人创建这个构造方法，将其私有化
	private ResponseVO(Integer code, E data) {
		this.code = code;
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	/**
	 * <b>获得系统响应成功视图信息</b>
	 * @return
	 */
	public static ResponseVO getSuccessResponseVO(){
		return new ResponseVO(ResponseCodeEnum.RESPONSE_CODE_SUCCESS.getCode(),
				ResponseCodeEnum.RESPONSE_CODE_SUCCESS.getRemark());
	}

	/**
	 * <b>获得系统响应成功视图信息</b>
	 * @param data
	 * @return
	 */
	public static ResponseVO getSuccessResponseVO(Object data){
		return new ResponseVO(ResponseCodeEnum.RESPONSE_CODE_SUCCESS.getCode(), data);
	}

	/**
	 * <b>获得用户未认证视图信息</b>
	 * @return
	 */
	public static ResponseVO getUnAuthResponseVO(){
		return new ResponseVO(ResponseCodeEnum.RESPONSE_CODE_UNAUTH.getCode(),
				ResponseCodeEnum.RESPONSE_CODE_UNAUTH.getRemark());
	}

	/**
	 * <b>获得系统业务处理错误视图信息</b>
	 * @param data
	 * @return
	 */
	public static ResponseVO getErrorResponseVO(Object data){
		return new ResponseVO(ResponseCodeEnum.RESPONSE_CODE_ERROR.getCode(), data);
	}

	/**
	 * <b>获得系统响应异常视图信息</b>
	 * @param e
	 * @return
	 */
	public static ResponseVO getExceptionResponseVO(Exception e){
		return new ResponseVO(ResponseCodeEnum.RESPONSE_CODE_EXCEPTION.getCode(), e.getMessage());
	}
}
