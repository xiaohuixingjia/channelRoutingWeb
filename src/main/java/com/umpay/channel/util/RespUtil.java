package com.umpay.channel.util;

import com.umpay.channel.bean.RespBean;
import com.umpay.channel.constant.Retcode;
import com.umpay.channel.exception.BaseException;

/**
 * 相应工具类
 * 
 * @author xuxiaojia 2017年6月6日
 */
public class RespUtil {
	/**
	 * 创建成功相应返回
	 * 
	 * @param object
	 * @return
	 */
	public static RespBean buildSuccess(Object object) {
		return new RespBean(Retcode.SUCCESS, object);
	}

	/**
	 * 创建异常响应信息
	 * 
	 * @param e
	 * @return
	 */
	public static RespBean buildError(BaseException e) {
		return new RespBean(e.getRetcode().getCode(), e.getErrMsg());
	}

	/**
	 * 创建异常响应信息
	 * 
	 * @param retcode
	 *            异常码枚举
	 * @return
	 */
	public static RespBean buildError(Retcode retcode) {
		return new RespBean(retcode);
	}
}
