package com.example.springsecurityexample.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;


    @NotEmpty
    @Email(message = "Your email is invalid!")
    private String username;

    @NotEmpty
    @Size(min = 8, message = "Password should have least 8 letter")
    private String password;

    @OneToMany(mappedBy = "user")
    private List<User_Role> user_roles;

    public User(String username, String password, List<GrantedAuthority> authories) {
    }
}
