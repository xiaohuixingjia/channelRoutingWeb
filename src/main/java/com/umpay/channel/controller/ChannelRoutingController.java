package com.umpay.channel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.umpay.channel.bean.ChannelRoutingPO;
import com.umpay.channel.bean.ChannelSupplierPO;
import com.umpay.channel.bean.DataSourcePO;
import com.umpay.channel.bean.Pager;
import com.umpay.channel.bean.RespBean;
import com.umpay.channel.constant.Retcode;
import com.umpay.channel.exception.BaseException;
import com.umpay.channel.service.ChannelRoutingService;
import com.umpay.channel.util.RespUtil;

/**
 * 通道路由 业务controller
 * 
 * @author xuxiaojia 2017年6月6日
 */
@RequestMapping("/channelRouting")
@Controller
public class ChannelRoutingController {
	private static final String FIND_ALL_TYPE="-9999";
	@Autowired
	private ChannelRoutingService channelRoutingService;

	@ResponseBody
	@RequestMapping("/editDS")
	public RespBean editDS(DataSourcePO dSource,String oper) throws Exception {
		//		if (br.hasErrors()) {
//			List<ObjectError> allErrors = br.getAllErrors();
//			StringBuilder bu = new StringBuilder();
//			for (ObjectError objectError : allErrors) {
//				bu.append(objectError.getDefaultMessage()).append(Constant.SEMICOLON);
//			}
//			throw new BaseException(Retcode.VALIDATE_ERR, bu.toString());
//		}
		if(oper.equals("edit")){
			channelRoutingService.update(dSource);
		}else if(oper.equals("add")){
			channelRoutingService.add(dSource);
		}else if(oper.equals("del")){
			channelRoutingService.del(dSource);
		}
		return RespUtil.buildSuccess(true);
	}
	@ResponseBody
	@RequestMapping("/editCR")
	public RespBean editCR(ChannelRoutingPO channelRoutingPO,String id,String oper) throws Exception {
		//		if (br.hasErrors()) {
//			List<ObjectError> allErrors = br.getAllErrors();
//			StringBuilder bu = new StringBuilder();
//			for (ObjectError objectError : allErrors) {
//				bu.append(objectError.getDefaultMessage()).append(Constant.SEMICOLON);
//			}
//			throw new BaseException(Retcode.VALIDATE_ERR, bu.toString());
//		}
		if(oper.equals("edit")){
			ChannelRoutingPO oldC=new ChannelRoutingPO();
			if(id!=null){
				splitId2CR(oldC, id);
			}else{
				throw new BaseException(Retcode.VALIDATE_ERR,"没有id无法更新");
			}
			channelRoutingService.update(channelRoutingPO,oldC);
		}else if(oper.equals("add")){
			channelRoutingService.add(channelRoutingPO);
		}else if(oper.equals("del")){
			if(id!=null){
				splitId2CR(channelRoutingPO, id);
			}
			channelRoutingService.del(channelRoutingPO);
		}
		return RespUtil.buildSuccess(true);
	}
	private void splitId2CR(ChannelRoutingPO channelRoutingPO, String id) {
		String[] split = id.split("\\_\\$\\_");
		channelRoutingPO.setProductSuitesCode(split[0]);
		channelRoutingPO.setMerCode(split[1]);
		channelRoutingPO.setOperatorType(Integer.parseInt(split[2].trim()));
		channelRoutingPO.setDsId(split[3]);
	}
	
	
	@ResponseBody
	@RequestMapping("/editCS")
	public RespBean editCS(ChannelSupplierPO channelSupplierPO,String oper) throws Exception {
		//		if (br.hasErrors()) {
//			List<ObjectError> allErrors = br.getAllErrors();
//			StringBuilder bu = new StringBuilder();
//			for (ObjectError objectError : allErrors) {
//				bu.append(objectError.getDefaultMessage()).append(Constant.SEMICOLON);
//			}
//			throw new BaseException(Retcode.VALIDATE_ERR, bu.toString());
//		}
		if(oper.equals("edit")){
			channelRoutingService.update(channelSupplierPO);
		}else if(oper.equals("add")){
			channelRoutingService.add(channelSupplierPO);
		}else if(oper.equals("del")){
			channelRoutingService.del(channelSupplierPO);
		}
		return RespUtil.buildSuccess(true);
	}
	@ResponseBody
	@RequestMapping("/selectChannelSupplier")
	public RespBean selectChannelSupplier(ChannelSupplierPO channelSupplierPO,Pager pager) throws Exception {
		return RespUtil.buildSuccess(channelRoutingService.selectByPage(channelSupplierPO,pager));
	}
	@ResponseBody
	@RequestMapping("/selectDataSource")
	public RespBean selectDataSource(DataSourcePO dataSourcePO, Pager pager) throws Exception {
		if(FIND_ALL_TYPE.equals(""+dataSourcePO.getCacheState())){
			dataSourcePO.setCacheState(null);
		}
		if(FIND_ALL_TYPE.equals(""+dataSourcePO.getState())){
			dataSourcePO.setState(null);
		}
		if(FIND_ALL_TYPE.equals(""+dataSourcePO.getHbaseState())){
			dataSourcePO.setHbaseState(null);
		}
		return RespUtil.buildSuccess(channelRoutingService.selectByPage(dataSourcePO,pager));
	}
	@ResponseBody
	@RequestMapping("/selectChannelRouting")
	public RespBean selectChannelRouting(ChannelRoutingPO channelRoutingPO,Pager pager) throws Exception {
		if(FIND_ALL_TYPE.equals(""+channelRoutingPO.getOperatorType())){
			channelRoutingPO.setOperatorType(null);
		}
		if(FIND_ALL_TYPE.equals(""+channelRoutingPO.getUseNext())){
			channelRoutingPO.setUseNext(null);
		}
		return RespUtil.buildSuccess(channelRoutingService.selectByPage(channelRoutingPO, pager));
	}
}
