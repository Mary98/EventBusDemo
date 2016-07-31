package com.mary.eventbusdemo.bean;

import java.util.List;

/**
 * File Name:
 * Author:      Mary
 * Write Dates: 16/7/31
 * Description:
 * Change log:
 * 16/7/31-09-22---[公司]---[姓名]
 * ......Added|Changed|Delete......
 * --------------------------------
 */
public class AdsInfo {
    /** 响应码 */
    private int code;
    /** 请求状态 */
    private String description;
    /** 广告集合 */
    private List<Ads> ads;

    @Override
    public String toString() {
        return "AdsInfo [code=" + code + ", description=" + description + ", ads=" + ads + "]";
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Ads> getAds() {
        return ads;
    }

    public void setAds(List<Ads> ads) {
        this.ads = ads;
    }

    /**
     * 广告
     * @author Mary
     *
     */
    public class Ads {
        /** 广告图片地址 */
        private String pic;
        /** 网页地址 */
        private String url;

        @Override
        public String toString() {
            return "AdsInfo [pic=" + pic + ", url=" + url + "]";
        }
        public String getPic() {
            return pic;
        }
        public void setPic(String pic) {
            this.pic = pic;
        }
        public String getUrl() {
            return url;
        }
        public void setUrl(String url) {
            this.url = url;
        }
    }
}
