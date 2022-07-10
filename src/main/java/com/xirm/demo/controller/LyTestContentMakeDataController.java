package com.xirm.demo.controller;

import com.xirm.demo.entity.Address;
import com.xirm.demo.entity.Location;
import com.xirm.demo.service.LyProjectTestContentMakeDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author huzj
 * @version 1.0
 * @date 2022/6/14 16:56
 */
@RestController
@RequestMapping("/makeData")
public class LyTestContentMakeDataController {
    @Resource
    LyProjectTestContentMakeDataService lyProjectTestContentMakeDataService;

    @GetMapping("/begin/{deviceId}")
    public String insertLocationDetails(@PathVariable(name = "deviceId") String deviceId)
            throws InterruptedException {


        System.out.println("1");
        return lyProjectTestContentMakeDataService.beginMakeData(Long.parseLong(deviceId));
    }

}
