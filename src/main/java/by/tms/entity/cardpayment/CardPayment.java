package by.tms.entity.cardpayment;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Table(name = "tb_card_payment")
@Entity
public class CardPayment extends AbstractEntity{

    @OneToMany
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany
    @JoinColumn(name = "card_payment_id", referencedColumnName = "payment_method_id")
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    private CardType cardType;

    @Column(name = "provider")
    private String provider;

    @Column(name = "account_number", unique = true, nullable = false)
    private String accountNumber;

    @Column(name = "expire_date")
    private String expireDate;

    @Column(name = "is_default")
    private boolean isDefault;
}
