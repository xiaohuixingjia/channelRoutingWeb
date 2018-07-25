package com.umpay.channel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.umpay.channel.bean.ChannelSupplierPO;
import com.umpay.channel.bean.Pager;

/**
 * 数据源供应商信息表 dao层
 * 
 * @author xuxiaojia
 */
@Repository
public interface ChannelSupplierDao {
	/**
	 * 删除数据源供应商信息
	 * 
	 * @param channelSupplierPO
	 */
	public void del(ChannelSupplierPO channelSupplierPO);
	/**
	 * 单独插入数据源供应商信息
	 * 
	 * @param channelSupplierPO
	 */
	public void singleInsert(ChannelSupplierPO channelSupplierPO);

	/**
	 * 更新数据源供应商信息
	 * 
	 * @param channelSupplierPO
	 *            待更新的通道信息
	 */
	public void update(@Param("channelSupplier") ChannelSupplierPO channelSupplierPO);

	/**
	 * 带分页的模糊查询
	 * 
	 * @param pager
	 *            分页信息对象
	 * @param channelSupplierPO
	 *            数据源供应商信息
	 * @return
	 */
	public List<ChannelSupplierPO> selectByPage(@Param("pager") Pager pager,
			@Param("channelSupplier") ChannelSupplierPO channelSupplierPO);
}
