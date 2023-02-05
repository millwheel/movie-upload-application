package training.restapi.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        log.info("certification activated. access to URI={}",requestURI);
        HttpSession session = request.getSession();

        if (session == null || session.getAttribute("loginMember") == null){
            log.info("non-certified access");
            response.sendRedirect("/login?redirect=" + requestURI);
            return false;
        }
        return true;
    }
}
