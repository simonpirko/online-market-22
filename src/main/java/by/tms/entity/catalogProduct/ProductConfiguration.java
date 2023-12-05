package by.tms.entity.catalogProduct;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<VariationOption> variationOptions;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "promotion_id", referencedColumnName = "id")
    private Promotion promotion;

}
