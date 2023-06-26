package ru.shrf.testjob.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "sales")
@Table(name = "sales")
@Getter
@Setter
@ToString(exclude = {"positions", "clientId"})
@NoArgsConstructor
public class Sale {

    public Sale(Long clientId, List<Position> positions) {
        date = LocalDateTime.now();
        this.clientId = clientId;
        this.positions = positions;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date")
    private LocalDateTime date;
    @Generated(GenerationTime.INSERT)
    @Column(name = "check_number")
    private Integer checkNumber;
    @Column(name = "client_id")
    private Long clientId;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sale")
    private List<Position> positions;

}
