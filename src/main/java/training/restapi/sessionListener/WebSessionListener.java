package training.restapi.sessionListener;

import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import training.restapi.domain.Member;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class WebSessionListener implements HttpSessionListener {
    private static final Map<String, Member> sessions = new HashMap<>();

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        String sessionId = session.getId();
        log.info("session invalidate, remove member from memory storage");
        sessions.remove(sessionId);
    }
}
