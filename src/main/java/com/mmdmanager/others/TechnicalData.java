package com.mmdmanager.others;

public class TechnicalData {
    private byte capacityUnitOfMeasure, inverter, powerSupply, ceMark, application, mode, refrigerant, compressorType;
    private Double refrigerantWeight, frequency;

    public TechnicalData(byte capacityUnitOfMeasure, byte inverter, byte powerSupply, byte ceMark, byte application, byte mode, byte refrigerant, byte compressorType, Double refrigerantWeight, Double frequency) {
        this.capacityUnitOfMeasure = capacityUnitOfMeasure;
        this.inverter = inverter;
        this.powerSupply = powerSupply;
        this.ceMark = ceMark;
        this.application = application;
        this.mode = mode;
        this.refrigerant = refrigerant;
        this.compressorType = compressorType;
        this.refrigerantWeight = refrigerantWeight;
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return capacityUnitOfMeasure + "," + inverter + "," + powerSupply + "," + ceMark + "," + application + ","
                + mode + "," + refrigerant + "," + compressorType + "," + refrigerantWeight + "," + frequency;
    }

    public byte getCapacityUnitOfMeasure() {
        return capacityUnitOfMeasure;
    }

    public byte getInverter() {
        return inverter;
    }

    public byte getPowerSupply() {
        return powerSupply;
    }

    public byte getCeMark() {
        return ceMark;
    }

    public byte getApplication() {
        return application;
    }

    public byte getMode() {
        return mode;
    }

    public byte getRefrigerant() {
        return refrigerant;
    }

    public byte getCompressorType() {
        return compressorType;
    }

    public Double getRefrigerantWeight() {
        return refrigerantWeight;
    }

    public Double getFrequency() {
        return frequency;
    }
}
