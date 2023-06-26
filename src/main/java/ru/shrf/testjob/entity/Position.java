package ru.shrf.testjob.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "positions")
@Table(name = "positions")
@Builder
@Getter
@Setter
@ToString(exclude = {"sale"})
@NoArgsConstructor
@AllArgsConstructor
public class Position{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "price_for_quantity")
    private Long priceForQuantity;
    @Column(name="final_price")
    private Long finalPrice;
    @Column(name = "final_discount")
    private Integer finalDiscount;
    @Column(name = "product_id")
    private Long productId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sale_id")
    private Sale sale;



}
