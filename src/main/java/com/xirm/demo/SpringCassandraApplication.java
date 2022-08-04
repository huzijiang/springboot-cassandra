package com.xirm.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author huzj
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class SpringCassandraApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringCassandraApplication.class, args);
    }

}
