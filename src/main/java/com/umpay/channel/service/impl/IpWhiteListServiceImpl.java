package com.umpay.channel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umpay.channel.bean.IpWhiteListPO;
import com.umpay.channel.bean.Pager;
import com.umpay.channel.dao.IpWhiteListDao;
import com.umpay.channel.service.IpWhiteListService;

/**   
*
* @author limo   
* @version 1.0 
* @date 2018年3月6日 下午3:31:30   
* @since
*
*/
@Service
public class IpWhiteListServiceImpl implements IpWhiteListService {
    
    @Autowired
    private IpWhiteListDao ipWhiteListDao;

    public void insert(IpWhiteListPO ipWhiteListPO) {
        ipWhiteListDao.singleInsert(ipWhiteListPO);
    }

    public Pager selectByPage(IpWhiteListPO ipWhiteListPO, Pager pager) {
        pager.setCells(ipWhiteListDao.selectByPage(pager, ipWhiteListPO));
        return pager;
    }

    public void update(IpWhiteListPO ipWhiteListPO) {
        ipWhiteListDao.update(ipWhiteListPO);
    }

    public void add(IpWhiteListPO ipWhiteListPO) {
        ipWhiteListDao.singleInsert(ipWhiteListPO);
    }

    public void del(IpWhiteListPO ipWhiteListPO) {
        ipWhiteListDao.del(ipWhiteListPO);
    }

}


