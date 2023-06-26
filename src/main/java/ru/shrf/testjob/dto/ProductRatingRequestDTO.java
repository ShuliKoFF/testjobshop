package ru.shrf.testjob.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.UUID;

@Data
@XmlRootElement(name = "ProductRatingRequestDTO")
public class ProductRatingRequestDTO {
    private UUID clientUUID;
    private UUID productUUID;
    private Integer rating;
}
