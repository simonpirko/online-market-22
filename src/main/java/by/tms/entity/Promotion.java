package by.tms.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor

@Entity
@Table(name = "tb_promotion")
public class Promotion extends AbstractEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", unique = true)
    private String description;

    @Column(name = "discount_rate", nullable = false)
    private int discountRate;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;
}
