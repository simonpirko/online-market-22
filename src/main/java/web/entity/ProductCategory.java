package web.entity;

/*
    @author Ilya Moiseenko on 19.11.23
*/

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "tb_product_category")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name", unique = true, nullable = false)
    private String categoryName;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @OneToMany
    private List<Variation> variations;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
