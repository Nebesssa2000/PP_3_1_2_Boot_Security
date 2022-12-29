package ru.kata.spring.boot_security.demo.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Collection;

@Setter
@Getter
@ToString
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "users")
public class User implements Serializable, UserDetails {
    static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    Long id;

    @Column(name = "user_name")
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    String userName;

    @Column(name = "user_last_name")
    @NotEmpty(message = "Lastname should not be empty")
    @Size(min = 2, max = 30, message = "Lastname should be between 2 and 30 characters")
    String userLastName;

    @Column(name = "password")
    @NotEmpty(message = "Password should not be empty")
    String password;

    public User(String userName, String userLastName, String password) {
        this.userName = userName;
        this.userLastName = userLastName;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
