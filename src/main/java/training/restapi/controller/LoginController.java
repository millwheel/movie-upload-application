package training.restapi.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import training.restapi.Const;
import training.restapi.domain.Member;
import training.restapi.form.LoginForm;
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

    @GetMapping("/login")
    public LoginForm come(){
        LoginForm loginForm = new LoginForm();
        loginForm.setEmail("your email");
        loginForm.setPassword("your password");
        return loginForm;
    }

    @PostMapping("/login")
    public void login(
            @RequestBody LoginForm data,
            @RequestParam(defaultValue = "/") String redirectURL,
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        log.info("email={}, password={}", data.getEmail(), data.getPassword());

        Member loginMember = memberService.login(data.getEmail(), data.getPassword());

        if(loginMember == null){
            log.info("login fail");
            response.sendRedirect("/login");
            return;
        }

        log.info("login success");
        HttpSession session = request.getSession();
        session.setAttribute(Const.LOGIN_MEMBER, loginMember);
        response.sendRedirect(redirectURL);
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        session.invalidate();

        log.info("logout success");
        response.sendRedirect("/");
    }

}
