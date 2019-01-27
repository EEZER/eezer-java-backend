package org.eezer.service.controller;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.annotation.Resource;

import org.eezer.api.enums.EezerRole;
import org.eezer.api.exception.EezerException;
import org.eezer.api.request.EezerAddUserRequest;
import org.eezer.api.request.EezerEditUserRequest;
import org.eezer.service.application.service.ApplicationService;
import org.eezer.service.security.annotation.AuthSecured;
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

    @AuthSecured(role = EezerRole.ADMIN)
    @RequestMapping(value = "/getusers", method = GET)
    public ResponseEntity getAllUsers() {

        log.info("Received request /getusers.");

        try {

            return ResponseEntity.ok(applicationService.getUsers());
        } catch (EezerException e) {

            return ResponseEntity.badRequest().body(e.getError());
        } catch (Exception e) {

            log.error("Got unhandled exception.", e);
            throw e;
        }
    }

    @AuthSecured(role = EezerRole.ADMIN)
    @RequestMapping(value = "/adduser", method = POST)
    public ResponseEntity addUser(@RequestBody EezerAddUserRequest request) {

        log.info("Received request /adduser.");

        try {

            return ResponseEntity.ok(applicationService.addUser(request));
        } catch (EezerException e) {

            return ResponseEntity.badRequest().body(e.getError());
        } catch (Exception e) {

            log.error("Got unhandled exception.", e);
            throw e;
        }
    }

    @AuthSecured(role = EezerRole.ADMIN)
    @RequestMapping(value = "/edituser/{username}", method = POST)
    public ResponseEntity editUser(@PathVariable(value = "username") String username,
                                   @RequestBody EezerEditUserRequest request) {

        log.info("Received request /edituser.");

        try {

            return ResponseEntity.ok(applicationService.editUser(username, request));
        } catch (EezerException e) {

            return ResponseEntity.badRequest().body(e.getError());
        } catch (Exception e) {

            log.error("Got unhandled exception.", e);
            throw e;
        }
    }

    @AuthSecured(role = EezerRole.ADMIN)
    @RequestMapping(value = "/rmuser/{username}", method = DELETE)
    public ResponseEntity removeUser(@PathVariable(value = "username") String username) {

        log.info("Received request /rmuser.");

        try {

            return ResponseEntity.ok(applicationService.removeUser(username));
        } catch (EezerException e) {

            return ResponseEntity.badRequest().body(e.getError());
        } catch (Exception e) {

            log.error("Got unhandled exception.", e);
            throw e;
        }
    }

}