package org.eezer.service.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.annotation.Resource;

import org.eezer.service.application.service.AppService;
import org.eezer.service.domain.model.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UserController {

    @Resource
    private AppService appService;

    @RequestMapping(value = "/get", method = GET)
    public Test getData() {

        log.info("GET");

        Test t = appService.getData("namnet2");

        log.info("T är: {}", t);

        return t;
    }

    @RequestMapping(value = "/save", method = POST)
    public String saveData() {

        log.info("SAVE");

        appService.saveData();

        return "ok";
    }

}