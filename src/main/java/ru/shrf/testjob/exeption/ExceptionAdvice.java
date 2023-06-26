package ru.shrf.testjob.exeption;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.shrf.testjob.dto.ExeptionResponsDTO;


@ControllerAdvice
@Slf4j
@ResponseBody
public class ExceptionAdvice {

    @ExceptionHandler(BusinessException.class)
    public ExeptionResponsDTO handleBusinessException(BusinessException e) {
        log.error("Business error", e);
        return new ExeptionResponsDTO("Business error", e.getMessage());
    }

    @ExceptionHandler(ValidationException.class)
    public ExeptionResponsDTO handleValidationException(ValidationException e) {
        log.error("Validation error", e);
        return new ExeptionResponsDTO("Validation error", e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ExeptionResponsDTO handleException(Exception e) {
        log.error("Internal error", e);
        return new ExeptionResponsDTO("Internal error", e.getMessage());
    }



}
