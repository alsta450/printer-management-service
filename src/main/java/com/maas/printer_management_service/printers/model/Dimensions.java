package com.maas.printer_management_service.printers.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Dimensions {

    private Double width;
    private Double depth;
    private Double height;

    public Dimensions(Double width, Double depth, Double height) {
        this.width = width;
        this.depth = depth;
        this.height = height;
    }

    public Dimensions() {
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getDepth() {
        return depth;
    }

    public void setDepth(Double depth) {
        this.depth = depth;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }
}
