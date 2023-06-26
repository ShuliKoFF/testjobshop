package ru.shrf.testjob.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "StatisticResponseDTO")
public class StatisticResponseDTO {
    private Integer quantityChecks;
    private Long amountOnChecks;
    private Long amountDiscounts;
}
