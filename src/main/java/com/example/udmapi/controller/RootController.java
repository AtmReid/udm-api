package com.example.udmapi.controller;


import com.example.udmapi.Settings;
import com.example.udmapi.entity.User;
import com.example.udmapi.exeption.BadRequestException;
import com.example.udmapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.Null;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class RootController {



    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> showAllUsers(@RequestParam(value = "online", required = false) Boolean online,
                                   @RequestParam(value = "id", required = false) Long id
    ){  if (id != null) {
        Timestamp timestamp = new Timestamp(id);
        if (online != null) {
            return userRepository.findByOnlineAndStatusTimestampAfter(online, timestamp);
        }
        return userRepository.findByStatusTimestampAfter(timestamp);
    } else if (online != null) {
        return userRepository.findByOnline(online);
    }
        return userRepository.findAll();
    }

    @GetMapping("{id}")
    public User getEmployee(@PathVariable int id) {
        User user = userService.getUser(id);
        return user;
    }

    @PostMapping
    public User addNewUser(@RequestBody User user) {
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Provide correct User");
        }
        userService.saveUser(user);
        return user;
    }

    @PostMapping("/upload_image")
    public String downloader(@RequestParam(value = "avatar") MultipartFile file)
            throws IOException {

        File directory = new File(Settings.UPLOAD_DIR);
        if (!directory.exists()) {
            directory.mkdir();
        }

        String fileName = file.getOriginalFilename();

        if (fileName != null && !fileName.endsWith("jpg")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Provide correct jpg");
        }

        File avatarFile = new File(directory.getPath() + File.separator + fileName);
        FileOutputStream fileOutputStream = new FileOutputStream(avatarFile);
        fileOutputStream.write(file.getBytes());
        fileOutputStream.close();

        return Settings.UPLOAD_DIR + fileName;
    }
}
