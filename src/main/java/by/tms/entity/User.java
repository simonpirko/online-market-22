package by.tms.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.management.relation.Role;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@Table(name = "tb_user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="user_type")
@Entity
public  class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email_address;
    private String phone_number;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;


    @OneToMany
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    public List<Shop> ownedShop;


}




