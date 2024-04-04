package com.example.demo.service;

import com.example.demo.model.RM1Resource;
import com.example.demo.repository.RM1ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class testDbServiceJpa {

    @Autowired
    private RM1ResourceRepository rm1Rpy;

//    @Autowired
//    private Environment env;

    public List<RM1Resource> getAllRm1_s(String va) {
        return rm1Rpy.getAllRm1(va);
    }

    public List<RM1Resource> getAllRm1_s() {
        return rm1Rpy.getAllRm1();
    }

    public String convertDateFormat(String inputDateString) {
        DateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        DateFormat outputDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date inputDate = inputDateFormat.parse(inputDateString);
            return outputDateFormat.format(inputDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String convertDateFormat2(String inputDateString) {
        DateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat outputDateFormat = new SimpleDateFormat("dd/MM/yyyy");

//        System.out.println(env.getProperty("app.LoginServices","-"));

        try {
            Date inputDate = inputDateFormat.parse(inputDateString);
            return outputDateFormat.format(inputDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

}
