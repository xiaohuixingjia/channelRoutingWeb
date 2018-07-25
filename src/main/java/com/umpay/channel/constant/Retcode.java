package com.umpay.channel.constant;

/**
 * 返回码常量类
 * 
 * @author xuxiaojia 2017年6月6日
 */
public enum Retcode {
	SUCCESS {
		public String getName() {
			return "成功 ";
		}

		public String getCode() {
			return "0000";
		}
	},

	VALIDATE_ERR {
		public String getName() {
			return "参数校验不通过 ";
		}

		public String getCode() {
			return "0101";
		}
	},
	INNER_ERROR {
		public String getName() {
			return "内部错误";
		}

		public String getCode() {
			return "9999";
		}
	};
	public abstract String getName();

	public abstract String getCode();
}
