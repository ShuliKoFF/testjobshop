package ru.shrf.testjob.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.shrf.testjob.entity.ProductRating;

import java.util.List;
import java.util.Optional;

@Repository("ProductRatingtRepositoryBean")
public interface ProductRatingRepository extends JpaRepository<ProductRating, Long> {
    @Query(value = "select r from product_ratings r where r.product.id = ?1")
    List<ProductRating> findAllByProductId(Long id);

    @Query(value = "select r from product_ratings r where r.clientId = ?1 and r.product.id = ?2")
    Optional<ProductRating> findByClientAndProduct(Long clientId, Long productId);
}
