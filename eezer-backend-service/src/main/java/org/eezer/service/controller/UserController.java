package org.eezer.service.controller;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.annotation.Resource;

import org.eezer.api.exception.EezerException;
import org.eezer.api.valueobject.User;
import org.eezer.service.application.service.ApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UserController {

    @Resource
    private ApplicationService applicationService;

    @RequestMapping(value = "/getusers", method = GET)
    public ResponseEntity getAllUsers() {

        log.info("Received request /getusers.");

        try {

            return ResponseEntity.ok(applicationService.getUsers());
        } catch (EezerException e) {

            return ResponseEntity.badRequest().body(e.getError());
        }
    }

    @RequestMapping(value = "/adduser", method = POST)
    public ResponseEntity addUser(@RequestBody User userDTO) {

        log.info("Received request /adduser. Data: {}", userDTO);

        try {

            return ResponseEntity.ok(applicationService.addUser(userDTO));
        } catch (EezerException e) {

            return ResponseEntity.badRequest().body(e.getError());
        }
    }

    @RequestMapping(value = "/rmuser/{username}", method = DELETE)
    public ResponseEntity removeUser(@PathVariable(value = "username") String username) {

        log.info("Received request /rmuser. Username: {}", username);

        try {

            return ResponseEntity.ok(applicationService.removeUser(username));
        } catch (EezerException e) {

            return ResponseEntity.badRequest().body(e.getError());
        }
    }

}