package com.myproject.eshop.data.models.binding;

public class LaptopCreateBindingModel extends BaseProductCreateBindingModel {

    private String display;
    private String centralProcessingUnit;
    private String graphicsProcessingUnit;
    private int storage;
    private int ram;
    private double weight;

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getCentralProcessingUnit() {
        return centralProcessingUnit;
    }

    public void setCentralProcessingUnit(String centralProcessingUnit) {
        this.centralProcessingUnit = centralProcessingUnit;
    }

    public String getGraphicsProcessingUnit() {
        return graphicsProcessingUnit;
    }

    public void setGraphicsProcessingUnit(String graphicsProcessingUnit) {
        this.graphicsProcessingUnit = graphicsProcessingUnit;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
