package by.tms.entity.cardpayment;
import by.tms.entity.AbstractEntity;
import by.tms.entity.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@Table(name = "tb_card_payment")
@Entity
public class CardPayment extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "card_payment_id", referencedColumnName = "payment_method_id")
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    private CardType cardType;

    @Column(name = "provider")
    private String provider;

    @Column(name = "account_number", unique = true, nullable = false)
    private String accountNumber;

    @Column(name = "expire_date")
    private LocalDate expireDate;

    @Column(name = "is_default")
    private boolean isDefault;
}
