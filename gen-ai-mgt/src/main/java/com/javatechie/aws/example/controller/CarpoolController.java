package com.javatechie.aws.example.controller;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javatechie.aws.example.model.Booking;
import com.javatechie.aws.example.model.Customer;
import com.javatechie.aws.example.model.Provider;
import com.javatechie.aws.example.model.Rider;
import com.javatechie.aws.example.model.Users;
import com.javatechie.aws.example.service.CarpoolMgtService;

import springfox.documentation.annotations.ApiIgnore;

@RestController
@ApiIgnore
@RequestMapping(value = "/carpool/v1/")
public class CarpoolController 
{
//https://www.baeldung.com/spring-boot-crud-thymeleaf
	Log LOGGER = LogFactory.getLog(CarpoolController.class);
	
	@Autowired
	CarpoolMgtService carpoolMgtSvc;
	
	@Autowired
	ObjectMapper mapper;
	
	
	@RequestMapping("/")
    public String home()
    {
    	System.out.println("----home mtd -3");
        //return "redirect:swagger-ui.html";
    	return "redirect:swagger-ui/index.html";
    }
	
	
	//#------------------------ provider  ------------------------------------	
	
	
	@GetMapping("/provider") 
	public ModelAndView addProvider(ModelAndView modelAndView)
    {
		Provider provider = new Provider();
		
		modelAndView.setViewName("rideProvider");
	    modelAndView.addObject(provider);
	    return modelAndView;
    }
    	
	@PostMapping("/provider")
    public ModelAndView addProvider(ModelAndView modelAndView, Provider provider) 
    {
    	LOGGER.info("---- captureProvider started ..");
    	   	
    	carpoolMgtSvc.captureProvider(provider);
    	
    	modelAndView.setViewName("rideProvider");
        modelAndView.addObject(provider);
        return modelAndView;
    }
	
	
	@GetMapping("/providers-all")
    public ModelAndView getProviders(ModelAndView modelAndView) 
    {
    	LOGGER.info("---- providers all started ..");    	
    	List<Provider> providers  =  carpoolMgtSvc.getProviders();
    	
    	Map modelMap = new HashMap();
    	modelMap.put("providers", providers);
    	
    	
    	modelAndView.setViewName("allRideProviders");
    	modelAndView.addAllObjects(modelMap);
        return modelAndView;    	
    }

	
	@GetMapping("/providers-all/{id}")
    public ModelAndView getProviders(ModelAndView modelAndView, @PathVariable("id") Integer riderNum) 
    {
    	LOGGER.info("---- providers all started with riderNum : "+ riderNum);    	
    	List<Provider> providers  =  carpoolMgtSvc.getProviders();
    	
    	Map modelMap = new HashMap();
    	modelMap.put("providers", providers);
    	
    	//riderNum
    	modelAndView.setViewName("allRideProviders");
    	modelAndView.addAllObjects(modelMap);
    	modelAndView.addObject("riderNum", riderNum);
    	
        return modelAndView;    	
    }
	
	
	//#------------------------ rider   ------------------------------------
	
	@GetMapping("/rider") 
	public ModelAndView addrider(ModelAndView modelAndView)
    {
		Rider rider = new Rider();
		
		modelAndView.setViewName("rideRequestor");
	    modelAndView.addObject(rider);
	    return modelAndView;
    }
	
	@PostMapping("/rider")
    public ModelAndView addRider(ModelAndView modelAndView, Rider rider) 
    {
    	LOGGER.info("---- captureRider started ..");
    	   	
    	carpoolMgtSvc.captureRider(rider);
    	
    	modelAndView.setViewName("rideRequestor");
        modelAndView.addObject(rider);
        return modelAndView;
    }
	
	@GetMapping("/riders-all")
    public ModelAndView getRiders(ModelAndView modelAndView) 
    {
    	LOGGER.info("---- riders all started ..");    	
    	List<Rider> riders  =  carpoolMgtSvc.getRiders();
    	
    	Map modelMap = new HashMap();
    	modelMap.put("riders", riders);
    	
    	
    	modelAndView.setViewName("allRideRequestors");
    	modelAndView.addAllObjects(modelMap);
        return modelAndView;
    }
	
	
	
    
	//#------------------------ booking ------------------------------------
	
	@GetMapping("/book-seat/{id}")
    //public ModelAndView bookSeat(ModelAndView modelAndView, Provider provider, @RequestParam("id") Integer providerNum) 
	//public ModelAndView bookSeat(ModelAndView modelAndView, Provider provider, @RequestAttribute("id") Integer providerNum)
	public ModelAndView bookSeat(ModelAndView modelAndView, Provider provider, @PathVariable("id") Integer providerNum)
    {
    	LOGGER.info("---- bookSeat started providerNum : " + providerNum);
    	
    	Booking booking = carpoolMgtSvc.bookSeat(providerNum);
    	
    	LOGGER.info("---- booking : " + booking);
        
        Map modelMap = new HashMap();
    	modelMap.put("booking", booking);
    	
    	modelAndView.setViewName("booking");
    	modelAndView.addAllObjects(modelMap);
        return modelAndView;        
    }
	
	@GetMapping("/book-seat/{id}/{riderId}")
	public ModelAndView bookSeat(ModelAndView modelAndView, Provider provider, @PathVariable("id") Integer providerNum, @PathVariable("riderId") Integer riderNum)
    {
    	LOGGER.info("---- bookSeat started with providerNum : " + providerNum + " and riderNum : " + riderNum);
    	
    	Booking booking = carpoolMgtSvc.bookSeat(providerNum, riderNum);
    	
    	LOGGER.info("---- booking : " + booking);
        
        Map modelMap = new HashMap();
    	modelMap.put("booking", booking);
    	
    	modelAndView.setViewName("booking");
    	modelAndView.addAllObjects(modelMap);
        return modelAndView;        
    }
	
}


