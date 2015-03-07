package com.habuma.spitter.client.rmi;

import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.domain.Spittle;
import com.habuma.spitter.service.SpitterService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SpitterRmiClient {

    @Autowired
    SpitterService spitterService;

    public List<Spittle> getSpittles(String userName) {
        Spitter spitter = spitterService.getSpitter(userName);
        return spitterService.getSpittlesForSpitter(spitter);
    }

}
