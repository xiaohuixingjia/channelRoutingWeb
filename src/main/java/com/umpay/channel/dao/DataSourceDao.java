package com.umpay.channel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.umpay.channel.bean.DataSourcePO;
import com.umpay.channel.bean.Pager;

/**
 * 数据源表 dao层
 * 
 * @author xuxiaojia
 */
@Repository
public interface DataSourceDao {
	/**
	 * 删除数据源表信息
	 * 
	 * @param dataSourcePO
	 */
	public void del(DataSourcePO dataSourcePO);
	/**
	 * 单独插入数据源表信息
	 * 
	 * @param dataSourcePO
	 */
	public void singleInsert(DataSourcePO dataSourcePO);

	/**
	 * 更新数据源表
	 * 
	 * @param dataSourcePO
	 *            待更新的数据源信息
	 */
	public void update(@Param("dataSource") DataSourcePO dataSourcePO);

	/**
	 * 带分页的模糊查询
	 * 
	 * @param pager
	 *            分页信息对象
	 * @param dataSourcePO
	 *            数据源信息
	 * @return
	 */
	public List<DataSourcePO> selectByPage(@Param("pager") Pager pager, @Param("dataSource") DataSourcePO dataSourcePO);
}
