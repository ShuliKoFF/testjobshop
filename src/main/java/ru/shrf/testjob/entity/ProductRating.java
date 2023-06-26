package ru.shrf.testjob.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "product_ratings")
@Table(name = "product_ratings")
@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "rating")
    private Integer rating;
    @Column(name = "client_id")
    private Long clientId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

}
