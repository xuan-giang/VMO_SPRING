package com.example.springsecurityexample.service;

import com.example.springsecurityexample.model.Role;
import com.example.springsecurityexample.model.Role_Projection;
import com.example.springsecurityexample.model.User;
import com.example.springsecurityexample.model.User_Role;
import com.example.springsecurityexample.repository.RoleRepository;
import com.example.springsecurityexample.repository.UserRepository;
import com.example.springsecurityexample.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User createUser(User user) {

        if(user.getUsername() != null)
        {
            if(isExistUserByUsername(user))
            {
                return null;
            }
            User user1 = new User();
            user1.setUsername(user.getUsername());
            user1.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userRepository.save(user1);

            Role role = new Role();
            role.setRoleCode("ADMIN");
            role.setRoleName("Quyen Admin");
            roleRepository.save(role);

            User_Role user_role = new User_Role();
            user_role.setRole(role);
            user_role.setUser(user1);
            userRoleRepository.save(user_role);
        }
        return null;
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
    public List<Role_Projection> getListRoleOfUser(Long userId) {
        return userRepository.getRoleOfUser(userId);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }


}
