package org.farm.collector.apiresponse;

import lombok.Data;
import org.farm.collector.model.CropType;

@Data
public class HarvestResponse {
    private CropType cropType;
    private Long amountHarvested;
}
