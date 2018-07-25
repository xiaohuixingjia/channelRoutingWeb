package com.umpay.channel.bean;

/**
 *
 *
 *
 * @author limo
 * @version 1.0
 * @date 2018年3月6日 下午3:12:09
 * @since
 *
 */
public class IpWhiteListPO {
    /* 与ip相同 数据库中无此字段，用于前端jq组件*/
    private String id;
    private String ip;
    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
