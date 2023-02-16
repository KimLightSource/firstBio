package softnet.firstBio.lifeLog.Entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import softnet.firstBio.lifeLog.Entity.member.Member;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Weight extends BaseEntity{

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "member_username")
    private Member member;

    private Integer height;

    private Integer weight;

    private Integer bodyMass;

    private Integer bodyFat;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private Location location;
}
