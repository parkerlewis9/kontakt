package com.kontakt.controller;

import com.kontakt.bean.Kontakt;
import com.kontakt.repository.KontaktRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KontaktController {

    @Autowired
    KontaktRepository repository;

    @RequestMapping(value = "/api/kontakts", method = RequestMethod.GET)
    public ResponseEntity<List<Kontakt>> allKontakts() {
        List<Kontakt> kontakts = repository.findAllByOrderByNameAsc();

        return new ResponseEntity<>(kontakts, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/kontakts/{id}", method = RequestMethod.GET)
    public ResponseEntity showKontakt(@PathVariable("id") String id) {
        Kontakt kontakt;

        if(repository.findById(Long.parseLong(id)).isPresent()) {
            kontakt = repository.findById(Long.parseLong(id)).get();
        } else {
            return new ResponseEntity<>("Kontakt with id " + id + " does not exist", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(kontakt, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/kontakts", method = RequestMethod.POST)
    public ResponseEntity createKontakt(@RequestBody Kontakt kontakt) {

        try {
            repository.save(kontakt);
        } catch (Exception e) {
            return new ResponseEntity<>("Kontakt object that was sent is invalid", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(kontakt, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/api/kontakts/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateKontakt(@PathVariable("id") String id, @RequestBody Kontakt kontakt) {

        Boolean kontaktIsPresent = repository.findById(Long.parseLong(id)).isPresent();

        if ( kontaktIsPresent ) {
            try {
                repository.save(kontakt);
            } catch (Exception e) {
                return new ResponseEntity<>("Kontakt object that was sent is invalid, the resource was not updated", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("There is no Kontakt with id: " + id, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(kontakt, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/kontakts/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteKontakt(@PathVariable("id") String id) {

        Boolean kontaktIsPresent = repository.findById(Long.parseLong(id)).isPresent();

        if ( kontaktIsPresent ) {
            try {
                repository.deleteById(Long.parseLong(id));
            } catch (Exception e) {
                return new ResponseEntity<>("There was an error deleting your Kontakt", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("There is no Kontakt with id: " + id, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Kontakt with id: " + id + " was deleted.", HttpStatus.OK);
    }
}
