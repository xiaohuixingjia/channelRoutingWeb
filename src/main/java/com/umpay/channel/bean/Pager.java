package com.umpay.channel.bean;

import java.util.List;

/**
 * 分页组件
 * 
 * @author xuxiaojia 2017年6月6日
 */
public class Pager {
	/* 页码 */
	private Integer page = 0;
	/* 每页显示数量 */
	private Integer rows = 10;
	/* 返回总记录数 */
	private Integer total;
	/* 返回总页数 */
	private Integer totalPage;
	/* 排序依据 */
	private String sidx;
	/* 排序规则 */
	private String sord;
	/* 数据集合 */
	private List<?> cells;

	public Pager() {
		this.page = 1;
		this.rows = 10;
	}

	public Pager(Integer page, Integer rows) {
		if (page == null || page < 1) {
			this.page = 1;
		} else {
			this.page = page;
		}
		if (rows == null) {
			this.rows = 10;
		} else {
			this.rows = rows;
		}
	}

	public Pager(Integer total, List<?> cells) {
		this.total = total;
		this.cells = cells;
		this.totalPage = ((total + this.rows) - 1) / this.rows;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public List<?> getCells() {
		return cells;
	}

	public void setCells(List<?> cells) {
		this.cells = cells;
	}

	public String getSidx() {
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public String getSord() {
		return sord;
	}

	public void setSord(String sord) {
		this.sord = sord;
	}

	@Override
	public String toString() {
		return "Pager [page=" + page + ", rows=" + rows + ", total=" + total + ", totalPage=" + totalPage + ", sidx="
				+ sidx + ", sord=" + sord + ", cells=" + cells + "]";
	}

}
