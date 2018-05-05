package com.kontakt.service;

import com.kontakt.bean.Kontakt;
import com.kontakt.repository.KontaktRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KontaktService implements IKontaktService {

    @Autowired
    private KontaktRepository repository;

    @Override
    public List<Kontakt> findAll() {

        List<Kontakt> kontakts = (List<Kontakt>) repository.findAll();

        return kontakts;
    }
}
