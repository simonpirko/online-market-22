package by.tms.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tb_user_review")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Review extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


    @OneToOne
    @JoinColumn(name = "shop_order_id", referencedColumnName = "id")
    private ShopOrder shopOrder;


    @ManyToOne
    @JoinColumn(name = "shop_id", referencedColumnName = "id")
    private Shop shop;


    @Column(name = "rating_value", nullable = false)
    private int ratingValue;


    @Column(name = "comment")
    private String comment;

}
