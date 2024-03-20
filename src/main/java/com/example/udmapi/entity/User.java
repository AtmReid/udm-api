package com.example.udmapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

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

    @Column(name = "role")
    private String role;

    @Column(name = "online")
    private boolean online;

    @Column(name = "status_timestamp")
    private Timestamp statusTimestamp;

}
