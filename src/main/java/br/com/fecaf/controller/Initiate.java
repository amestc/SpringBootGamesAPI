package br.com.fecaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Initiate {
    @GetMapping("/")
    public String index() {
        return "index"; // busca src/main/resources/templates/index.html
    }
}