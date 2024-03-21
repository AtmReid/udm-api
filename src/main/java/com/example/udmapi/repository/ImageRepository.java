package com.example.udmapi.repository;

import com.example.udmapi.entity.Image;
import com.example.udmapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Integer> {

}
