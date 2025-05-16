package com.maas.printer_management_service.printers.controller;

import com.maas.api.PrintersApi;
import com.maas.model.GetAllPrinters200Response;
import com.maas.model.Printer;
import com.maas.printer_management_service.printers.service.PrinterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AllPrintersController implements PrintersApi {
    private final PrinterService printerService;

    public AllPrintersController(PrinterService printerService) {
        this.printerService = printerService;
    }

    @Override
    public ResponseEntity<GetAllPrinters200Response> getAllPrinters() {
        return ResponseEntity.ok(new GetAllPrinters200Response().printers(printerService.getAllPrinters()));
    }
}
