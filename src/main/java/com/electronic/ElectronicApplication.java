package com.electronic;

import com.electronic.properties.FileProperties;
import org.jodconverter.boot.autoconfigure.JodConverterLocalAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan(value = "com.electronic.dao")
@EnableTransactionManagement
@SpringBootApplication
@EnableConfigurationProperties({
        FileProperties.class
})
public class ElectronicApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElectronicApplication.class, args);
    }

}
