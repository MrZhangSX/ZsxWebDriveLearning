package zsx.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Log4j2
@Controller
public class HelloWorld {

    @RequestMapping("/hello")
    public @ResponseBody  String hello()
    {
        return "Hello Spring";
    }



}
