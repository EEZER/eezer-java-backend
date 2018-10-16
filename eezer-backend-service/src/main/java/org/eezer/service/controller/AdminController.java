package org.eezer.service.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.annotation.Resource;

import org.eezer.api.exception.EezerException;
import org.eezer.api.request.EezerCreateTokenRequest;
import org.eezer.service.application.service.ApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AdminController {

    @Resource
    private ApplicationService applicationService;

    @RequestMapping(value = "/login", method = POST)
    public ResponseEntity loginUser(@RequestBody EezerCreateTokenRequest request) {

        log.info("Received request /login.");

        try {

            return ResponseEntity.ok(applicationService.createToken(request));
        } catch (EezerException e) {

            return ResponseEntity.badRequest().body(e.getError());
        } catch (Exception e) {

            log.error("Got unhandled exception. Error: {}", e);
            throw e;
        }
    }

}
