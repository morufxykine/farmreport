package org.farm.collector.repo;

import org.farm.collector.entity.Harvest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HarvestRepo extends JpaRepository<Harvest, String> {
    List<Harvest> findAllHarvestBySeason(String season);
}
