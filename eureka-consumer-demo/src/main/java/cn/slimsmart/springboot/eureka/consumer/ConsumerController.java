package cn.slimsmart.springboot.eureka.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

	 	@Autowired
	    RestTemplate restTemplate;
	 
	    @RequestMapping(value = "/add", method = RequestMethod.GET)
	    public String add() {
	    	//eurak-provider-demo 提供者服务名称
	        return restTemplate.getForEntity("http://eureka-provider-demo/add?a=10&b=20", String.class).getBody();
	    }
}
