package ru.shrf.testjob.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity(name = "products")
@Table(name = "products")
@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "uuid")
    private UUID uuid;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Long price;
    @Column(name = "description")
    private String description;
    @Column(name = "discount")
    private Integer discount;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<ProductRating> ratings;

}
