package softnet.firstBio.lifeLog.Entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class BloodSugar {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name= "patient_id")
    private Patient patient;

    private Integer BS; // 혈당수치

    private LocalDateTime dateTime;

    @Enumerated(EnumType.STRING)
    private BSStatus BDstatus; // EMPTY, TWO_HOUR_AFTER, BEFORE_BEDTIME

    @Enumerated(EnumType.STRING)
    private Insulin insulin; // Y, N

    @Enumerated(EnumType.STRING)
    private MeasurementLocation measurementLocation; // HOME, HOSPITAL, JOB, ETC

}
