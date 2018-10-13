package org.eezer.service.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import javax.annotation.Resource;

import org.eezer.service.application.service.UserServiceImpl;
import org.eezer.service.domain.model.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UserController {

    @Resource
    private UserServiceImpl userService;

    @RequestMapping(value = "/getusers", method = GET)
    public List<User> getAllUsers() {

        log.info("Received request /getusers.");
        return userService.getUsers();
    }

    @RequestMapping(value = "/adduser", method = POST)
    public User addUser(@RequestBody User user) {

        log.info("Received request /adduser. Data: {}", user);

        return userService.addUser(user);
    }

}