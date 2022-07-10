package com.xirm.demo.service.impl;

import com.xirm.demo.constant.DeviceConnectionStatus;
import com.xirm.demo.entity.device.DeviceConnectionEvent;
import com.xirm.demo.entity.device.DeviceDataPoint;
import com.xirm.demo.entity.device.DeviceLongArrayTemp;
import com.xirm.demo.repository.CassandraRepository;
import com.xirm.demo.repository.CassandraRepositoryDeviceConnectionEvent;
import com.xirm.demo.repository.CassandraRepositoryDeviceDataPoint;
import com.xirm.demo.repository.CassandraRepositoryDeviceLongArrayTemp;
import com.xirm.demo.service.LyProjectTestContentMakeDataService;
import org.springframework.stereotype.Service;

import static org.mockito.Mockito.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Random;


/**
 * @author huzj
 * @version 1.0
 * @date 2022/6/14 15:59
 */
@Service
public class LyProjectTestContentMakeDataServiceImpl implements LyProjectTestContentMakeDataService {

    @Resource
    private CassandraRepository repository;

    @Resource
    private CassandraRepositoryDeviceConnectionEvent repositoryDeviceConnectionEvent;

    @Resource
    private CassandraRepositoryDeviceDataPoint repositoryDeviceDataPoint;

    @Resource
    private CassandraRepositoryDeviceLongArrayTemp repositoryDeviceLongArrayTemp;

    /**
     * 钩子
     */
    volatile static boolean continueFlag = true;

    /**
     * 开启持续制造数据
     *
     * @return String 开启结果
     */
    @Override
    public String beginMakeData(Long deviceId) {

        while (continueFlag){
            DeviceConnectionEvent deviceConnectionEvent = mockDataDeviceConnectionEvent(deviceId);
            DeviceDataPoint deviceDataPoint = mockDataDeviceDataPoint(deviceId);
            DeviceLongArrayTemp deviceLongArrayTemp = mockDataDeviceLongArrayTemp(deviceId);

//            repositoryDeviceConnectionEvent.save(deviceConnectionEvent);
            repositoryDeviceDataPoint.save(deviceDataPoint);
            // ?? 为什么没数据
//            repositoryDeviceLongArrayTemp.save(deviceLongArrayTemp);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "success";
    }
    private DeviceConnectionEvent mockDataDeviceConnectionEvent(Long deviceId) {
        DeviceConnectionEvent deviceConnectionEvent = new DeviceConnectionEvent();
        deviceConnectionEvent.setDeviceId(deviceId);
        deviceConnectionEvent.setCreatedAt(new Date());
        deviceConnectionEvent.setReason("where what who why ...");
        deviceConnectionEvent.setStatus(System.currentTimeMillis()%9==0?DeviceConnectionStatus.OFFLINE.getValue():DeviceConnectionStatus.ONLINE.getValue());

        return deviceConnectionEvent;
    }
    private DeviceDataPoint mockDataDeviceDataPoint(Long deviceId) {
        Random random=new Random();
        DeviceDataPoint dataDeviceDataPoint = new DeviceDataPoint();
        dataDeviceDataPoint.setDeviceId(deviceId);
        dataDeviceDataPoint.setIdentifier("RotatingVelocity");
        dataDeviceDataPoint.setCreatedAt(new Date());
//        dataDeviceDataPoint.setActionParameters("action parameters...");
//        dataDeviceDataPoint.setDesiredAt();
//        dataDeviceDataPoint.setDesiredValue("desire value...");
        dataDeviceDataPoint.setDirection("FROM_DEVICE");
//        dataDeviceDataPoint.setLevel();
        dataDeviceDataPoint.setMetadata("{\"unit\":\"rpm\",\"oldRvValue\":5.46,\"hasOriginalData\":false}");
        dataDeviceDataPoint.setReportedAt(new Date());
        dataDeviceDataPoint.setReportedValue(random.nextInt(1000)+"");
//        dataDeviceDataPoint.setReported_value_array();
//        dataDeviceDataPoint.setResult("result ...");

        return dataDeviceDataPoint;
    }
    private DeviceLongArrayTemp mockDataDeviceLongArrayTemp(Long deviceId) {
        DeviceLongArrayTemp dataDeviceLongArrayTemp = new DeviceLongArrayTemp();
        dataDeviceLongArrayTemp.setDeviceId(deviceId);
        dataDeviceLongArrayTemp.setIdentifier("RotatingVelocity");
        dataDeviceLongArrayTemp.setDataIndex(99);
//        dataDeviceLongArrayTemp.setReportedValueArray(null);

        return dataDeviceLongArrayTemp;
    }



    /**
     * 关闭持续制造数据
     *
     * @return String 关闭结果
     */
    @Override
    public String endMakeData() {


        return "success";
    }
}
