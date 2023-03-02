package softnet.firstBio.lifeLog.Entity.member;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import softnet.firstBio.lifeLog.Entity.BloodPressure;
import softnet.firstBio.lifeLog.Entity.BloodSugar;
import softnet.firstBio.lifeLog.Entity.Weight;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity(name="member")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Lob
    private String uid;

    @Column(nullable = false, unique = true, length = 30)
    private String email;

    @Column(nullable = false, length = 100)
    private String username;

    @Column(nullable = false, length = 100)
    private String password;

    @OneToMany(mappedBy = "member")
    private List<Weight> weight;

    @OneToMany(mappedBy = "member")
    private List<BloodPressure> bloodPressure;

    @OneToMany(mappedBy = "member")
    private List<BloodSugar> bloodSugar;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
