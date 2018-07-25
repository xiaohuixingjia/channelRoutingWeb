package com.umpay.channel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.umpay.channel.bean.ModelPO;
import com.umpay.channel.bean.Pager;

/**
 * 模型配置 dao层
 * 
 * @author limo
 */
@Repository
public interface ModelDao {
	/**
	 * 删除模型配置信息
	 * @param modelConfigPO
	 */
	public void del(@Param("modelPO")ModelPO modelPO);
	/**
	 * 单独插入模型配置表的信息
	 * @param modelConfigPO
	 */
	public void singleInsert(ModelPO modelPO);
	/**
	 * 更新模型配置表的信息
	 * @param modelConfigPO
	 */
	public void update(@Param("modelPO")ModelPO modelPO);
	
	/**
	 * 带分页的模糊查询
	 * 
	 * @param pager
	 *            分页信息对象
	 * @param modelConfigPO
	 *            模型配置信息
	 * @return
	 */
	public List<ModelPO> selectByPage(@Param("pager") Pager pager, @Param("modelPO") ModelPO modelPO);

}
