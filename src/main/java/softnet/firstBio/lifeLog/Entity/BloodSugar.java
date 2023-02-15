package softnet.firstBio.lifeLog.Entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import softnet.firstBio.lifeLog.Entity.member.Member;

import javax.persistence.*;
import java.time.LocalDateTime;

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
