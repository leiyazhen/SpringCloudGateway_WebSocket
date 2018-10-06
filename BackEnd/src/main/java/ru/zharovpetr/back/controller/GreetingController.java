package ru.zharovpetr.back.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;
import ru.zharovpetr.back.message.Hello;
import ru.zharovpetr.back.message.HelloMessage;

/*
 * @author Zharov Petr
 */
@Controller
public class GreetingController {

    @MessageMapping("/hellowebsocket")
    @SendTo("/topic/helloworld")
    public Hello hello(HelloMessage message) {
        return new Hello("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
}