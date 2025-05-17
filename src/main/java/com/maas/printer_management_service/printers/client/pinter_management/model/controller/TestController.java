package com.maas.printer_management_service.printers.client.pinter_management.model.controller;

import com.maas.printer_management_service.printers.client.pinter_management.model.OctoPrintClient;
import com.maas.printer_management_service.printers.client.pinter_management.model.PrinterProfiles;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final OctoPrintClient octoPrintClient;

    public TestController(OctoPrintClient octoPrintClient) {
        this.octoPrintClient = octoPrintClient;
    }

    // This is a test controller to verify the application is running
    @GetMapping("/printers/{printerId}/profiles")
    public ResponseEntity<PrinterProfiles> getPrinterProfiles(@PathVariable String printerId) {
        return ResponseEntity.ok(octoPrintClient.getPrinterProfiles(printerId));
    }

    // Add more test endpoints as needed

}
