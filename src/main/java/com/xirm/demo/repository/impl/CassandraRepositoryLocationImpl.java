package com.xirm.demo.repository.impl;

import com.xirm.demo.entity.Location;
import com.xirm.demo.repository.CassandraRepositoryLocation;
import org.springframework.data.cassandra.core.CassandraTemplate;

import javax.annotation.Resource;

/**
 * @author huzj
 * @version 1.0
 * @date 2022/8/2 11:37
 */
public class CassandraRepositoryLocationImpl  implements CassandraRepositoryLocation {

    @Resource
    private CassandraTemplate cassandraTemplate;


    @Override
    public void save(Location location) {
        cassandraTemplate.insert(location);
    }

    @Override
    public void findAll() {
//        cassandraTemplate.select()
    }

    @Override
    public void delete(Location location) {

    }

    @Override
    public void update(Location location) {

    }
}
