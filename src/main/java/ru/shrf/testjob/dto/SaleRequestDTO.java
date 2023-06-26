package ru.shrf.testjob.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Map;
import java.util.UUID;

@Data
@XmlRootElement(name = "SaleRequestDTO")
public class SaleRequestDTO {
    private UUID clientUUID;
    private Map<UUID, Integer> cart;
    private Long price;
}
