package com.maas.printer_management_service.printers.client.pinter_management.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PrinterProfiles {
    private Map<String, Profile> profiles;

    public Map<String, Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(Map<String, Profile> profiles) {
        this.profiles = profiles;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Profile {
        private Map<String, Axis> axes;
        private String color;
        private boolean current;

        @JsonProperty("default")
        private boolean defaultProfile;

        private Extruder extruder;
        private boolean heatedBed;
        private boolean heatedChamber;
        private String id;
        private String model;
        private String name;
        private String resource;
        private Volume volume;

        public Map<String, Axis> getAxes() {
            return axes;
        }

        public void setAxes(Map<String, Axis> axes) {
            this.axes = axes;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public boolean isCurrent() {
            return current;
        }

        public void setCurrent(boolean current) {
            this.current = current;
        }

        public boolean isDefaultProfile() {
            return defaultProfile;
        }

        public void setDefaultProfile(boolean defaultProfile) {
            this.defaultProfile = defaultProfile;
        }

        public Extruder getExtruder() {
            return extruder;
        }

        public void setExtruder(Extruder extruder) {
            this.extruder = extruder;
        }

        public boolean isHeatedBed() {
            return heatedBed;
        }

        public void setHeatedBed(boolean heatedBed) {
            this.heatedBed = heatedBed;
        }

        public boolean isHeatedChamber() {
            return heatedChamber;
        }

        public void setHeatedChamber(boolean heatedChamber) {
            this.heatedChamber = heatedChamber;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getResource() {
            return resource;
        }

        public void setResource(String resource) {
            this.resource = resource;
        }

        public Volume getVolume() {
            return volume;
        }

        public void setVolume(Volume volume) {
            this.volume = volume;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Axis {
        private boolean inverted;
        private int speed;

        public boolean isInverted() {
            return inverted;
        }

        public void setInverted(boolean inverted) {
            this.inverted = inverted;
        }

        public int getSpeed() {
            return speed;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Extruder {
        private int count;
        private int defaultExtrusionLength;
        private double nozzleDiameter;
        private List<List<Double>> offsets;
        private boolean sharedNozzle;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getDefaultExtrusionLength() {
            return defaultExtrusionLength;
        }

        public void setDefaultExtrusionLength(int defaultExtrusionLength) {
            this.defaultExtrusionLength = defaultExtrusionLength;
        }

        public double getNozzleDiameter() {
            return nozzleDiameter;
        }

        public void setNozzleDiameter(double nozzleDiameter) {
            this.nozzleDiameter = nozzleDiameter;
        }

        public List<List<Double>> getOffsets() {
            return offsets;
        }

        public void setOffsets(List<List<Double>> offsets) {
            this.offsets = offsets;
        }

        public boolean isSharedNozzle() {
            return sharedNozzle;
        }

        public void setSharedNozzle(boolean sharedNozzle) {
            this.sharedNozzle = sharedNozzle;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Volume {
        @JsonProperty("custom_box")
        private boolean customBox;
        private double depth;
        private String formFactor;
        private double height;
        private String origin;
        private double width;

        public boolean isCustomBox() {
            return customBox;
        }

        public void setCustomBox(boolean customBox) {
            this.customBox = customBox;
        }

        public double getDepth() {
            return depth;
        }

        public void setDepth(double depth) {
            this.depth = depth;
        }

        public String getFormFactor() {
            return formFactor;
        }

        public void setFormFactor(String formFactor) {
            this.formFactor = formFactor;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public double getWidth() {
            return width;
        }

        public void setWidth(double width) {
            this.width = width;
        }
    }
}
