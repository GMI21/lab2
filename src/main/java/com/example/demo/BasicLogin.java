package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BasicLogin {

    @GetMapping("/login") // http://localhost:8080/BasicLogin
    public String login(@RequestParam(name = "login") String name, @RequestParam(name = "Password") String password, Model model) {
        String result;
        if ("admin".equals(name)) {
            if ("Pa$$w0rd".equals(password)) {
                result = "Success";
            } else {
                result = "Incorrect password";
            }
        } else {
            result = "Incorrect username";
        }
        model.addAttribute("result", result);
        return "Output.html";


    }
}
