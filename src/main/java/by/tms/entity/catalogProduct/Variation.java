package by.tms.entity.catalogProduct;

/*
    @author Ilya Moiseenko on 19.11.23
*/

import by.tms.entity.AbstractEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_variation")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Variation extends AbstractEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "variation")
    private List<VariationOption> variationOptions;
}
