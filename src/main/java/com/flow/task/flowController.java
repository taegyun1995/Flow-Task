package com.flow.task;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class flowController {

    @GetMapping("/flow")
    public String signup() {
        return "index";
    }

}