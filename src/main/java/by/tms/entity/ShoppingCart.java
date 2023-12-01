package by.tms.entity;

import lombok.*;

import javax.persistence.*;

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

}
