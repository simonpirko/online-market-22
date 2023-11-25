package by.tms.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_promotion")
public class Promotion extends AbstractEntity{

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", unique = true)
    private String description;

    @Column(name = "discount_rate", nullable = false)
    private int discountRate;

    @Column(name = "start date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;
}
