package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller

public class ImsiController {

    @GetMapping("imsi")
    public String imsi(Model model){
        return "imsi";
    }

}
