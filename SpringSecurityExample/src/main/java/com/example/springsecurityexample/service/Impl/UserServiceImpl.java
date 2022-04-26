package com.example.springsecurityexample.service.Impl;

import com.example.springsecurityexample.model.*;
import com.example.springsecurityexample.repository.RoleRepository;
import com.example.springsecurityexample.repository.UserRepository;
import com.example.springsecurityexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private final String DEFAULT_PASSWORD = "admin";

    @Override
    @Transactional
    public User createUser(@Valid User user) {

        if(user.getUsername() != null)
        {
            if(isExistUserByUsername(user))
            {
                return null;
            }
            User user1 = new User();
            user1.setUsername(user.getUsername());
            user1.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            user1.setEnabled(true);
            userRepository.save(user1);
            System.out.println("Test ID user = " + user1.getUserId());
            insertWithQuery(user1);
        }
        return null;
    }


    @Transactional
    public void insertWithQuery(User user) {
        entityManager.createNativeQuery("INSERT INTO users_roles (user_id, role_id) VALUES (?,?)")
                .setParameter(1, user.getUserId())
                .setParameter(2, 1)
                .executeUpdate();
    }

    @Override
    public boolean isExistUserByUsername(User u) {
        User user = userRepository.findByUsername(u.getUsername().trim());
        if (user != null) {
            return true;
        }
        return false;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }




    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public void processOAuthPostLogin(String username) {
        User existUser = userRepository.findByUsername(username);

        if (existUser == null) {
            User newUser = new User();
            newUser.setUsername(username);
            newUser.setProvider(Provider.GOOGLE);
            newUser.setEnabled(true);
            newUser.setPassword(bCryptPasswordEncoder.encode(DEFAULT_PASSWORD));
            userRepository.save(newUser);
        }
    }

    public boolean isGoogleAccount(String username) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(username);
        return matcher.find();
    }
}
