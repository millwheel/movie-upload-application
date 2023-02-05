package training.restapi.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import training.restapi.Const;
import training.restapi.domain.Member;

@Slf4j
@RestController
public class HomeController {

    @GetMapping("/")
    public String home(HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session == null){
            log.info("no session");
            return "welcome";
        }
        Member loginMember = (Member)session.getAttribute(Const.LOGIN_MEMBER);
        if(loginMember == null){
            log.info("no user info");
            return "welcome";
        }

        return "welcome, member!";
    }

}
