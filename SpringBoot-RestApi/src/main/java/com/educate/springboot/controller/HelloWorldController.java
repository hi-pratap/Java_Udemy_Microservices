package com.educate.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*@Controller
@ResponseBody */
@RestController // this repalces above Two becoz its is a combination of above two
public class HelloWorldController {


    @GetMapping("/hello")
    public String helloWorld() {

        return "Hello World!";
    }
}
