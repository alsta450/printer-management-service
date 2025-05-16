package com.maas.printer_management_service.printers.controller;

import com.maas.api.CustomerApi;
import com.maas.model.GetAllPrinters200Response;
import com.maas.model.Printer;
import com.maas.model.RegisterPrinterRequest;
import com.maas.model.RegisterPrinterResponse;
import com.maas.printer_management_service.printers.service.PrinterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PrinterController implements CustomerApi {

    private final PrinterService printerService;

    public PrinterController(PrinterService printerService) {
        this.printerService = printerService;
    }

    @GetMapping("/printers/version")
    public String getVersion() {
        return printerService.getVersion();
    }




    @Override
    public ResponseEntity<RegisterPrinterResponse> registerPrinter(String customerId, RegisterPrinterRequest registerPrinterRequest) {
        return printerService.registerPrinter(customerId, registerPrinterRequest);
    }

    @Override
    public ResponseEntity<GetAllPrinters200Response> getAllPrintersByCustomer(String customerId) {
        List<Printer> printers = printerService.getAllPrintersByCustomer(customerId);
        return ResponseEntity.ok(new GetAllPrinters200Response()
                .printers(printers)
        );
    }
}
