package com.xirm.demo.repository;

import com.xirm.demo.entity.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Optional;

/**
 * @author huzj
 */
@Repository
public interface CassandraRepository extends CrudRepository<Location, Serializable> {
	/**
	 *
	 * @param vehicleId
	 * @param date
	 * @return
	 */
	public Optional<Location> findByVehicleIdAndDate(String vehicleId, String date);

}
