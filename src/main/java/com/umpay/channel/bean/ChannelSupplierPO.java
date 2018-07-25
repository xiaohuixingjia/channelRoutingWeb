package com.umpay.channel.bean;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

/**
 * 数据源供应商表 DS_CHANNEL_SUPPLIER
 * 
 * @author xuxiaojia
 */
public class ChannelSupplierPO implements Serializable {

	private static final long serialVersionUID = -945921546441527049L;
	/**
	 * ID 主键
	 */
	@NotNull(groups = { Update.class }, message = "{common.id.empty}")
	@Null(groups = { Insert.class }, message = "{common.id.mustNull}")
	private String id;
	/**
	 * 数据源供应商名称
	 */
	@NotNull(groups = { Insert.class }, message = "{common.name.empty}")
	@Size(max = 200, groups = { Insert.class, Update.class }, message = "{common.maxErrorMsg}200个字符")
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
