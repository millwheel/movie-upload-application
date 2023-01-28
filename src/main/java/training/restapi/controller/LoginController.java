package training.restapi.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
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

    @PostMapping("/login")
    public void login(
            @RequestBody LoginForm data,
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        log.info("email={}, password={}", data.getEmail(), data.getPassword());

        Member loginMember = memberService.login(data.getEmail(), data.getPassword());

        if(loginMember == null){
            response.sendRedirect("/login");
        }

        HttpSession session = request.getSession();
        session.setAttribute("loginMember", loginMember);

        log.info("login success");
        response.sendRedirect("/");
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        session.invalidate();

        log.info("logout success");
        response.sendRedirect("/");
    }

}
