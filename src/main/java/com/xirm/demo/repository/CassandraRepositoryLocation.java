package com.xirm.demo.repository;

import com.xirm.demo.entity.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @author huzj
 * @version 1.0
 * @date 2022/8/2 10:19
 */
@Repository
public interface CassandraRepositoryLocation {

    /**
     *
     * @param location
     */
    void save(Location location);

    /**
     *
     */
    void findAll();

    /**
     *
     * @param location
     */
    void delete(Location location);

    /**
     *
     * @param location
     */
    void update(Location location);

}
