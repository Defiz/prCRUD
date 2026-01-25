package vlad.pr.projectCRUD.config;

import lombok.AllArgsConstructor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import vlad.pr.projectCRUD.security.AuthProviderImpl;

@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {

    private final AuthProviderImpl authProvider;

    // настройка аутентификации
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authProvider);
    }
}
