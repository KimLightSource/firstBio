package softnet.firstBio.lifeLog.dto;

import lombok.Data;
import softnet.firstBio.lifeLog.Entity.BloodSugar;
import softnet.firstBio.lifeLog.Entity.Insulin;
import softnet.firstBio.lifeLog.Entity.MeasurementLocation;
import softnet.firstBio.lifeLog.Entity.member.Member;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@Data
public class BloodSugarResponseDto {
    private Long id;
    private LocalDateTime dateTime;
    private Member member;
    private Integer BS; // 혈당수치
    @Enumerated(EnumType.STRING)
    private softnet.firstBio.lifeLog.Entity.BSStatus BSStatus; // EMPTY, TWO_HOUR_AFTER, BEFORE_SLEEP
    @Enumerated(EnumType.STRING)
    private Insulin insulin; // Y, N
    @Enumerated(EnumType.STRING)
    private MeasurementLocation measurementLocation; // HOME, HOSPITAL, JOB, ETC

    public BloodSugarResponseDto(BloodSugar entity) {
        this.id = entity.getId();
        this.dateTime = entity.getCreatedDate();
        this.member = entity.getMember();
        this.BS = entity.getBs();
        this.BSStatus = entity.getBsstatus();
        this.insulin = entity.getInsulin();
        this.measurementLocation = entity.getMeasurementLocation();
    }
}
