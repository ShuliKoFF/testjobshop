package ru.shrf.testjob.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.shrf.testjob.services.SaleService;


@Slf4j
@Service
@EnableScheduling
@EnableAsync
//@RequiredArgsConstructor
public class SchedulerCheckNumber {
    private final SaleService saleService;

    public SchedulerCheckNumber(SaleService saleService) {
        this.saleService = saleService;
        int result = saleService.compareNowWithLastDateSale();
        if (result>0) saleService.resetCheckNumber();
    }

    @Scheduled(cron = "${scheduler.cron.changeCheckNumber}")
    public void resetCheckNumber() {
        saleService.resetCheckNumber();
        log.info("Receipt number current updated to base");
    }
}
