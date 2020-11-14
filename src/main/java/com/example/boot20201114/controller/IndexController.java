package com.example.boot20201114.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    @RequestMapping(value ="/")
    public String index() {
        return "index.html";
    }
}
