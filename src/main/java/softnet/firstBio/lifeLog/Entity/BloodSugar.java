package softnet.firstBio.lifeLog.Entity;

import lombok.*;
import softnet.firstBio.lifeLog.Entity.member.Member;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BloodSugar extends BaseEntity {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "member_username")
    private Member member;

    private Integer bs; // 혈당수치

    @Enumerated(EnumType.STRING)
    private BSStatus bsstatus; // EMPTY, TWO_HOUR_AFTER, BEFORE_SLEEP

    @Enumerated(EnumType.STRING)
    private Insulin insulin; // Y, N

    @Enumerated(EnumType.STRING)
    private MeasurementLocation measurementLocation; // HOME, HOSPITAL, JOB, ETC


}
