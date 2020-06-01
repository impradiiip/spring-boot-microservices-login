package com.tom.mobileapp.transactionservice.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "api-gateway-zull")
@RibbonClient(name = "security-auth-server")
public interface SecurityServiceProxy {
	
	 @PostMapping("/security-auth-server/current")
	 ResponseEntity<String> authorizeSecurity(@RequestHeader(value = "Authorization", required = true) String authorizationHeader);
	

}
