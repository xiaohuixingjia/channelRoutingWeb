package com.umpay.channel.validate.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.umpay.channel.validate.anno.CanUseValue;

/**
 * 可用值校验器
 * 
 * @author xuxiaojia
 */
public class CanUseValueValidator implements ConstraintValidator<CanUseValue, Object> {
	private Set<String> set;

	public void initialize(CanUseValue anno) {
		set = new HashSet<String>();
		set.addAll(Arrays.asList(anno.canUseValues()));
	}

	public boolean isValid(Object value, ConstraintValidatorContext context) {
		if (set.isEmpty()) {
			return true;
		}
		if (value == null) {
			return false;
		}
		if (set.contains(value.toString())) {
			return true;
		}
		return false;
	}

}
