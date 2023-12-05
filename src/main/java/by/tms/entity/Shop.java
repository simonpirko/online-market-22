package by.tms.entity;

import by.tms.entity.address.Address;
import by.tms.entity.catalogProduct.Product;
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
    public String name;

   @OneToMany(fetch = FetchType.EAGER)
    public List<Address> shopAddresses;

   @ManyToMany(fetch = FetchType.EAGER)
    public List<Product> product;


    @Enumerated(EnumType.STRING)
    @Column(name = "shipping_method")
    private ShippingMethod shippingMethod;

    @ManyToOne
    @JoinColumn(name="shop_id",referencedColumnName = "user_id")
    public  User user;
}
