package ru.shrf.testjob.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "ProductInfoResponsDTO")
public class ProductInfoResponsDTO {
    private String description;
    private BigDecimal averageRating;
    private Map<Integer, Long> distributionOfRating;
    private Integer currentRating;
}
