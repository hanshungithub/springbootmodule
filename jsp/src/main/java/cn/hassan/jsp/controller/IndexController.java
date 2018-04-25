package cn.hassan.jsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/4/25 21:11
 * Description:
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
