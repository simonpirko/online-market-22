package by.tms.entity.catalogProduct;

/*
    @author Ilya Moiseenko on 19.11.23
*/

import by.tms.entity.AbstractEntity;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "tb_product")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "product_category_id", referencedColumnName = "id")
    private ProductCategory category;

    @OneToMany
    private List<Variation> variations;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "part_number",  nullable = false, unique = true)
    private String partNumber;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "image", nullable = false)
    private byte[] image;
}
