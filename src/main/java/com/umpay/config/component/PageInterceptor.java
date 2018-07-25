package com.umpay.config.component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.log4j.Logger;

import com.umpay.channel.bean.Pager;

/**
 * 分页拦截器
 * @author xuxiaojia
 * 2017年6月6日
 */
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class PageInterceptor implements Interceptor {
	private static final Logger log = Logger.getLogger(PageInterceptor.class);
	/** 匹配拦截的分页正则 */
	private String matchesRegular;

	/** 是否打印sql */
	private boolean outputSQLFlag;

	public Object intercept(Invocation invocation) throws Throwable {
		System.out.println("pageInteerception实例:"+this);
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		MetaObject metaObject = MetaObject.forObject(statementHandler, SystemMetaObject.DEFAULT_OBJECT_FACTORY,
				SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY);
		MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
		// 配置文件中SQL语句的ID
		String id = mappedStatement.getId();
		if (id.matches(matchesRegular)) {
			BoundSql boundSql = statementHandler.getBoundSql();
			// 原始的SQL语句
			String sql = boundSql.getSql();
			// 查询总条数的SQL语句
			String countSql = "select count(*) from (" + sql + ") byPage ";
			Connection connection = (Connection) invocation.getArgs()[0];
			PreparedStatement countStatement = connection.prepareStatement(countSql);
			ParameterHandler parameterHandler = (ParameterHandler) metaObject.getValue("delegate.parameterHandler");
			parameterHandler.setParameters(countStatement);
			ResultSet rs = countStatement.executeQuery();

			Map<?, ?> parameter = (Map<?, ?>) boundSql.getParameterObject();
			Pager page = (Pager) parameter.get("pager");
			if (rs.next()) {
				page.setTotal((rs.getInt(1)));
				count(page);
			}
			// 改造后带分页查询的SQL语句
			String pageSql = " select * from ( "
					+ "select first_page.*,ROW_NUMBER() OVER() AS ROWNO from ( "
								+sql +" ) first_page ) second_page where second_page.ROWNO>"+getStartNum(page) +" and second_page.ROWNO <="+getEndNum(page) ;
			metaObject.setValue("delegate.boundSql.sql", pageSql);
			
			if(outputSQLFlag){
				log.info("分页sql：sql方法ID---》 "+id);
				log.info("分页sql：未分页前的原始sql---》 "+sql);
				log.info("分页sql：求总和的sql---》 "+countSql);
				log.info("分页sql：加分页的sql---》 "+pageSql);
				log.info("分页sql：参数----》 "+parameter.toString());
				System.out.println("分页sql：sql方法ID---》 "+id);
				System.out.println("分页sql：未分页前的原始sql---》 "+sql);
				System.out.println("分页sql：求总和的sql---》 "+countSql);
				System.out.println("分页sql：加分页的sql---》 "+pageSql);
				System.out.println("分页sql：参数----》 "+parameter.toString());
			}
		}else{
			if(outputSQLFlag){
				BoundSql boundSql = statementHandler.getBoundSql();
				// 原始的SQL语句
				String sql = boundSql.getSql();
				Object parameter =  boundSql.getParameterObject();
				log.info("sql：sql方法ID---》 "+id);
				log.info("sql：sql---》 "+sql);
				if (parameter!=null) {
					log.info("sql：参数----》 " + parameter.toString());
				}
			}
		}
		Object proceed = invocation.proceed();
		return proceed;
	}

	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {
		this.matchesRegular = properties.getProperty("matchesRegular");
		if (StringUtils.isEmpty(matchesRegular)) {
			// 默认拦截以ByPage结尾的方法
			matchesRegular = ".+ByPage$";
		}
		this.outputSQLFlag = "true".equals(properties.getProperty("outputSQLFlag"));
	}
	
	/**
	 * 计算pager的信息
	 * @param pager
	 */
	private void count(Pager pager) {
		// 计算总页数
		int totalPageTemp = pager.getTotal()/pager.getRows();
		int plus = (pager.getTotal() % pager.getRows()) == 0 ? 0 : 1;
		totalPageTemp = totalPageTemp + plus;
		if(totalPageTemp <= 0) {
			totalPageTemp = 1;
		}
		pager.setTotalPage(totalPageTemp);
		// 设置当前页数
		// 总页数小于当前页数，应将当前页数设置为总页数
		if(pager.getTotalPage() < pager.getPage()) {
			pager.setPage(pager.getTotalPage());
		}
		// 当前页数小于1设置为1
		if(pager.getPage() < 1) {
			pager.setPage(1);
		}
		
	}
	
	/**
	 * 获取起始num
	 * @param pager
	 * @return
	 */
	public int getStartNum(Pager pager){
		return (pager.getPage()-1)*pager.getRows();
	}
	/**
	 * 获取终止num
	 * @param pager
	 * @return
	 */
	public int getEndNum(Pager pager){
		return (pager.getPage())*pager.getRows();
	}
}
