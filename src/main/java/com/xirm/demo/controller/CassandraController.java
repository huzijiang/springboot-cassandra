package com.xirm.demo.controller;

import com.xirm.demo.entity.Address;
import com.xirm.demo.entity.Location;
import com.xirm.demo.repository.CassandraRepositoryLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author huzj
 */
@RestController
@RequestMapping("/location")
public class CassandraController {

    @Autowired
    private CassandraRepositoryLocation cassandraRepositoryLocation;

    @GetMapping("/add")
    public String insertLocationDetails()  {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-HH-MM");

        Address address=new Address();
        address.setCity("北京");
        address.setPhone("13800138000");
        address.setStreet("北三环西路");
        address.setZip_code(110001);

        Date date=new Date();

        Location location=new Location();

        location.setVehicleId(System.currentTimeMillis()+"");
        location.setLongitude(110.000);
        location.setLatitude(119.000);

        location.setDate(simpleDateFormat.format(date));
        location.setTime(date);

        location.setAddress(address);

        cassandraRepositoryLocation.save(location);

        return "success";
    }


    @GetMapping("/find")
    public String findLocations()  {
        List<Location> locationList=cassandraRepositoryLocation.findByTime();
        System.out.println(locationList.size());
        return "success";
    }

}
