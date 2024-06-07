package jetz.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JetzController {

    @GetMapping("/")
    public String index() {
        return "Hello Z";
    }
}
