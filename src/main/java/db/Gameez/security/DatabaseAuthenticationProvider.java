package db.Gameez.security;

import db.Gameez.Service.UserService;
import db.Gameez.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
public class DatabaseAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired // nu mai trebe scris constructorul. dar trebuie notate cu service, repo
    private UserService userService;

    @Override
    protected void additionalAuthenticationChecks(org.springframework.security.core.userdetails.UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        if (!usernamePasswordAuthenticationToken.getCredentials().toString().equals(userDetails.getPassword())) {
            throw new BadCredentialsException("Invalid credentials for user ");
        }
    }

    @Override
    protected UserDetails retrieveUser(String userName, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        boolean valid = true;

        final String password = (String) usernamePasswordAuthenticationToken.getCredentials();
        if (!StringUtils.hasText(password)) {
            valid = false;
        }

        Optional<User> user = userService.findByUsername(userName);

        if (user.isEmpty()) {
            valid = false;
        } else {
            // Check password
            if (password.equals(user.get().getPassword())) {
            } else {
                valid = false;
            }

        }

        if (!valid) {
            throw new BadCredentialsException("Invalid Username/Password for user " + userName);
        }

        User userEntity = user.get();
        // enabled, account not expired, credentials not expired, account not locked
        UserDetails userDetails = new UserDetails(userName, password, true, true, true, true, AuthorityUtils.NO_AUTHORITIES);
        userDetails.setId(userEntity.getUserId());
        return userDetails;
    }
}
