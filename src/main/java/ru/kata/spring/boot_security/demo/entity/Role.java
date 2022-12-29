package ru.kata.spring.boot_security.demo.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Setter
@Getter
@ToString
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@DynamicInsert
@DynamicUpdate
@Table
public class Role implements Serializable, GrantedAuthority {
    static long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    long id;

    @Column(name = "roles")
    String role;

    @Transient
    @MapsId
    @ManyToMany
    Set<User> users;

    @Override
    public String getAuthority() {
        return getRole();
    }
}
