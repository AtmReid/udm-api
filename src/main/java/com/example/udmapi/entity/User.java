package com.example.udmapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;


@Data
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name="password")
    private String password;

    @Column(name = "email",unique = true)
    @Email
    @NotNull
    private String email;

    @Column(name = "image")
    private String image;

    @OneToMany(mappedBy = "roles", cascade = CascadeType.ALL)
    private List<Role> roles;

    @Column(name = "online")
    private boolean online;

    @Column(name = "status_timestamp")
    private Timestamp statusTimestamp;

}
