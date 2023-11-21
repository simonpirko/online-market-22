package by.tms.entity;

/*
    @author Ilya Moiseenko on 19.11.23
*/

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_variation")
public class Variation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "variation")
    private List<VariationOption> variationOptions;
}
