package cn.slimsmart.springboot.applicationconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

  @Value("${jdbc_url:jdbc:mysql://localhost:3306/test}")
  private String jdbcUrl;

  @Value("${student.desc}")
  private String desc;

  @Autowired private StudentConfig studentConfig;

  @RequestMapping(value = "/jdbc", method = RequestMethod.GET)
  public String jdbc() {
    return jdbcUrl;
  }

  @RequestMapping(value = "/student", method = RequestMethod.GET)
  public String studentConfig() {
    return studentConfig.toString();
  }

  @RequestMapping(value = "/desc", method = RequestMethod.GET)
  public String desc() {
    return desc;
  }
}
