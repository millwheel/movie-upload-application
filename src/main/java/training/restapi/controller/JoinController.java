package training.restapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import training.restapi.domain.Member;
import training.restapi.form.JoinForm;
import training.restapi.service.MemberService;

@Slf4j
@RestController
public class JoinController {

    private final MemberService memberService;

    public JoinController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/join")
    public JoinForm join(@RequestBody JoinForm data){
        log.info("name={}, email={}, password={}, password confirm={}",
                data.getName(), data.getEmail(), data.getPassword(), data.getPasswordConfirm());

        if(!data.getPassword().equals(data.getPasswordConfirm())){
            log.info("password confirm doesn't match");
            return data;
        }
        memberService.join(data);

        return data;
    }
}
