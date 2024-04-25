package org.farm.collector.repo;

import org.farm.collector.entity.Planted;
import org.farm.collector.model.CropType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlantedRepo  extends JpaRepository<Planted, String> {
    List<Planted> findAllPlantedBySeason(String season);
}
