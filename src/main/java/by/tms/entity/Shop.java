package by.tms.entity;

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
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name;
    public String shop_address_id;
    public String product_configuration_id;
    public String shipping_methods_id;
    public String user_owner;

    @ManyToOne
    @JoinColumn(name="shop_id",referencedColumnName = "user_id")
    public  User user;
}
