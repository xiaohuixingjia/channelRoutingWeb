package com.umpay.channel.bean;

import com.umpay.channel.constant.Retcode;

/**
 * 响应json的基类
 * 
 * @author xuxiaojia 2017年6月6日
 */
public class RespBean {
	private String code;
	private String errMsg;
	private Object respInfo;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public Object getRespInfo() {
		return respInfo;
	}

	public void setRespInfo(Object respInfo) {
		this.respInfo = respInfo;
	}

	public RespBean(String code, String errMsg) {
		this.code = code;
		this.errMsg = errMsg;
	}

	public RespBean(String code, String errMsg, Object respInfo) {
		this(code, errMsg);
		this.respInfo = respInfo;
	}

	public RespBean(Retcode retcode, Object respInfo) {
		this(retcode);
		this.respInfo = respInfo;
	}

	public RespBean(Retcode retcode) {
		this(retcode.getCode(), retcode.getName());
	}

}
