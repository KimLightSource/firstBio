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
public class BloodSugar {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "member_id")
    private Member member;

    private Integer BS; // 혈당수치

    private LocalDateTime dateTime;

    @Enumerated(EnumType.STRING)
    private BSStatus BDstatus; // EMPTY, TWO_HOUR_AFTER, BEFORE_BEDTIME

    @Enumerated(EnumType.STRING)
    private Insulin insulin; // Y, N

    @Enumerated(EnumType.STRING)
    private MeasurementLocation measurementLocation; // HOME, HOSPITAL, JOB, ETC

}
