package com.example.bootdevtool;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("test")
    public String getSum() {
        int a = 25;
        int b = 255;

        return "Sum of a and b : " + (a + b);
    }
}
