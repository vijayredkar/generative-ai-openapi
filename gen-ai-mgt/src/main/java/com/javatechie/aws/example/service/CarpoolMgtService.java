package com.javatechie.aws.example.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.banknext.txn.Entity;
import com.javatechie.aws.example.constants.Constants;
import com.javatechie.aws.example.model.Booking;
import com.javatechie.aws.example.model.Customer;
import com.javatechie.aws.example.model.Provider;
import com.javatechie.aws.example.model.Rider;
import com.javatechie.aws.example.repo.BookingRepository;
import com.javatechie.aws.example.repo.CustomerRepository;
import com.javatechie.aws.example.repo.ProviderRepository;
import com.javatechie.aws.example.repo.RiderRepository;


@Service
public class CarpoolMgtService { 
	
	Log LOGGER = LogFactory.getLog(CarpoolMgtService.class);

	@Autowired
	CustomerRepository custRepo;
	
	@Autowired
	BookingRepository bookRepo;
	
	@Autowired
	ProviderRepository providerRepo;
	
	@Autowired
	RiderRepository riderRepo;
	
	/*
	@Value("${credit-check-report-uri}")
	String creditCheckReportUri;
	*/
	
	
	public String captureProvider(Provider provider) 
    {
    	LOGGER.info("---- captureProvider started ..");
    	saveProvider(provider);
        return "capture provider ..";
    }
	
	
	public void saveProvider(Provider provider) 
	{
		provider.setProviderNum(constructUniqueId());
		
		providerRepo.save(provider);
		LOGGER.info("---- provider saved : " +  provider);
    }

	public List<Provider> getProviders() 
    {
    	LOGGER.info("---- providers started ..");    	
    	
    	List<Provider> providers = providerRepo.findAll();
    	
    	providers.forEach(p -> LOGGER.info(p));
    	
        return providers;
    }
    
    public Booking bookSeat(Integer providerNum) 
    {
    	LOGGER.info("---- bookSeat started ..");
    	
    	Booking booking = constructBooking(providerNum);
    	bookRepo.save(booking);
    	
        return booking;
    }
        
    public Booking bookSeat(Integer providerNum, Integer riderNum) 
    {
    	LOGGER.info("---- bookSeat started ..");
    	
    	Booking booking = constructBooking(providerNum, riderNum);
    	bookRepo.save(booking);
    	
        return booking;
    }

	public Booking constructBooking(Integer providerNum) 
	{
		
		Provider provider = providerRepo.findById(providerNum).get();
		
    	Booking booking = new Booking();
    	
    	booking.setBookingNum(constructUniqueId());
    	booking.setLocation(provider.getLocation());
    	booking.setProvider(provider.getName());
    	booking.setRider("--");
    	booking.setStatus("Confirmed");
    	
    	return booking;
    }
	
	public Booking constructBooking(Integer providerNum, Integer riderNum) 
	{
		
		Provider provider = providerRepo.findById(providerNum).get();
		Rider    rider =    riderRepo.findById(riderNum).get();
		
		
    	Booking booking = new Booking();
    	
    	booking.setBookingNum(constructUniqueId());
    	booking.setLocation(provider.getLocation());
    	booking.setProvider(provider.getName());
    	booking.setRider(rider.getName());
    	booking.setStatus("Confirmed");
    	
    	rider.setStatus("Confirmed");
    	provider.setTxnRemarks("Confirmed");    	
    	
    	return booking;
    }
    
    
    
    private Customer constructCustomer(Entity entity) 
    {
		
		Customer customer = new Customer();
		
		customer.setCustomerNum(constructUniqueId());
		customer.setCitizenship("USA");
		customer.setEmail("abc@xyz");
		customer.setFirstName("John");
		customer.setLastName("Soldaro");
		customer.setOccupation("Architect");		
		
		Timestamp now = Timestamp.from(Instant.now());
				
		return customer;
	}
    
    private Integer constructUniqueId() 
    {
		Random r = new Random(); 
		  return r.ints(Constants.minIndex, (Constants.maxIndex))
				  .findFirst()
				  .getAsInt();
	}

	
	public String captureRider(Rider rider) 
    {
    	LOGGER.info("---- captureRider started ..");
    	saveRider(rider);
        return "capture rider ..";
    }
	
	public void saveRider(Rider rider) 
	{
		rider.setRiderNum(constructUniqueId());		
		rider.setStatus("Requested");
		
		riderRepo.save(rider);
		LOGGER.info("---- rider saved : " +  rider);
    }

	public List<Rider> getRiders() 
    {
    	LOGGER.info("---- get riders started ..");    	
    	
    	List<Rider> riders = riderRepo.findAll();
    	
    	riders.forEach(p -> LOGGER.info(p));
    	
        return riders;
    }

}
