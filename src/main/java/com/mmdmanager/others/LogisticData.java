package com.mmdmanager.others;

public class LogisticData {
    private byte packingStyle, salesOemProduct, buyOemProduct, indoorOutdoor, dgIndicatorProfile, businessPilar;
    private String source, salesBrand, destinationMarket, factory, mrpType, snpPlanner;

    public LogisticData(byte packingStyle, byte salesOemProduct, byte buyOemProduct, byte indoorOutdoor, byte dgIndicatorProfile, String salesBrand, byte businessPilar, String source, String destinationMarket, String factory, String mrpType, String snpPlanner) {
        this.packingStyle = packingStyle;
        this.salesOemProduct = salesOemProduct;
        this.buyOemProduct = buyOemProduct;
        this.indoorOutdoor = indoorOutdoor;
        this.dgIndicatorProfile = dgIndicatorProfile;
        this.businessPilar = businessPilar;
        this.destinationMarket = destinationMarket;
        this.factory = factory;
        this.salesBrand = salesBrand;
        this.source = source;
        this.mrpType = mrpType;
        this.snpPlanner = snpPlanner;
    }

    @Override
    public String toString() {
        return packingStyle + "," + salesOemProduct + "," + buyOemProduct + "," + indoorOutdoor + "," + dgIndicatorProfile
                + "," + businessPilar + "," + source + "," + salesBrand + "," + destinationMarket + "," + factory + "," + mrpType + "," + snpPlanner;
    }

    public String getSource() {
        return source;
    }

    public String getSalesBrand() {
        return salesBrand;
    }

    public byte getPackingStyle() {
        return packingStyle;
    }

    public byte getSalesOemProduct() {
        return salesOemProduct;
    }

    public byte getBuyOemProduct() {
        return buyOemProduct;
    }

    public byte getIndoorOutdoor() {
        return indoorOutdoor;
    }

    public byte getDgIndicatorProfile() {
        return dgIndicatorProfile;
    }

    public byte getBusinessPilar() {
        return businessPilar;
    }

    public String getDestinationMarket() {
        return destinationMarket;
    }

    public String getMrpType() {
        return mrpType;
    }

    public String getSnpPlanner() {
        return snpPlanner;
    }

    public String getFactory() {
        return factory;
    }
}
