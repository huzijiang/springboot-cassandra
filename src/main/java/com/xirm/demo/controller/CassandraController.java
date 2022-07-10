package com.xirm.demo.controller;

import com.xirm.demo.entity.Address;
import com.xirm.demo.entity.Location;
import com.xirm.demo.repository.CassandraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

/**
 * @author huzj
 */
@RestController
@RequestMapping("/location")
public class CassandraController {

    @Autowired
    private CassandraRepository repository;

    @GetMapping
    public ResponseEntity<?> getLocationDetails(@RequestParam("vehicle_id") String vehicleId,
                                                @RequestParam("date") String date) {

        Optional<Location> location = repository.findByVehicleIdAndDate(vehicleId, date);

        return location.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public void insertLocationDetails(@RequestBody Location location) {

        repository.save(location);
    }

    @GetMapping("/add")
    public String insertLocationDetails() throws InterruptedException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-HH-MM");

        Address address=new Address();
        address.setCity("北京");
        address.setPhone("13800138000");
        address.setStreet("北三环西路");
        address.setZip_code(110001);

        for (int i=0;i<10;i++){
            Location location=new Location();
            location.setVehicleId(System.currentTimeMillis()+"");
            location.setLongitude(110.000);
            location.setLatitude(119.000);
            location.setDate(simpleDateFormat.format(new Date()));
            location.setTime(new Date());
            location.setAddress(address);

            repository.save(location);
            Thread.sleep(200L);
        }
        return "success";
    }


}
