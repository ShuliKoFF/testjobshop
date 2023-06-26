package ru.shrf.testjob.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Map;
import java.util.UUID;

@Data
@XmlRootElement(name = "FinalPriceRequestDTO")
public class FinalPriceRequestDTO {
    private UUID clientUUID;
    private Map<UUID, Integer> cart;
}

