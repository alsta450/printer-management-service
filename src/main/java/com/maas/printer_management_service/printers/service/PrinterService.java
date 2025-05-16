package com.maas.printer_management_service.printers.service;

import com.maas.model.Printer;
import com.maas.model.RegisterPrinterRequest;
import com.maas.model.RegisterPrinterResponse;
import com.maas.printer_management_service.printers.mapping.PrinterMapper;
import com.maas.printer_management_service.printers.model.PrinterEntity;
import com.maas.printer_management_service.printers.repository.PrinterRepository;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class PrinterService {

    private final PrinterRepository printerRepository;
    private final PrinterMapper printerMapper;

    private static final String API_KEY = "27qi5Ym2THMviJB8MPblbJcIUvKnvmam6ifIZ7sXSI4";
    private static final String OCTOPRINT_URL = "http://192.168.0.212/api/version";

    public PrinterService(PrinterRepository printerRepository, PrinterMapper printerMapper) {
        this.printerRepository = printerRepository;
        this.printerMapper = printerMapper;
    }

    public String getVersion() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Api-Key", API_KEY);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Disable SSL verification (use only for trusted networks!)
        System.setProperty("jdk.internal.httpclient.disableHostnameVerification", Boolean.TRUE.toString());

        ResponseEntity<String> response = restTemplate.exchange(
                OCTOPRINT_URL,
                HttpMethod.GET,
                entity,
                String.class
        );

        return "Response: " + response.getBody();
    }

    public List<Printer> getAllPrintersByCustomer(String customerId) {

        printerRepository.findByCustomerId(customerId).forEach(System.out::println);

        return printerMapper.toPrinterResponseList(printerRepository.findByCustomerId(customerId));
    }


    public ResponseEntity<RegisterPrinterResponse> registerPrinter(String customerId, RegisterPrinterRequest request) {
        PrinterEntity printerEntity = printerMapper.toPrinterEntity(request);
        printerEntity.setCustomerId(customerId);
        System.out.println(printerEntity);

        PrinterEntity savedPrinter = printerRepository.save(printerEntity);

        RegisterPrinterResponse response = new RegisterPrinterResponse();
        response.setSuccess(true);
        response.setMessage("Printer registered successfully");
        response.setPrinterId(savedPrinter.getId());

        return ResponseEntity.ok(response);
    }
}
