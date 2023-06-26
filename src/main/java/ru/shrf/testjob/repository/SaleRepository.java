package ru.shrf.testjob.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.shrf.testjob.entity.Sale;

import java.util.Date;
import java.util.List;

@Repository("saleRepositoryBean")
public interface SaleRepository extends JpaRepository<Sale, Long> {
    @Query(value = "SELECT s FROM sales s where s.clientId = ?1")
    List<Sale> getAllSaleByClient(Long clientId);

    @Query(value = "SELECT setval('CHECK_NUMBER_SEQ', ?1, false)", nativeQuery = true)
    void resetCheckNumber(Integer checkNumberBase);

    Sale findFirstByOrderByIdDesc();

}