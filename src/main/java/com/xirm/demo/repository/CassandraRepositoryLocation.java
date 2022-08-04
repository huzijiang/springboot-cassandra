package com.xirm.demo.repository;

import com.xirm.demo.entity.Location;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.io.Serializable;
import java.util.List;


/**
 * @author huzj
 * @version 1.0
 * @date 2022/8/2 10:19
 */
public interface CassandraRepositoryLocation  extends CrudRepository<Location, Serializable> {

    /**
     *验证时间查询
     * @return Location
     */
    @Query("select  * from demo.location " +
            "where vehicle_id='1659531155246' and  date='2022-20-08' " +
            "and  time>'2022-08-03 12:52:35.244' and time<'2022-08-03 12:52:35.246' ")
    public List<Location> findByTime();


}
