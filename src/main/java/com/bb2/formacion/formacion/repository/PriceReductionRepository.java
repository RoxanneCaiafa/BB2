package com.bb2.formacion.formacion.repository;

import com.bb2.formacion.formacion.ENTITY.PriceReduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceReductionRepository extends JpaRepository<PriceReduction, Long> {
}
