package org.farm.collector.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.farm.collector.model.CropType;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Planted {
    @Id
    private String farm;
    private CropType cropType;
    private Long plantingArea;
    private Long expectedAmount;
    private String season;;
}
