package com.maas.printer_management_service.printers.repository;

import com.maas.printer_management_service.printers.model.PrinterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrinterRepository extends JpaRepository<PrinterEntity, String> {
    List<PrinterEntity> findByCustomerId(String customerId);
}