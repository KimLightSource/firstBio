package softnet.firstBio.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Embedded
    private Address adress;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
}
