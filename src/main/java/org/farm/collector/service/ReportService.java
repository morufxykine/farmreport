package org.farm.collector.service;


import org.farm.collector.apiresponse.HarvestResponse;
import org.farm.collector.apiresponse.PlantedResponse;
import org.farm.collector.entity.Harvest;
import org.farm.collector.entity.Planted;
import org.farm.collector.model.CropType;
import org.farm.collector.repo.HarvestRepo;
import org.farm.collector.repo.PlantedRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReportService {

    @Autowired
    public  HarvestRepo harvestRepo;

    @Autowired
    public  PlantedRepo plantedRepo;

    public Map<String, List<PlantedResponse>> getPlantedPerFarmForSeason(String season) {
        List<Planted> planted = plantedRepo.findAllPlantedBySeason(season);
        Set<String> farmSet = new HashSet<>();
        planted.stream().forEach(x -> {
            farmSet.add(x.getFarm());
        });
        Map<String, List<PlantedResponse>> responseMap = new HashMap<>();
        farmSet.stream().forEach(x -> {
            List<PlantedResponse> farmPlantedList = new ArrayList<>();
            planted.stream().filter(y -> x.equals(y.getFarm()))
                    .forEach(z -> {
                        farmPlantedList.add(PlantedResponse.builder()
                                .plantingArea(z.getPlantingArea())
                                .cropType(z.getCropType())
                                .expectedAmount(z.getExpectedAmount())
                                .build());
                    });
            responseMap.put(x, farmPlantedList);
        });
         return responseMap;
    }

    public Map<String, List<HarvestResponse>> getHarvestByFarmForSeason(String season) {
        List<Harvest> harvest = harvestRepo.findAllHarvestBySeason(season);
        Set<String> farmSet = new HashSet<>();
        harvest.stream().forEach(x -> {
            farmSet.add(x.getFarm());
        });
        Map<String, List<HarvestResponse>> responseMap = new HashMap<>();
        farmSet.stream().forEach(x -> {
            List<HarvestResponse> farmHarvestList = new ArrayList<>();
            harvest.stream().filter(y -> x.equals(y.getFarm()))
                    .forEach(z -> {
                        HarvestResponse harvestResponse = new HarvestResponse();
                        harvestResponse.setCropType(z.getCropType());
                        harvestResponse.setAmountHarvested(z.getAmountHarvested());
                        farmHarvestList.add(harvestResponse);
                    });
            responseMap.put(x, farmHarvestList);
        });
        return responseMap;
    }
}
