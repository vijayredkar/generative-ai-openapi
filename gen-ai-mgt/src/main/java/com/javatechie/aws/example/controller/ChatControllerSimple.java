package com.javatechie.aws.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.javatechie.aws.example.model.ChatRequest;
import com.javatechie.aws.example.model.ChatResponse;
import com.javatechie.aws.example.model.Message;
@RestController
@RequestMapping(value = "/openai/v1/")
public class ChatControllerSimple {

    @Qualifier("openaiRestTemplate")
    @Autowired
    private RestTemplate restTemplate;

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiUrl;

    /**
     * Creates a chat request and sends it to the OpenAI API
     * Returns the first message from the API response
     *
     * @param prompt the prompt to send to the API
     * @return first message from the API response
     */
    @GetMapping("/simple-conversational-chat")
    public String chat() {
    	
    	//---------------- 1st prompt
    	String prompt1 = "Ameesha Patel earns 2000 AED per month. Bakdu Patel earns 10000 AED per year. Tanutanu Patel earns 10 percent commission on per completed deal. She has completed 10 deals this year worth total of 100000 AED. They all have applied for a loan. The bank can provide 1 loan only and to the person who total earnings per year is the highest. Who will be selected for the loan?";
    	ChatRequest request = new ChatRequest(model, prompt1);
    	System.out.println("\n\n ---- Make 1st request : "+ request.toString());
    	
        ChatResponse response = restTemplate.postForObject(
                apiUrl,
                request,
                ChatResponse.class);
        if (response == null || response.getChoices() == null || response.getChoices().isEmpty()) {
            return "No response";
        }
        
        String responseText = response.getChoices().get(0).getMessage().getContent();
        System.out.println("\n\n Got 1st response : "+ responseText);
                

        return response.getChoices().get(0).getMessage().getContent();
    }
}