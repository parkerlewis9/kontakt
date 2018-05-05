package com.kontakt.repository;

import com.kontakt.bean.Kontakt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KontaktRepository extends CrudRepository<Kontakt, Long> {
}
