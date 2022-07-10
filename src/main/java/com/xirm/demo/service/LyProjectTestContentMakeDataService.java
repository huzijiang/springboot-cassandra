package com.xirm.demo.service;

/**
 * @author huzj
 * @version 1.0
 * @date 2022/6/14 15:56
 */
public interface LyProjectTestContentMakeDataService {

    /**
     * 开启持续制造数据
     * @return String 开启结果
     */
    public String  beginMakeData(Long deviceId);


    /**
     * 关闭持续制造数据
     * @return String 关闭结果
     */
    public String  endMakeData();
}
