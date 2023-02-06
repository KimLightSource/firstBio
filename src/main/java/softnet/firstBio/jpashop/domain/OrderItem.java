package softnet.firstBio.jpashop.domain;

import lombok.Getter;
import lombok.Setter;
import softnet.firstBio.jpashop.domain.Item.Item;

import javax.persistence.*;

@Entity
@Getter @Setter
public class OrderItem {
    @Id @GeneratedValue
    @Column(name= "order_item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name= "order_id")
    private Order order;

    private int orderPrice;
    private int count;
}
