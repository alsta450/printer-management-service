package com.maas.printer_management_service.printers.mapping;

import com.maas.model.LocationAddress;
import com.maas.model.Printer;
import com.maas.model.RegisterPrinterRequest;
import com.maas.printer_management_service.printers.model.Address;
import com.maas.printer_management_service.printers.model.Location;
import com.maas.printer_management_service.printers.model.PrinterEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PrinterMapper {

    @Mapping(source = "printerName", target = "name")
    @Mapping(source = "printerModel", target = "model")
    @Mapping(source = "printerMaterial", target = "material")
    @Mapping(target = "customerId", ignore = true)
    PrinterEntity toPrinterEntity(RegisterPrinterRequest request);

    List<Printer> toPrinterResponseList(List<PrinterEntity> entities);

    @Mappings({
            @Mapping(source = "address", target = "address"),
            @Mapping(source = "latitude", target = "latitude"),
            @Mapping(source = "longitude", target = "longitude")
    })
    Location map(com.maas.model.Location location);

    @Mappings({
            @Mapping(source = "street", target = "street"),
            @Mapping(source = "city", target = "city"),
            @Mapping(source = "state", target = "state"),
            @Mapping(source = "zip", target = "zip")
    })
    Address map(LocationAddress address);
}