package cn.slimsmart.springboot.eureka.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

  @Autowired DemoClient demoClient;

  @RequestMapping(value = "/add", method = RequestMethod.GET)
  public Integer add() {
    return demoClient.add(40, 50);
  }
}
