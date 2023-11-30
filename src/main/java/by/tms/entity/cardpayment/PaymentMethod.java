package by.tms.entity.cardpayment;

import by.tms.entity.AbstractEntity;
import by.tms.entity.Shop;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@ToString
@Table(name = "tb_payment_method")
@Entity
public class PaymentMethod extends AbstractEntity {

    @Column(name = "name", unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<PaymentMethodEnum> paymentMethodEnum;

    @ManyToOne
    @JoinColumn(name="shop_id",referencedColumnName = "id")
    public Shop shop;


}
