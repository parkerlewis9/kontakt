package com.kontakt.repository;

import com.kontakt.bean.Kontakt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KontaktRepository extends CrudRepository<Kontakt, Long> {
    List<Kontakt> findAllByOrderByNameAsc();
}
