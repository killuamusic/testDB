package com.example.demo.controller;

import com.example.demo.model.RM1Resource;
import com.example.demo.repository.RM1ResourceRepository;
import com.example.demo.service.testDbServiceJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class testDbControllerJpa {

    @Autowired
    private RM1ResourceRepository rm1;
    @Autowired
    private testDbServiceJpa srm1;

    @GetMapping("/get1")
    public List<RM1Resource> get1() {

        System.out.println(srm1.getAllRm1_s());
        return srm1.getAllRm1_s();
    }

    @GetMapping("/get1")
    public List<RM1Resource> get11(@RequestParam("va") String va) {

        System.out.println(srm1.getAllRm1_s(va));
        return srm1.getAllRm1_s(va);
    }

    @GetMapping("/get2")
    public List<RM1Resource> get2(@RequestParam("va") String va) {

        System.out.println(rm1.getAllRm1(va));
        return rm1.getAllRm1(va);
    }

}