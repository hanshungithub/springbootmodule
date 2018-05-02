package cn.hassan.websocket.controller;

import cn.hassan.websocket.entity.WiselyMessage;
import cn.hassan.websocket.entity.WiselyResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/5/1 19:46
 * Description:
 */
@Controller
public class WsControllerr {


    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public WiselyResponse say(WiselyMessage message) {

        try {
            Thread.sleep(3000);
            return new WiselyResponse("welcome to use websocket" + message.getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
