package softnet.firstBio.lifeLog.Entity;

import lombok.*;
import softnet.firstBio.lifeLog.Entity.member.Member;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BloodPressure {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "member_id")
    private Member member;

    private LocalDateTime dateTime;

    private Integer maxBp;
    private Integer minBp;
    private Integer pulse;
    @Enumerated(EnumType.STRING)
    private Location location;
    @Enumerated(EnumType.STRING)
    private DrugField drugField;



}
