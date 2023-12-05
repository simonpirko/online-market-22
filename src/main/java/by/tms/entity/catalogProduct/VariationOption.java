package by.tms.entity.catalogProduct;

/*
    @author Ilya Moiseenko on 19.11.23
*/

import by.tms.entity.AbstractEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tb_variation_option")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class VariationOption extends AbstractEntity {

    @Column(name = "value", unique = true, nullable = false)
    private String value;

    @ManyToOne
    @JoinColumn(name = "variation_id", referencedColumnName = "id")
    private Variation variation;
}
