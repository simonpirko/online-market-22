package by.tms.entity.cardpayment;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "card_type")
public class PaymentCardType {

    @Id
    @Column(name = "card_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type", unique = true, nullable = false)
    private String type;
}
