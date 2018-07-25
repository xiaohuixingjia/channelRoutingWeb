package com.umpay.channel.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.umpay.channel.bean.IpWhiteListPO;
import com.umpay.channel.bean.Pager;
import com.umpay.channel.bean.RespBean;
import com.umpay.channel.service.IpWhiteListService;
import com.umpay.channel.util.RespUtil;

/**
 * 通道路由 业务controller
 * 
 * @author xuxiaojia 2017年6月6日
 */
@RequestMapping("/ipWhiteList")
@Controller
public class IpWhiteListController {
	@Autowired
	private IpWhiteListService ipWhiteListService;

	@ResponseBody
	@RequestMapping("/editIpWhiteList")
	public RespBean editCR(IpWhiteListPO ipWhiteListPO,String id,String oper) throws Exception {
        if(oper.equals("edit")){
            ipWhiteListService.update(ipWhiteListPO);
        }else if(oper.equals("add")){
            ipWhiteListService.add(ipWhiteListPO);
        }else if(oper.equals("del")){
            if(StringUtils.isNotEmpty(id)){
                ipWhiteListPO.setIp(id);
            }
            ipWhiteListService.del(ipWhiteListPO);
        }
        return RespUtil.buildSuccess(true);
	}
//	private void splitId2CR(ChannelRoutingPO channelRoutingPO, String id) {
//		String[] split = id.split("\\_\\$\\_");
//		channelRoutingPO.setProductSuitesCode(split[0]);
//		channelRoutingPO.setMerCode(split[1]);
//		channelRoutingPO.setOperatorType(Integer.parseInt(split[2].trim()));
//		channelRoutingPO.setDsId(split[3]);
//	}
	
	
	@ResponseBody
	@RequestMapping("/selectIpWhiteList")
	public RespBean selectChannelSupplier(IpWhiteListPO po,Pager pager) throws Exception {
		return RespUtil.buildSuccess(ipWhiteListService.selectByPage(po, pager));
	}
}
