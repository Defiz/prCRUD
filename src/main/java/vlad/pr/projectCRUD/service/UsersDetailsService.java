package vlad.pr.projectCRUD.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vlad.pr.projectCRUD.model.User;
import vlad.pr.projectCRUD.repository.UserRepository;
import vlad.pr.projectCRUD.security.UsersDetails;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UsersDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByName(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User nor found!");
        }
        return new UsersDetails(user.get());
    }
}

