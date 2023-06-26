package ru.shrf.testjob.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "ClientResponsDTO")
public class ClientResponsDTO {
    private UUID uuid;
    private String name;
    private Integer discountOne;
    private Integer discountTwo;
}
