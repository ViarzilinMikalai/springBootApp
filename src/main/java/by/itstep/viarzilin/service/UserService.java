package by.itstep.viarzilin.service;

import by.itstep.viarzilin.domain.Roles;
import by.itstep.viarzilin.domain.User;
import by.itstep.viarzilin.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.UUID;

public class UserService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    MailSenderService mailSenderService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepo.findByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("User not found!");
        }

        return user;
    }


    public boolean addUser(User user){

         User userFromDb = new User();

         if (userFromDb != null){

             return false;

         } else {

            user.setActive(false);
            user.setRoles(Collections.singleton(Roles.USER));
            user.setActivationCode(UUID.randomUUID().toString());
            user.setPassword(passwordEncoder.encode(user.getPassword()));

            userRepo.save(user);

            sendMessage(user);

            return true;
         }
    }


    private void sendMessage(User user){

        if (!StringUtils.isEmpty(user.getEmail())){

            String message = String.format(
                    "Hello, %s! \n" +
                            "Welcome to Sweater. Please, visit next link: http://localhost:8080/activate/%s",
                    user.getUsername(),
                    user.getActivationCode()
            );

            mailSenderService.send(user.getEmail(), "Activation Code!", message);
        }
    }

    public boolean activateUser(String code){

        User userByCode = userRepo.findByActivationCode(code);

        if (userByCode == null){

            return false;

        } else {

            userByCode.setActivationCode(null);
            userByCode.setActive(true);

            userRepo.save(userByCode);

            return true;
        }
    }

}
