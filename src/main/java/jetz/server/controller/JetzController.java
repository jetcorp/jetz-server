package jetz.server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JetzController {

    @GetMapping("/")
    public ResponseEntity index() {
        return new ResponseEntity<>("Hello, Z!", HttpStatus.OK);
    }

}
