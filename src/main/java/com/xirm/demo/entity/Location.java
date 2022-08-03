package com.xirm.demo.entity;

import lombok.Data;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;

/**
 * @author huzj
 */
@Data
@Table("location")
public class Location {

	@PrimaryKeyColumn(name = "vehicle_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	@Column("vehicle_id")
	private String vehicleId;

	@PrimaryKeyColumn(name = "date", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	@Column("date")
	private String date;

	@Column("time")
	private Date time;

	@Column("latitude")
	private Double latitude;

	@Column("longitude")
	private Double longitude;

	@Column("address")
	private Address address;


}
