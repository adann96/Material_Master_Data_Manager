package com.mmdmanager.others;

public class WeigthsAndDimensions {
    private Double grossWeight, netWeight, materialLength, materialWidth, materialHeight, materialVolume;

    public WeigthsAndDimensions(Double grossWeight, Double netWeight, Double materialLength, Double materialWidth, Double materialHeight, Double materialVolume) {
        this.grossWeight = grossWeight;
        this.netWeight = netWeight;
        this.materialLength = materialLength;
        this.materialWidth = materialWidth;
        this.materialHeight = materialHeight;
        this.materialVolume = materialVolume;
    }

    public Double getNetWeight() {
        return grossWeight * 0.8;
    }

    public Double getGrossWeight() {
        return grossWeight;
    }

    public Double getMaterialLength() {
        return materialLength;
    }

    public Double getMaterialWidth() {
        return materialWidth;
    }

    public Double getMaterialHeight() {
        return materialHeight;
    }

    public Double getMaterialVolume() {
        return materialVolume;
    }
}
