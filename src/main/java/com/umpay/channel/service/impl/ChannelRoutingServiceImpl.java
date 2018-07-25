package com.umpay.channel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umpay.channel.bean.ChannelRoutingPO;
import com.umpay.channel.bean.ChannelSupplierPO;
import com.umpay.channel.bean.DataSourcePO;
import com.umpay.channel.bean.Pager;
import com.umpay.channel.dao.ChannelRoutingDao;
import com.umpay.channel.dao.ChannelSupplierDao;
import com.umpay.channel.dao.DataSourceDao;
import com.umpay.channel.service.ChannelRoutingService;

/**
 * 通道路由服务
 * 
 * @author xuxiaojia
 */
@Service
public class ChannelRoutingServiceImpl implements ChannelRoutingService {
	@Autowired
	private ChannelRoutingDao channelRoutingDao;
	@Autowired
	private ChannelSupplierDao channelSupplierDao;
	@Autowired
	private DataSourceDao dataSourceDao;

	public void insert(DataSourcePO dataSourcePO) {
		dataSourceDao.singleInsert(dataSourcePO);
	}

	public void insert(ChannelRoutingPO channelRoutingPO) {
		channelRoutingDao.singleInsert(channelRoutingPO);
	}

	public void insert(ChannelSupplierPO channelSupplierPO) {
		channelSupplierDao.singleInsert(channelSupplierPO);
	}

	public Pager selectByPage(ChannelRoutingPO channelRoutingPO, Pager pager) {
		  pager.setCells(channelRoutingDao.selectByPage(pager, channelRoutingPO));
		return pager;
	}

	public Pager selectByPage(DataSourcePO dataSourcePO, Pager pager) {
		pager.setCells(dataSourceDao.selectByPage(pager, dataSourcePO));
		return pager;
	}

	public Pager selectByPage(ChannelSupplierPO channelSupplierPO, Pager pager) {
		pager.setCells(channelSupplierDao.selectByPage(pager, channelSupplierPO));
		return pager;
	}

	public void update(DataSourcePO dSource) {
		dataSourceDao.update(dSource);
	}

	public void update(ChannelRoutingPO channelRoutingPO,ChannelRoutingPO oldC) {
		channelRoutingDao.update(channelRoutingPO,oldC);
	}

	public void update(ChannelSupplierPO channelSupplierPO) {
		channelSupplierDao.update(channelSupplierPO);
	}

	public void add(DataSourcePO dSource) {
		dataSourceDao.singleInsert(dSource);
	}

	public void add(ChannelRoutingPO channelRoutingPO) {
		channelRoutingDao.singleInsert(channelRoutingPO);
	}

	public void add(ChannelSupplierPO channelSupplierPO) {
		channelSupplierDao.singleInsert(channelSupplierPO);
	}

	public void del(DataSourcePO dSource) {
		dataSourceDao.del(dSource);
	}

	public void del(ChannelRoutingPO channelRoutingPO) {
		channelRoutingDao.del(channelRoutingPO);
	}

	public void del(ChannelSupplierPO channelSupplierPO) {
		channelSupplierDao.del(channelSupplierPO);
	}

}
