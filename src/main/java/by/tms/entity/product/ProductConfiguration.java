package by.tms.entity.product;

import by.tms.entity.AbstractEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
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

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Product> products;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<VariationOption> variationOptions;

}
