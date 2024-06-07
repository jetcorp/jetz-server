package jetz.server.controller;

import jetz.server.dto.LoginRequestDto;
import jetz.server.dto.SignupRequestDto;
import jetz.server.dto.SignupResponseDto;
import jetz.server.repository.ZuserRepository;
import jetz.server.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
//@RequestMapping("/api/auth")
public class AuthController {
    private ZuserRepository zuserRepository;
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody SignupRequestDto request) throws Exception {
        return new ResponseEntity<>(authService.login(request), HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody SignupRequestDto request) throws Exception {
        return new ResponseEntity<>(authService.signup(request), HttpStatus.OK);
    }

    @PostMapping("/user/info")
    public ResponseEntity getUserinfo(@RequestParam String email) throws Exception {
        return new ResponseEntity<>(authService.getZuser(email), HttpStatus.OK);
    }
}
