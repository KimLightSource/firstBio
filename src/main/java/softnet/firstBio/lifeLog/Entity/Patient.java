package softnet.firstBio.lifeLog.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
public class Patient {
    @Id
    @GeneratedValue
    @Column(name = "patient_id")
    private Long id;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "patient")
    private List<Weight> weight;

    @OneToMany(mappedBy = "patient")
    private List<BloodPressure> bloodPressure;

    @OneToMany(mappedBy = "patient")
    private List<BloodSugar> bloodSugar;

}
