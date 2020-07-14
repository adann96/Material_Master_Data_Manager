package com.mmdmanager.others;

public class Material {
    private GeneralData generalData;
    private MaterialData materialData;
    private WeigthsAndDimensions weigthsAndDimensions;
    private TechnicalData technicalData;
    private LogisticData logisticData;

    public Material(GeneralData generalData, MaterialData materialData, WeigthsAndDimensions weigthsAndDimensions, TechnicalData technicalData, LogisticData logisticData) {
        this.generalData = generalData;
        this.materialData = materialData;
        this.weigthsAndDimensions = weigthsAndDimensions;
        this.technicalData = technicalData;
        this.logisticData = logisticData;
    }

    @Override
    public String toString() {
        return generalData + "," + materialData + "," + weigthsAndDimensions + "," + technicalData + "," + logisticData;
    }
}

