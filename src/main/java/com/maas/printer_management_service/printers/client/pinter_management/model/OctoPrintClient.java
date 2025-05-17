package com.maas.printer_management_service.printers.client.pinter_management.model;

public interface OctoPrintClient {
   String getServer(String printerId);
    String getConnection(String printerId);
    String handlePrinterConnection(String connectionStatus, String printerId);
    String getAllFiles(String printerId, String path);
    String createFolder(String printerId, String folderName);
    String getJobStatus(String printerId);
    String handlePrintJob(String printerId, String filePath);
    String uploadFile(String printerId, String filePath);
    String getPrinterStatus(String printerId);
    PrinterProfiles getPrinterProfiles(String printerId);
}
