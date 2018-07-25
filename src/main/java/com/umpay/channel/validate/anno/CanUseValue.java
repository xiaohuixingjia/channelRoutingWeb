package com.umpay.channel.validate.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.umpay.channel.validate.validator.CanUseValueValidator;

@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CanUseValueValidator.class)
public @interface CanUseValue {
	String[]canUseValues();

	String message() default "当前值不在可用值集合中";

	Class<?>[]groups() default {};
	
    Class<? extends Payload>[] payload() default { };  
}
