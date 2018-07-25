package com.umpay.channel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.umpay.channel.bean.ChannelRoutingPO;
import com.umpay.channel.bean.Pager;
@Repository
public interface ChannelRoutingDao {

	/**
	 * 删除通道路由信息
	 * 
	 * @param channelRoutingPO
	 */
	public void del(ChannelRoutingPO channelRoutingPO);
	/**
	 * 单独插入通道路由信息
	 * 
	 * @param channelRoutingPO
	 */
	public void singleInsert(ChannelRoutingPO channelRoutingPO);

	/**
	 * 更新通道信息
	 * 
	 * @param channelRoutingPO
	 *            待更新的通道信息
	 */
	public void update(@Param("channelRouting") ChannelRoutingPO channelRoutingPO,@Param("oldC")ChannelRoutingPO oldC);

	/**
	 * 带分页的模糊查询
	 * 
	 * @param pager
	 *            分页信息对象
	 * @param channelRoutingPO
	 *            通道信息
	 * @return
	 */
	public List<ChannelRoutingPO> selectByPage(@Param("pager") Pager pager, @Param("channelRouting") ChannelRoutingPO channelRoutingPO);
}
