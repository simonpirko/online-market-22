package by.tms.entity;

import by.tms.entity.product.ProductConfiguration;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_shopping_cart")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCart extends AbstractEntity{

    @OneToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToMany(cascade =CascadeType.ALL)
    private List<ProductConfiguration> productsInShoppingCart;


}
