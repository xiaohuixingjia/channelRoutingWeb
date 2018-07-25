package com.umpay.channel.validate.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.umpay.channel.validate.validator.URLConnectValidator;

/**
 * 配合springValidate 校验入参的url是否能够联通注解
 * 
 * @author xuxiaojia
 */
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = URLConnectValidator.class)
public @interface URLConnect {
	String message() default "url路径无法连接";

	Class<?>[]groups() default {};
	
    Class<? extends Payload>[] payload() default { };  
}
