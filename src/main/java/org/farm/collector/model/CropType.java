package org.farm.collector.model;

public enum CropType {

    CORN("Corn"),
    POTATOES("Potatoes");

    private final String description;

    CropType(String aDescription){
        description = aDescription;
    }

    public String getDescription() {
        return description;
    }
}
