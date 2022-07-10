package com.xirm.demo.repository;

import com.xirm.demo.entity.device.DeviceDataPoint;
import com.xirm.demo.entity.device.DeviceLongArrayTemp;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

/**
 * @author huzj
 * @version 1.0
 * @date 2022/6/14 16:22
 */
public interface CassandraRepositoryDeviceLongArrayTemp  extends CrudRepository<DeviceLongArrayTemp, Serializable> {



}
