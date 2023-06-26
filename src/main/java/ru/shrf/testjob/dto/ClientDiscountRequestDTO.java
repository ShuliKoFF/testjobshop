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
@XmlRootElement(name = "ClientDiscountRequestDTO")
public class ClientDiscountRequestDTO {
    private UUID uuid;
    private Integer discountOne;
    private Integer discountTwo;
}
