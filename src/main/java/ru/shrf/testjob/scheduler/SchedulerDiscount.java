package ru.shrf.testjob.scheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.shrf.testjob.services.ProductService;

@Slf4j
@Service
@EnableScheduling
@EnableAsync
@RequiredArgsConstructor
public class SchedulerDiscount {
    private final ProductService productService;
    @Value("${scheduler.changeDiscoutMin}")
    private int discoutMin;
    @Value("${scheduler.changeDiscoutMax}")
    private int discoutMax;
    @Scheduled(cron = "${scheduler.cron.changeDiscount}")
    public void updateDiscount() {
        productService.updateDiscountInRangeRandom(discoutMin, discoutMax);
    }

}
