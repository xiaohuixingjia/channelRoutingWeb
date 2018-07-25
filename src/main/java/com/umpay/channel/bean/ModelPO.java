package com.umpay.channel.bean;

/**
 *
 *
 * 模型配置
 * 
 * @author limo
 * @version 1.0
 * @date 2018年3月6日 下午3:12:09
 * @since
 *
 */
public class ModelPO {
	/*
	 * funcodeId
	 */
	private String product_suites_id;
	/*
	 * 模型名称
	 */
	private String model_name;
	/*
	 * 模型的请求路径
	 */
	private String request_url;
	/*
	 * 模型的定制类
	 */
	private String model_class;
	/*
	 * 模型的配置信息 json
	 */
	private String model_config;
	/*
	 * 是否启用
	 */
	private String isvalid;

	public String getProduct_suites_id() {
		return product_suites_id;
	}

	public void setProduct_suites_id(String product_suites_id) {
		this.product_suites_id = product_suites_id;
	}

	public String getModel_name() {
		return model_name;
	}

	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}

	public String getRequest_url() {
		return request_url;
	}

	public void setRequest_url(String request_url) {
		this.request_url = request_url;
	}

	public String getModel_class() {
		return model_class;
	}

	public void setModel_class(String model_class) {
		this.model_class = model_class;
	}

	public String getModel_config() {
		return model_config;
	}

	public void setModel_config(String model_config) {
		this.model_config = model_config;
	}

	public String getIsvalid() {
		return isvalid;
	}

	public void setIsvalid(String isvalid) {
		this.isvalid = isvalid;
	}

}
