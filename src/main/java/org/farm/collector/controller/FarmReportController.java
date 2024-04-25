package org.farm.collector.controller;


import org.farm.collector.apiresponse.HarvestResponse;
import org.farm.collector.apiresponse.PlantedResponse;
import org.farm.collector.entity.Harvest;
import org.farm.collector.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/report")
public class FarmReportController {

    @Autowired
    public ReportService reportService;

    @GetMapping("/planted/season")
    public ResponseEntity<?> getPlantedPerFarm(@RequestParam(required = true) String session) {
        Map<String, List<PlantedResponse>> response = reportService.getPlantedPerFarmForSeason(session);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/harvest/season")
    public ResponseEntity<?> getHarvestByFarm(@RequestParam(required = true) String session) {
        Map<String, List<HarvestResponse>> response = reportService.getHarvestByFarmForSeason(session);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
