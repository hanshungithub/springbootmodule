package cn.hassan.jwt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/5/1 17:57
 * Description:
 */
@Controller
@RequestMapping("/api")
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        return "success";
    }
}
