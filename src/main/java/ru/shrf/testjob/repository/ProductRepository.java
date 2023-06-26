package ru.shrf.testjob.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.shrf.testjob.entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("productRepositoryBean")

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select distinct p from products p where p.uuid = ?1")
    Optional<Product> findByUUID(UUID uuid);
}
