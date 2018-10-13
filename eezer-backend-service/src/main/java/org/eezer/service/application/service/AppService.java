package org.eezer.service.application.service;

import javax.annotation.Resource;

import org.eezer.service.domain.model.Test;
import org.eezer.service.domain.repository.TestRepository;
import org.springframework.stereotype.Service;

@Service
public class AppService {

    @Resource
    private TestRepository testRepository;

    public void saveData() {

        Test a = Test.builder()
                .name("n")
                .build();

        testRepository.save(a);
    }

    public Test getData(String name) {

        return testRepository.getByName(name);
    }

}
