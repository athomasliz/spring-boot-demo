package com.example.demo.service;

import com.example.demo.data.persistence.model.Couple;
import com.example.demo.data.persistence.repository.CoupleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CoupleService {

    @Autowired
    private CoupleRepository coupleRepository;

    public String findYourWife(String husband){
        List<Couple> lCouple = coupleRepository.findByHusband(husband);

        if(lCouple!=null && !lCouple.isEmpty()) {
            return lCouple.get(0).getWife();
        }
        else{
            return "";
        }
    }

}
