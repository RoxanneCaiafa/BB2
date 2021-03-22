package com.bb2.formacion.formacion.Service;

import com.bb2.formacion.formacion.DTO.SupplierDTO;

import java.util.List;

public interface SupplierService {
    List<SupplierDTO> getSuppliers();
    SupplierDTO findSupplierById(Long code);
}
