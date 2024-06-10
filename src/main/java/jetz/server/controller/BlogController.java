package jetz.server.controller;

import jetz.server.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {
    @GetMapping("/@{zname}")
    public ResponseEntity blog(@PathVariable("zname") String zname) {
        return new ResponseEntity<>(zname, HttpStatus.OK);
    }
}
