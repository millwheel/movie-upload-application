package training.restapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import training.restapi.domain.Member;
import training.restapi.form.LoginFrame;
import training.restapi.service.MemberService;

@Slf4j
@Controller
public class LoginController {

    private final MemberService memberService;

    @Autowired
    public LoginController(MemberService memberService) {
        this.memberService = memberService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/login")
    @ResponseBody
    public LoginFrame loginForm(){
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setEmail("Input your user email");
        loginFrame.setPassword("your password");
        return loginFrame;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginFrame data, RedirectAttributes redirectAttributes) {
        log.info("email={}, password={}",
                data.getEmail(), data.getPassword());
        if(!memberService.login(data.getEmail(), data.getPassword())){
            return "redirect:/login/error";
        }
        return "redirect:/";
    }

    @GetMapping("/login/error")
    @ResponseBody
    public String loginError(){
        return "invalid id/password. check if it is correct.";
    }
}
