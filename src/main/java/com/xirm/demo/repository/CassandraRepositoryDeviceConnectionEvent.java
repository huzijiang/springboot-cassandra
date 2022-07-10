package com.xirm.demo.repository;

import com.xirm.demo.entity.Location;
import com.xirm.demo.entity.device.DeviceConnectionEvent;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

/**
 * @author huzj
 * @version 1.0
 * @date 2022/6/14 16:18
 */
public interface CassandraRepositoryDeviceConnectionEvent  extends CrudRepository<DeviceConnectionEvent, Serializable> {


}
