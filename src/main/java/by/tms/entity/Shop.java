package by.tms.entity;

import by.tms.entity.address.Address;
import by.tms.entity.product.Product;
import by.tms.entity.shopOrder.ShippingMethod;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_shop" )
@Getter
@Setter
@ToString
public class Shop extends AbstractEntity{

   @Column(name = "name")
    private String name;

   @OneToMany
    private List<Address> shopAddresses;

   @ManyToMany(fetch = FetchType.EAGER)
    private List<Product> product;


    @Enumerated(EnumType.STRING)
    @Column(name = "shipping_method")
    private ShippingMethod shippingMethod;

    @ManyToOne
    @JoinColumn(name="shop_id",referencedColumnName = "id")
    private   User user;
}
