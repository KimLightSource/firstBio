package softnet.firstBio.lifeLog.config.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class AuthFilterContainer {
    private OncePerRequestFilter authFilter;

    public void setAuthFilter(OncePerRequestFilter authFilter) {
        this.authFilter = authFilter;
    }

    public OncePerRequestFilter getFilter() {
        return authFilter;
    }
}
