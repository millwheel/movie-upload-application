package training.restapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import training.restapi.form.LoginForm;
import training.restapi.service.MemberService;

@Slf4j
@RestController
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/login")
    public LoginForm login(){
        LoginForm loginForm = new LoginForm();
        loginForm.setUsername("Input your user id");
        loginForm.setPassword("Your password");
        return loginForm;
    }

    @PostMapping("/login/confirm")
    public LoginForm requestBodyJsonV5(@RequestBody LoginForm data) {
        log.info("username={}, password={}",
                data.getUsername(), data.getPassword());
        return data;
    }
}
