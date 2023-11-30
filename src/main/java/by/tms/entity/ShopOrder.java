
package by.tms.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_shop_order")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ShopOrder extends AbstractEntity{

    private Long shop_id;
    private Long shopping_cart_id;
    private LocalDate order_date;
    private Long payment_method_id;
    private Long shipping_address_id;
    private Long shipping_method_id;
    private Long order_status_id;
}


