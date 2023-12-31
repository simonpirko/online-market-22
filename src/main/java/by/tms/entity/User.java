package by.tms.entity;

import by.tms.entity.address.UserAddress;
import by.tms.entity.cardpayment.CardPayment;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@Table(name = "tb_user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="user_type")
@Entity
public  class User extends AbstractEntity {


    @Column(name = "user_name", nullable = false)
    private String username;

    @Column(name = "email_address", nullable = false)
    private String emailAddress;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "password", nullable = false)
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Set<Role> role = new HashSet<>();


    @OneToMany
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private List<Shop> ownedShop;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shopping_cart", referencedColumnName = "id")
    private ShoppingCart shoppingCart;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_address", referencedColumnName = "id")
    private UserAddress userAddress;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Review> reviewsList;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private List<CardPayment> cardPaymentsList;
}


