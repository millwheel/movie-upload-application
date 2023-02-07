package training.restapi.sessionListener;

import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import training.restapi.Const;
import training.restapi.domain.Member;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class WebSessionAttributeListener implements HttpSessionAttributeListener {
    private static final Map<Member, HttpSession> sessions = new HashMap<>();

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        HttpSession session = se.getSession();
        Member loginMember = (Member)session.getAttribute(Const.LOGIN_MEMBER);
        log.info("stored member={} with session={} ", loginMember, session);
        deletePreviousSession(loginMember);
        sessions.put(loginMember, session);
    }

    public void deletePreviousSession(Member loginMember){
        if (sessions.containsKey(loginMember)){
            HttpSession sessionPrevious = sessions.get(loginMember);
            sessionPrevious.invalidate();
            log.info("invalidate previous session of multiple access");
        }
    }
}
