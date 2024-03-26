package com.example.demo.service;

import com.example.demo.model.RM1Resource;
import com.example.demo.repository.RM1ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class testDbServiceJpa {

    @Autowired
    private RM1ResourceRepository rm1Rpy;

    public List<RM1Resource> getAllRm1_s(String va) {
        return rm1Rpy.getAllRm1(va);
    }

    public List<RM1Resource> getAllRm1_s() {
        return rm1Rpy.getAllRm1();
    }

}
