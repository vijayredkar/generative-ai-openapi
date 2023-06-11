package com.javatechie.aws.example;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banknext.txn.Entity;
import com.javatechie.aws.example.constants.Constants;
import com.javatechie.aws.example.model.Customer;
import com.javatechie.aws.example.repo.CustomerRepository;

@SpringBootApplication
@RestController
public class AwsElasticbeanstalkExampleApplication {
	
	Log LOGGER = LogFactory.getLog(AwsElasticbeanstalkExampleApplication.class);

    public static void main(String[] args) 
    {
        SpringApplication.run(AwsElasticbeanstalkExampleApplication.class, args);
    }
}
