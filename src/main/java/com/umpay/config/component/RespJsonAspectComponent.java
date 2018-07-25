package com.umpay.config.component;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.umpay.channel.constant.Retcode;
import com.umpay.channel.exception.BaseException;
import com.umpay.channel.util.RespUtil;

/**
 * 所有的响应json的返回的aop拦截，进行异常处理的组件
 * 
 * @author xuxiaojia 2017年6月6日
 */
@Component
@Aspect
public class RespJsonAspectComponent {
	@Around("@annotation(org.springframework.web.bind.annotation.ResponseBody)")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		Object resu;
		try {
			resu = pjp.proceed();
		} catch (BaseException e) {
			resu = RespUtil.buildError(e);
		} catch (Exception e) {
			resu = RespUtil.buildError(Retcode.INNER_ERROR);
			e.printStackTrace();
		}
		return resu;
	}
}
