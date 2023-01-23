package training.restapi.controller;

import jdk.jfr.Registered;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import training.restapi.form.JoinFrame;
import training.restapi.service.MemberService;

@Slf4j
@RestController
public class JoinController {

    private final MemberService memberService;

    public JoinController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/join")
    public JoinFrame joinForm(){
        JoinFrame joinFrame = new JoinFrame();
        joinFrame.setName("your name");
        joinFrame.setEmail("your email");
        joinFrame.setPassword("your password");
        joinFrame.setPasswordConfirm("password confirm");
        return joinFrame;
    }

    @PostMapping("/join")
    public JoinFrame join(@RequestBody JoinFrame data){
        log.info("name={}, email={}, password={}, password confirm={}",
                data.getName(), data.getEmail(), data.getPassword(), data.getPasswordConfirm());
        return data;
    }
}
