package org.farm.collector.apiresponse;


import lombok.Builder;
import org.farm.collector.model.CropType;

@Builder
public class PlantedResponse {
    public Long plantingArea;
    public CropType cropType;
    public Long expectedAmount;
}
