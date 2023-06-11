package com.javatechie.aws.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javatechie.aws.example.model.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}