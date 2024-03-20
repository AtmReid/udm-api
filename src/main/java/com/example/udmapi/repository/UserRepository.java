package com.example.udmapi.repository;


import com.example.udmapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByOnlineAndStatusTimestampAfter(boolean online, Timestamp statusTimestamp);
    List<User> findByOnline (boolean online);
    List<User> findByStatusTimestampAfter (Timestamp statusTimestamp);
}
