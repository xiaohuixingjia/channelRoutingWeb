package com.umpay.channel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.umpay.channel.bean.IpWhiteListPO;
import com.umpay.channel.bean.Pager;

/**
 * ip白名单表 dao层
 * 
 * @author limo
 */
@Repository
public interface IpWhiteListDao {
	/**
	 * 删除ip白名单表信息
	 * 
	 * @param ipWhiteListPo
	 */
	public void del(@Param("ipWhiteList")IpWhiteListPO ipWhiteListPO);
	/**
	 * 单独插入ip白名单表信息
	 * 
	 * @param ipWhiteListPo
	 */
	public void singleInsert(IpWhiteListPO ipWhiteListPO);

	/**
	 * 更新ip白名单表
	 * 
	 * @param ipWhiteListPo
	 *            待更新的数据源信息
	 */
	public void update(@Param("ipWhiteList") IpWhiteListPO ipWhiteListPO);

	/**
	 * 带分页的模糊查询
	 * 
	 * @param pager
	 *            分页信息对象
	 * @param ipWhiteListPo
	 *            ip白名单实体类
	 * @return
	 */
	public List<IpWhiteListPO> selectByPage(@Param("pager") Pager pager, @Param("ipWhiteList") IpWhiteListPO ipWhiteListPO);
}
