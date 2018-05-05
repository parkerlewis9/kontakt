package com.kontakt.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kontakt.bean.Kontakt;
import com.kontakt.repository.KontaktRepository;
import com.kontakt.service.IKontaktService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.lang.reflect.Array;
import java.util.List;

@RestController
public class KontaktController {

    @Autowired
    IKontaktService kontaktService;

    @Autowired
    KontaktRepository repository;

    private ObjectMapper mapper = new ObjectMapper();

    @RequestMapping(value = "/api/kontakts", method = RequestMethod.GET)
    public ResponseEntity<List<Kontakt>> allKontakts() {
        List<Kontakt> kontakts = (List<Kontakt>) repository.findAll();

        return new ResponseEntity<>(kontakts, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/kontakts/{id}", method = RequestMethod.GET)
    public ResponseEntity<Kontakt> showKontakt(@PathVariable("id") String id) {

        Kontakt kontakt = repository.findById(Long.parseLong(id)).get();
        return new ResponseEntity<>(kontakt, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/kontakts", method = RequestMethod.POST)
    public ResponseEntity createKontakt(@RequestBody Kontakt kontakt) {
        try {
            repository.save(kontakt);
        } catch (Exception e) {
            return new ResponseEntity<>("Kontakt object is invalid", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
//
//    @RequestMapping(value = "/api/kontakts/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<Kontakt> updateKontakt(@PathVariable("id") String id, @RequestBody Kontakt kontakt) {
//        // update and return
//    }

    @RequestMapping(value = "/api/kontakts/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteKontakt(@PathVariable("id") String id) {
        // delete and return confirmation
        return new ResponseEntity<>("all good", HttpStatus.OK);
    }
}
