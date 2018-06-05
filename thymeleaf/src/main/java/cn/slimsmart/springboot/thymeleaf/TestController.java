package cn.slimsmart.springboot.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/** Created by zhutw on 2018/3/12. */
@Controller
public class TestController {

  @RequestMapping(value = "/users", method = RequestMethod.GET)
  public String find(ModelMap model) {
    List<User> list = new ArrayList<>();

    User user = new User();
    user.setId(1000L);
    user.setName("Tom");
    list.add(user);
    User user1 = new User();
    user1.setId(2000L);
    user1.setName("Lucy");
    list.add(user1);
    model.addAttribute("users", list);
    model.addAttribute("host", "http://www.baidu.com");
    return "user";
  }
}
