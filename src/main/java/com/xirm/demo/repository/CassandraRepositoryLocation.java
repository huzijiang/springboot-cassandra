package com.xirm.demo.repository;

import com.xirm.demo.entity.Location;
import org.springframework.data.repository.CrudRepository;
import java.io.Serializable;



/**
 * @author huzj
 * @version 1.0
 * @date 2022/8/2 10:19
 */
public interface CassandraRepositoryLocation  extends CrudRepository<Location, Serializable> {

}
