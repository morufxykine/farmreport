package org.farm.collector;

import org.farm.collector.entity.Harvest;
import org.farm.collector.entity.Planted;
import org.farm.collector.model.CropType;
import org.farm.collector.repo.HarvestRepo;
import org.farm.collector.repo.PlantedRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FarmcollectorApplication implements CommandLineRunner {

	@Autowired
	private PlantedRepo plantedRepo;
	@Autowired
	private HarvestRepo harvestRepo;

	public static void main(String[] args) {
		SpringApplication.run(FarmcollectorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Planted planted1 = Planted.builder()
				.farm("myFarm1")
				.cropType(CropType.CORN)
				.plantingArea(100L)
				.expectedAmount(7000L)
				.season("2021/2022")
				.build();

		Planted planted2 = Planted.builder()
				.farm("myFarm2")
				.cropType(CropType.POTATOES)
				.plantingArea(200L)
				.expectedAmount(6000L)
				.season("2021/2022")
				.build();

		Harvest harvest1 = Harvest.builder()
				.farm("myFarm1")
				.cropType(CropType.CORN)
				.plantingArea(100L)
				.amountHarvested(6500L)
				.season("2021/2022")
				.build();

		Harvest harvest2 = Harvest.builder()
				.farm("myFarm2")
				.cropType(CropType.CORN)
				.plantingArea(100L)
				.amountHarvested(8210L)
				.season("2021/2022")
				.build();

		plantedRepo.save(planted1);
		plantedRepo.save(planted2);
		harvestRepo.save(harvest1);
		harvestRepo.save(harvest2);
	}

}
