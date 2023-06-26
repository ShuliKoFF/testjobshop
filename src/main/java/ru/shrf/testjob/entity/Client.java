package ru.shrf.testjob.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "clients")
@Table(name = "clients")
@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Client{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "uuid")
    private UUID uuid;
    @Column(name = "name")
    private String name;
    @Column(name = "discount_one")
    private Integer discountOne;
    @Column(name = "discount_two")
    private Integer discountTwo;

}
