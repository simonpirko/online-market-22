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
public class Shop extends AbstractEntity{

   @Column(name = "name")
    public String name;

   @OneToMany
   @JoinColumn()
    public String shopAddressId;
    public String productConfigurationId;
    public String shippingMethodsId;
    public String userOwner;

    @ManyToOne
    @JoinColumn(name="shop_id",referencedColumnName = "user_id")
    public  User user;
}
