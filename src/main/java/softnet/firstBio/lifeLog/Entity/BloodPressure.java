package softnet.firstBio.lifeLog.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class BloodPressure {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name= "patient_id")
    private Patient patient;


}
