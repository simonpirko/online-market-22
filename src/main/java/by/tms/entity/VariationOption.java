package by.tms.entity;

/*
    @author Ilya Moiseenko on 19.11.23
*/

import javax.persistence.*;

@Entity
@Table(name = "tb_variation_option")
public class VariationOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value", unique = true, nullable = false)
    private String value;

    @ManyToOne
    @JoinColumn(name = "variation_id", referencedColumnName = "id")
    private Variation variation;
}
