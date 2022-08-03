package com.xirm.demo.repository.impl;

import com.xirm.demo.entity.Location;
import com.xirm.demo.repository.CassandraRepositoryLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author huzj
 * @version 1.0
 * @date 2022/8/2 11:37
 */
@Service
public class CassandraRepositoryLocationImpl  implements CassandraRepositoryLocation {

    @Autowired
    private CassandraTemplate cassandraTemplate;


    @Override
    public void save(Location location) {
        cassandraTemplate.insert(location);
    }

    @Override
    public void findAll() {

    }

    @Override
    public void delete(Location location) {

    }

    @Override
    public void update(Location location) {

    }
}
