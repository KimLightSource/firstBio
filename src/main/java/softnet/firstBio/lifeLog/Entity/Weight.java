package softnet.firstBio.lifeLog.Entity;

import lombok.Data;
import softnet.firstBio.lifeLog.Entity.member.Member;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Weight {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "member_id")
    private Member member;

    private LocalDateTime dateTime;

    private Integer height;

    private Integer weight;

    private Integer bodyMass;

    private Integer bodyFat;

    @Enumerated(EnumType.STRING)
    private Gender gender;
}
