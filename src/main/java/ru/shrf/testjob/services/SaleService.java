package ru.shrf.testjob.services;

import ru.shrf.testjob.dto.StatisticResponseDTO;

import java.util.Map;
import java.util.UUID;

public interface SaleService {
    Long getFinalPrice(UUID clientUUID, Map<UUID, Integer> cart);

    String registerSale(UUID clientUUID, Map<UUID, Integer> cart, Long price);

    StatisticResponseDTO getStatistic(UUID clientUUID, UUID productUUID);

    void resetCheckNumber();

    Integer compareNowWithLastDateSale();
}
