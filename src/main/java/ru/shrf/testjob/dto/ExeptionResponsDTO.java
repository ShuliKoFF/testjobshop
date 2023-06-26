package ru.shrf.testjob.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Builder
@AllArgsConstructor
@XmlRootElement(name = "ExeptionResponsDTO")
public class ExeptionResponsDTO {
    private final String error;
    private final String message;

}
