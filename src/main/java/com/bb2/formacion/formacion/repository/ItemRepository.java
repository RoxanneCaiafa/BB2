package com.bb2.formacion.formacion.repository;

import com.bb2.formacion.formacion.ENTITY.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query("SELECT CASE WHEN COUNT(i) > 0 THEN true ELSE false END FROM Item i INNER JOIN i.suppliers s WHERE i.code = :itemId AND s.idSupplier = :supId")
    boolean isTheSuppAssign(Long itemId, Long supId);
  }
