package com.umpay.channel.bean;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import com.umpay.channel.validate.anno.CanUseValue;
import com.umpay.channel.validate.anno.URLConnect;

/**
 * 数据源表 DS_CHANNEL_DATA_SOURCE
 * 
 * @author xuxiaojia
 */
public class DataSourcePO implements Serializable {
	private static final long serialVersionUID = 7401545519282507362L;
	/**
	 * 数据源状态为可用
	 */
	public static final int DS_CAN_USE_2_STRING = 2;
	/**
	 * 数据源状态为不可用
	 */
	public static final int DS_CAN_NOT_USE_2_STRING = 4;
	/**
	 * 当前数据源可用
	 */
	public static final boolean DS_CAN_USE_2_BOOLEAN = true;
	/**
	 * 当前数据源不可用
	 */
	public static final boolean DS_CAN_NOT_USE_2_BOOLEAN = false;
	/* 数据源ID */
	@NotNull(groups = { Update.class }, message = "{common.id.empty}")
	@Null(groups = { Insert.class }, message = "{common.id.mustNull}")
	@Size(max = 8, groups = { Update.class }, message = "{common.maxErrorMsg}8个字符")
	private String id;
	/* 数据源名称 */
	@NotNull(groups = { Insert.class }, message = "{common.name.empty}")
	@Size(max = 200, groups = { Insert.class, Update.class }, message = "{common.maxErrorMsg}200个字符")
	private String name;
	/* 数据源路径 */
	@NotNull(groups = { Insert.class }, message = "{url.empty}")
	@Size(max = 50, groups = { Insert.class, Update.class }, message = "{common.maxErrorMsg}50个字符")
	@URLConnect(groups = { Insert.class, Update.class }, message = "{common.urlCanotConnect}")
	private String url;
	/* 当前数据源状态 */
	@NotNull(groups = { Insert.class }, message = "{state.empty}")
	@CanUseValue(groups = { Insert.class, Update.class }, canUseValues = { "2", "4" }, message = "{common.value.error}")
	private Integer state;
	/* 供应商ID */
	@NotNull(groups = { Insert.class, }, message = "{supplierId.empty}")
	@Size(max = 20, groups = { Insert.class, Update.class }, message = "{common.maxErrorMsg}20个字符")
	private String supplierId;
	/* 是否使用habse 2使用，4不使用 */
	@NotNull(groups = { Insert.class }, message = "{hbaseState.empty}")
	@CanUseValue(groups = { Insert.class, Update.class }, canUseValues = { "2", "4" }, message = "{common.value.error}")
	private Integer hbaseState;
	/* 扫描的表 */
	@Size(max = 50, groups = { Insert.class, Update.class }, message = "{common.maxErrorMsg}50个字符")
	private String hbaseTable;
	/* hbase查得的返回结果 */
	@Size(max = 50, groups = { Insert.class, Update.class }, message = "{common.maxErrorMsg}50个字符")
	private String hbaseResult;
	/* rowKey值集合 逗号分隔 */
	@Size(max = 300, groups = { Insert.class, Update.class }, message = "{common.maxErrorMsg}300个字符")
	private String keyNames;
	/* value值加密次数 */
	@Min(value = 0, groups = { Insert.class, Update.class }, message = "{encryptTime.empty}")
	private Integer encryptTime;
	/* 是否先查缓存 */
	@NotNull(groups = { Insert.class }, message = "{cacheState.empty}")
	@CanUseValue(groups = { Insert.class, Update.class }, canUseValues = { "2", "4" }, message = "{common.value.error}")
	private Integer cacheState;
	/* 返回结果不入缓存的配置 */
	@Size(max = 300, groups = { Insert.class, Update.class }, message = "{common.maxErrorMsg}300个字符")
	private String noCacheResu;

	public Integer getCacheState() {
		return cacheState;
	}

	public void setCacheState(Integer cacheState) {
		this.cacheState = cacheState;
	}

	public String getNoCacheResu() {
		return noCacheResu;
	}

	public void setNoCacheResu(String noCacheResu) {
		this.noCacheResu = noCacheResu;
	}

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public Integer getHbaseState() {
		return hbaseState;
	}

	public void setHbaseState(Integer hbaseState) {
		this.hbaseState = hbaseState;
	}

	public String getHbaseTable() {
		return hbaseTable;
	}

	public void setHbaseTable(String hbaseTable) {
		this.hbaseTable = hbaseTable;
	}

	public String getHbaseResult() {
		return hbaseResult;
	}

	public void setHbaseResult(String hbaseResult) {
		this.hbaseResult = hbaseResult;
	}

	public String getKeyNames() {
		return keyNames;
	}

	public void setKeyNames(String keyNames) {
		this.keyNames = keyNames;
	}

	public Integer getEncryptTime() {
		return encryptTime;
	}

	public void setEncryptTime(Integer encryptTime) {
		this.encryptTime = encryptTime;
	}

	@Override
	public String toString() {
		return "DataSourcePO [id=" + id + ", name=" + name + ", url=" + url + ", state=" + state + ", supplierId="
				+ supplierId + ", hbaseState=" + hbaseState + ", hbaseTable=" + hbaseTable + ", hbaseResult="
				+ hbaseResult + ", keyNames=" + keyNames + ", encryptTime=" + encryptTime + ", cacheState=" + cacheState
				+ ", noCacheResu=" + noCacheResu + "]";
	}


}
