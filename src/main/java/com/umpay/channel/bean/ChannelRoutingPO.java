package com.umpay.channel.bean;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

/**
 * 产品核查信息表
 * 
 * @author xuxiaojia
 */
public class ChannelRoutingPO implements Serializable {
	private static final long serialVersionUID = -7765262598574608064L;
	/**
	 * 没有运营商
	 */
	public static final int NO_OPERATOR_TYPE = -1;
	/**
	 * 运营商 未识别
	 */
	public static final int OPERATOR_TYPE_UNRECOGNIZED = 0;
	/**
	 * 运营商 移动
	 */
	public static final int OPERATOR_TYPE_YIDONG = 1;
	/**
	 * 运营商 联通
	 */
	public static final int OPERATOR_TYPE_LIANTONG = 2;
	/**
	 * 运营商 电信
	 */
	public static final int OPERATOR_TYPE_DIANXIN = 3;
	/* 联合主键拼写成的id */
	private String id;
	/* 产品包编码 */
	@NotNull(groups = { Insert.class }, message = "{productSuitesCode.empty}")
	@Size(max = 50, groups = { Insert.class, Update.class }, message = "{common.maxErrorMsg}50个字符")
	private String productSuitesCode;
	/* 商户编码 */
	@NotNull(groups = { Insert.class }, message = "{merCode.empty}")
	@Size(max = 20, groups = { Insert.class, Update.class }, message = "{common.maxErrorMsg}20个字符")
	private String merCode;
	/* 运营商类型 */
	@NotNull(groups = { Insert.class }, message = "{operatorType.empty}")
	private Integer operatorType;
	/* 数据源ID */
	@NotNull(groups = { Insert.class }, message = "{dsId.empty}")
	@Size(max = 8, groups = { Insert.class, Update.class }, message = "{common.maxErrorMsg}8个字符")
	private String dsId;
	/* 排名 */
	@NotNull(groups = { Insert.class }, message = "{sort.empty}")
	private Integer sort;
	/* 权重 */
	@NotNull(groups = { Insert.class }, message = "{weight.empty}")
	private Integer weight;
	/* 在未查得时是否使用下一个通道 */
	@NotNull(groups = { Insert.class }, message = "{useNext.empty}")
	private Integer useNext;
	
	
	public Integer getUseNext() {
		return useNext;
	}

	public void setUseNext(Integer useNext) {
		this.useNext = useNext;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public ChannelRoutingPO() {
		super();
	}

	public String getProductSuitesCode() {
		return productSuitesCode;
	}

	public void setProductSuitesCode(String productSuitesCode) {
		this.productSuitesCode = productSuitesCode;
	}

	public String getMerCode() {
		return merCode;
	}

	public void setMerCode(String merCode) {
		this.merCode = merCode;
	}

	public Integer getOperatorType() {
		return operatorType;
	}

	public void setOperatorType(Integer operatorType) {
		this.operatorType = operatorType;
	}

	public String getDsId() {
		return dsId;
	}

	public void setDsId(String dsId) {
		this.dsId = dsId;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	@Override
	public String toString() {
		return "ChannelRoutingPO [id=" + id + ", productSuitesCode=" + productSuitesCode + ", merCode=" + merCode
				+ ", operatorType=" + operatorType + ", dsId=" + dsId + ", sort=" + sort + ", weight=" + weight
				+ ", useNext=" + useNext + "]";
	}


}
