package com.bb2.formacion.formacion.repository;

import com.bb2.formacion.formacion.ENTITY.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
