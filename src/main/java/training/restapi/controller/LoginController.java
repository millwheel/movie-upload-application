package training.restapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import training.restapi.form.LoginFrame;
import training.restapi.service.MemberService;

@Slf4j
@RestController
public class LoginController {

    private final MemberService memberService;

    @Autowired
    public LoginController(MemberService memberService) {
        this.memberService = memberService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/login")
    public LoginFrame loginForm(){
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setEmail("Input your user email");
        loginFrame.setPassword("password");
        return loginFrame;
    }

    @PostMapping("/login")
    public LoginFrame login(@RequestBody LoginFrame data) {
        log.info("email={}, password={}",
                data.getEmail(), data.getPassword());
        return data;
    }
}
