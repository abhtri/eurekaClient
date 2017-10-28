package com.microservice1.una;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class service1 {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/service1")
    public String microservice1(){
        return "service1";
    }

    @RequestMapping("/eureka/{applicationName}")
    public List<ServiceInstance> eureka(@PathVariable String applicationName){
      return   this.discoveryClient.getInstances(applicationName);
    }
}
