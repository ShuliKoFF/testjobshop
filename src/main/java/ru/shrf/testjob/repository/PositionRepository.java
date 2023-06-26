package ru.shrf.testjob.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.shrf.testjob.entity.Position;

import java.util.List;

@Repository("positionRepositoryBean")
public interface PositionRepository extends JpaRepository<Position, Long> {

    @Query(value = "SELECT p " +
            "FROM  positions p " +
            "where p.sale.clientId=?1 and p.productId = ?2")
    List<Position> getAllByClientAndProduct(Long clientId, Long productId);

    @Query(value = "SELECT p " +
            "FROM  positions p " +
            "where p.productId = ?1")
    List<Position> getAllPositionByProduct(Long id);


    @Query(value = "SELECT p " +
            "FROM  positions p " +
            "where p.sale.clientId=?1")
    List<Position> getAllPositionByClient(Long id);
}
