package softnet.firstBio.lifeLog.Entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Weight {

    @Id
    @GeneratedValue
    @Column(name = "weight_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "patient_id")
    private Patient patient;

    private LocalDateTime dateTime;

    private Integer height;

    private Integer weight;

    private Integer bodyMass;

    private Integer bodyFat;

    @Enumerated(EnumType.STRING)
    private Gender gender;
}
