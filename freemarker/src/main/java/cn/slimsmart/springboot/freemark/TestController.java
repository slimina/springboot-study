package cn.slimsmart.springboot.freemark;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zhutw on 2018/3/12.
 */
@Controller
public class TestController {

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String find(Model model, @PathVariable("id") Long id) {
        User user = new User();
        user.setId(id);
        user.setName("hello");
        model.addAttribute("user", user);
        return "user";
    }
}
