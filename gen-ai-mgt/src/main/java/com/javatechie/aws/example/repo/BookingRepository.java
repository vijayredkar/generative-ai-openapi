package com.javatechie.aws.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javatechie.aws.example.model.Booking;
import com.javatechie.aws.example.model.Customer;
import com.javatechie.aws.example.model.Provider;


@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

}