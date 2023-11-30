package by.tms.entity.cardpayment;

import by.tms.entity.AbstractEntity;
import by.tms.entity.Shop;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Table(name = "tb_payment_method")
@Entity
public class PaymentMethod extends AbstractEntity {

    @Column(name = "name", unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentMethodEnum paymentMethodEnum;

    @ManyToMany
    @JoinColumn(name="shop_id",referencedColumnName = "id")
    public Shop shop;


}
