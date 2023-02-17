package softnet.firstBio.lifeLog.Entity;

import lombok.*;
import softnet.firstBio.lifeLog.Entity.member.Member;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BloodPressure extends BaseEntity{
    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "member_username")
    private Member member;
    private Integer maxBp;
    private Integer minBp;
    private Integer pulse;
    @Enumerated(EnumType.STRING)
    private Location location;
    @Enumerated(EnumType.STRING)
    private DrugField drugField;

}
