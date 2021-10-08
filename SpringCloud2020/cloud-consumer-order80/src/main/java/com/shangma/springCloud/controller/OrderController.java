package com.shangma.springCloud.controller;


import com.shangma.springCloud.entities.CommonResult;
import com.shangma.springCloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {
    private static String PAYMENT_URI = "http://cloud-payment-service";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URI+"/payment/create",payment,CommonResult.class);
    }
    @GetMapping("/consumer/payment/{id}")
    public CommonResult<Payment> findById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URI+"/payment/"+id,CommonResult.class);
    }

}
