package org.eezer.service.controller;

import javax.annotation.Resource;

import org.eezer.service.application.service.ApplicationService;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class TransportController {

    @Resource
    private ApplicationService applicationService;



}
