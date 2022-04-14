package com.example.springsecurityexample.service;

import com.example.springsecurityexample.model.Role_Projection;
import com.example.springsecurityexample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        if (user != null) {
            List<Role_Projection> strRoleList = userService.getListRoleOfUser(user.getUserId());
            Set<String> roleSet = new HashSet();
            for(Role_Projection role : strRoleList) {
                roleSet.add(role.getRoleCode());
            }

            //lay danh sach quyen cua user do
            List<GrantedAuthority> authories = roleSet.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
            return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authories);

        }

        return null;

    }
}
