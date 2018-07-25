package com.umpay.channel.service;

import com.umpay.channel.bean.ChannelRoutingPO;
import com.umpay.channel.bean.ChannelSupplierPO;
import com.umpay.channel.bean.DataSourcePO;
import com.umpay.channel.bean.Pager;

/**
 * 通道路由服务
 * 
 * @author xuxiaojia
 */
public interface ChannelRoutingService {
	/**
	 * 单个录入数据源信息
	 * 
	 * @param dataSourcePO
	 */
	public void insert(DataSourcePO dataSourcePO);

	/**
	 * 单个录入通道路由信息
	 * 
	 * @param channelRoutingPO
	 */
	public void insert(ChannelRoutingPO channelRoutingPO);

	/**
	 * 单个录入数据源供应商信息
	 * 
	 * @param channelSupplierPO
	 */
	public void insert(ChannelSupplierPO channelSupplierPO);

	/**
	 * 带分页的查询通道路由表的信息
	 * 
	 * @param channelRoutingPO
	 * @param pager
	 * @return
	 */
	public Pager selectByPage(ChannelRoutingPO channelRoutingPO, Pager pager);

	/**
	 * 带分页的查询数据源表的信息
	 * 
	 * @param dataSourcePO
	 * @param pager
	 * @return
	 */
	public Pager selectByPage(DataSourcePO dataSourcePO, Pager pager);

	/**
	 * 带分页的查询数据源供应商表的信息
	 * 
	 * @param channelSupplierPO
	 * @param pager
	 * @return
	 */
	public Pager selectByPage(ChannelSupplierPO channelSupplierPO, Pager pager);

	/**
	 * 更新信息
	 * 
	 * @param dSource
	 */
	public void update(DataSourcePO dSource);

	/**
	 * 更新信息
	 * 
	 * @param channelRoutingPO
	 */
	public void update(ChannelRoutingPO channelRoutingPO,ChannelRoutingPO oldC);

	/**
	 * 更新信息
	 * 
	 * @param channelSupplierPO
	 */
	public void update(ChannelSupplierPO channelSupplierPO);
	/**
	 * 添加信息
	 * 
	 * @param dSource
	 */
	public void add(DataSourcePO dSource);
	
	/**
	 * 添加信息
	 * 
	 * @param channelRoutingPO
	 */
	public void add(ChannelRoutingPO channelRoutingPO);
	
	/**
	 * 添加信息
	 * 
	 * @param channelSupplierPO
	 */
	public void add(ChannelSupplierPO channelSupplierPO);
	/**
	 * 添加信息
	 * 
	 * @param dSource
	 */
	public void del(DataSourcePO dSource);
	
	/**
	 * 添加信息
	 * 
	 * @param channelRoutingPO
	 */
	public void del(ChannelRoutingPO channelRoutingPO);
	
	/**
	 * 添加信息
	 * 
	 * @param channelSupplierPO
	 */
	public void del(ChannelSupplierPO channelSupplierPO);
}
