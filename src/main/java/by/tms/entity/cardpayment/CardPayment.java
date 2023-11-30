package by.tms.entity.cardpayment;

import jdk.jfr.Enabled;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Table(name = "tb_card_payment")
@Entity
public class CardPayment extends AbstractEntity{

    @Column(name = "user_id")
    @OneToMany
    @JoinColumn(name = "id", referencedColumnName = "card_id")
    private User user;

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
