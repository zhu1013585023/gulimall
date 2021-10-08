package com.shangma.springCloud.service;

import com.shangma.springCloud.entities.CommonResult;
import com.shangma.springCloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "cloud-payment-service")
public interface PaymentFeignService {
    @GetMapping("/payment/{id}")
     CommonResult<Payment> createPayment(@PathVariable("id") Long id);
}
