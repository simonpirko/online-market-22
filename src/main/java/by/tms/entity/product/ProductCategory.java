package by.tms.entity.product;

/*
    @author Ilya Moiseenko on 19.11.23
*/

import by.tms.entity.AbstractEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_product_category")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategory extends AbstractEntity {

    @Column(name = "category_name", unique = true, nullable = false)
    private String categoryName;

    @OneToMany
    private List<Variation> variations;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
