package com.umpay.channel.validate.validator;

import java.net.HttpURLConnection;
import java.net.URL;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.umpay.channel.validate.anno.URLConnect;

/**
 * url路径是否能了连接通 校验器
 * 
 * @author xuxiaojia
 */
public class URLConnectValidator implements ConstraintValidator<URLConnect, String> {

	public void initialize(URLConnect constraintAnnotation) {
	}

	public boolean isValid(String url, ConstraintValidatorContext context) {
		int status = 404;
		try {
			URL urlObj = new URL(url);
			HttpURLConnection oc = (HttpURLConnection) urlObj.openConnection();
			oc.setUseCaches(false);
			oc.setConnectTimeout(1000); // 设置超时时间
			status = oc.getResponseCode();// 请求状态
			if (200 == status) {
				// 200是请求地址顺利连通。。
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}

}
