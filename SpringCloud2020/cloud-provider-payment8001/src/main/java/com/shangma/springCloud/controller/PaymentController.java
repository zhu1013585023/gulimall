package com.shangma.springCloud.controller;

import com.shangma.springCloud.entities.CommonResult;
import com.shangma.springCloud.entities.Payment;
import com.shangma.springCloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String port;
    @Resource
    private DiscoveryClient discoveryClient;
    @PostMapping("/payment/create")
    public CommonResult createPayment(@RequestBody Payment payment){
        int result = paymentService.create(payment);
            log.info("***插入结果"+ result);
            if (result>0){
                return new CommonResult(200,"数据库插入成功"+port,result);
            }else {
                return new CommonResult(4000,"数据库插入失败"+port,null);
            }
    }
    @GetMapping("/payment/{id}")
    public CommonResult createPayment(@PathVariable Long id){
       Payment payment =  paymentService.findById(id);
        log.info("***查询结果"+ payment);
        if (!StringUtils.isEmpty(payment)){
            return new CommonResult(200,"数据库查询成功"+port,payment);
        }else {
            return new CommonResult(4000,"数据库查询失败"+port,null);
        }
    }
    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info(service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-ORDER-SERVER");
        for (ServiceInstance instance : instances) {
            log.info(instance.getHost()+"\t"+instance.getInstanceId()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return discoveryClient;
    }
}
