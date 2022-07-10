package com.xirm.demo.entity;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;



/**
 * @author huzj
 */
@UserDefinedType("address")
@Data
public class Address {

    @Column("street")
    private String street;

    @Column("city")
    private String city;

    @Column("zip_code")
    private int zip_code;

    @Column("phone")
    private String phone;



}
