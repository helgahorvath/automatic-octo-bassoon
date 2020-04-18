package hu.strong.fish.service;

import hu.strong.fish.model.User;
import hu.strong.fish.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public User getUserByName(String username) {
        return userRepository.getUserByUsername(username);
    }

}
