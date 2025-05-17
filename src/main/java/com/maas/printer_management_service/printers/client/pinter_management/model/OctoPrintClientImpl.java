package com.maas.printer_management_service.printers.client.pinter_management.model;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class OctoPrintClientImpl implements OctoPrintClient {

    private final RestTemplate restTemplate;

    private static final String API_KEY = "27qi5Ym2THMviJB8MPblbJcIUvKnvmam6ifIZ7sXSI4";

    public OctoPrintClientImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String getServer(String printerId) {
        return "";
    }

    @Override
    public String getConnection(String printerId) {
        return "";
    }

    @Override
    public String handlePrinterConnection(String connectionStatus, String printerId) {
        return "";
    }

    @Override
    public String getAllFiles(String printerId, String path) {
        return "";
    }

    @Override
    public String createFolder(String printerId, String folderName) {
        return "";
    }

    @Override
    public String getJobStatus(String printerId) {
        return "";
    }

    @Override
    public String handlePrintJob(String printerId, String filePath) {
        return "";
    }

    @Override
    public String uploadFile(String printerId, String filePath) {
        return "";
    }

    @Override
    public String getPrinterStatus(String printerId) {
        return "";
    }

    @Override
    public PrinterProfiles getPrinterProfiles(String printerId) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Api-Key", API_KEY);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        String url = "http://192.168.0.212/api/printerprofiles";
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Disable SSL verification (use only for trusted networks!)
        // System.setProperty("jdk.internal.httpclient.disableHostnameVerification", Boolean.TRUE.toString());

        ResponseEntity<PrinterProfiles> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                PrinterProfiles.class
        );
        return response.getBody();
    }
}
