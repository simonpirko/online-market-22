package web.controller.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "tb_user_review")
@Getter
@Setter
@Builder
@ToString
public class Review {
    public Review() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


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
