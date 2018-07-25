package com.umpay.channel.service;

import com.umpay.channel.bean.IpWhiteListPO;
import com.umpay.channel.bean.Pager;

/**
 * ip白名单服务
 * 
 * @author limo
 */
public interface IpWhiteListService {
	/**
	 * 单个录入ip白名单信息
	 * 
	 * @param IpWhiteListPo
	 */
	public void insert(IpWhiteListPO IpWhiteListPo);

	/**
	 * 带分页的查询ip白名单表的信息
	 * 
	 * @param IpWhiteListPo
	 * @param pager
	 * @return
	 */
	public Pager selectByPage(IpWhiteListPO IpWhiteListPo, Pager pager);

	/**
	 * 更新信息
	 * 
	 * @param IpWhiteListPo
	 */
	public void update(IpWhiteListPO IpWhiteListPo);


	/**
	 * 添加信息
	 * 
	 * @param IpWhiteListPo
	 */
	public void add(IpWhiteListPO IpWhiteListPo);
	
	/**
	 * 删除信息
	 * 
	 * @param IpWhiteListPo
	 */
	public void del(IpWhiteListPO IpWhiteListPo);
	
}
