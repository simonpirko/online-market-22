package by.tms.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class SingleShopUser extends User{

    @OneToMany
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private List<Shop> ownedShop;


}
