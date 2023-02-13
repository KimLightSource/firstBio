package softnet.firstBio.lifeLog.Entity.member;

import lombok.*;
import softnet.firstBio.lifeLog.Entity.BloodPressure;
import softnet.firstBio.lifeLog.Entity.BloodSugar;
import softnet.firstBio.lifeLog.Entity.Weight;

import javax.persistence.*;
import java.util.List;

@Entity(name="member")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(nullable = false, unique = true, length = 30)
    private String username;

    @Column(nullable = false, length = 100)
    private String password;

    @OneToMany(mappedBy = "member")
    private List<Weight> weight;

    @OneToMany(mappedBy = "member")
    private List<BloodPressure> bloodPressure;

    @OneToMany(mappedBy = "member")
    private List<BloodSugar> bloodSugar;

}
