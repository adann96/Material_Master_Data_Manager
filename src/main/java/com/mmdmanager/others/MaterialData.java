package com.mmdmanager.others;

public class MaterialData {
    private String productNumber, materialName, remark, materialGroup, productHierarchy;
    private StringBuilder batchNumber;

    public MaterialData(String productNumber, String materialName, String remark, StringBuilder batchNumber, String materialGroup, String productHierarchy) {
        this.productNumber = productNumber;
        this.materialName = materialName;
        this.remark = remark;
        this.materialGroup = materialGroup;
        this.productHierarchy = productHierarchy;
        this.batchNumber = batchNumber;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public String getMaterialName() {
        return materialName;
    }

    public String getRemark() {
        return remark;
    }

    public String getMaterialGroup() {
        return materialGroup;
    }

    public String getProductHierarchy() {
        return productHierarchy;
    }

    public StringBuilder getBatchNumber() {
        return batchNumber;
    }
}
