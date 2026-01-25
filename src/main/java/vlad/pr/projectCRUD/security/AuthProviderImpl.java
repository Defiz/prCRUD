package vlad.pr.projectCRUD.security;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Collections;

// логика для аутентификации пользователя
@AllArgsConstructor
@Component
public class AuthProviderImpl implements AuthenticationProvider {

    private final UserDetailsService userDetailsService;

    //принимает аутентефикацию с логином и паролем а возвращает аутентефикацию с principal(данные о пользователе)
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
        String password = authentication.getCredentials().toString();
        if (!password.equals(userDetails.getPassword())) {
            throw new BadCredentialsException("Incorrect password");
        }
        return new UsernamePasswordAuthenticationToken(userDetails, password, Collections.emptyList());
    }

    // метод для спринга, чтоб он понимал для какого обьекта работает аутентефикация
    @Override
    public boolean supports(Class<?> authentication) {
        return true ;
    }
}
