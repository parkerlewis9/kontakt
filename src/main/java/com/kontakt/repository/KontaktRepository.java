package com.kontakt.repository;

import com.kontakt.bean.Kontakt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KontaktRepository extends PagingAndSortingRepository<Kontakt, Long> {
}
