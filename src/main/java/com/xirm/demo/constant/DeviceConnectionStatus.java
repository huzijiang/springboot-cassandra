package com.xirm.demo.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author huzj
 * @version 1.0
 * @date 2022/6/14 15:43
 */
@Getter
@AllArgsConstructor
public enum DeviceConnectionStatus {

    OFFLINE("OFFLINE","已离线"),
    ONLINE("ONLINE","在线");

    private String value;

    private String desc;

}
