package com.javatechie.aws.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import springfox.documentation.annotations.ApiIgnore;


@Controller
@ApiIgnore
public class HomeController
{

    @RequestMapping("/")
    public String home()
    {
    	System.out.println("----home mtd -1");
        //return "redirect:swagger-ui.html";
    	return "redirect:swagger-ui/index.html";
        
        //http://localhost:8080/swagger-ui/ - didn't work
        //http://localhost:8080/swagger-ui/index.html - worked fine
    }
    
	/*
	 * @RequestMapping("/carpool/v1/") public String api() {
	 * System.out.println("----api mtd"); return "redirect:swagger-ui.html"; }
	 * 
	 */
    

    @RequestMapping("/kyc1")
    public String test()
    {
    	System.out.println("----test mtd -2");
        return "redirect:swagger-ui.html";
    }
}


