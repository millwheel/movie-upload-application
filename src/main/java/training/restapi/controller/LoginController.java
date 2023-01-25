package training.restapi.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import training.restapi.form.LoginFrame;
import training.restapi.service.MemberService;

import java.io.IOException;

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
        loginFrame.setPassword("your password");
        return loginFrame;
    }

    @PostMapping("/login")
    public void login(@RequestBody LoginFrame data, HttpServletResponse response) throws IOException {
        log.info("email={}, password={}",
                data.getEmail(), data.getPassword());
        if(!memberService.login(data.getEmail(), data.getPassword())){
            response.sendRedirect("/login");
        }else{
            response.sendRedirect("/");
        }
    }

}
