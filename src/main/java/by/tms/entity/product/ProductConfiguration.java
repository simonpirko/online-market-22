package by.tms.entity.product;

import by.tms.entity.AbstractEntity;
import by.tms.entity.Promotion;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_product_configuration")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductConfiguration extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @ManyToMany
    private List<VariationOption> variationOptions;

    @ManyToOne
    @JoinColumn(name = "promotion_id", referencedColumnName = "id")
    private Promotion promotion;

}
