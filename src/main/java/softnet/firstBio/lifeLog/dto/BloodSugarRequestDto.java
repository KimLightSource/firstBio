package softnet.firstBio.lifeLog.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import softnet.firstBio.lifeLog.Entity.BSStatus;
import softnet.firstBio.lifeLog.Entity.BloodSugar;
import softnet.firstBio.lifeLog.Entity.Insulin;
import softnet.firstBio.lifeLog.Entity.MeasurementLocation;
import softnet.firstBio.lifeLog.Entity.member.Member;

import javax.persistence.*;

@Getter
@NoArgsConstructor
public class BloodSugarRequestDto {

    private Long id;
    private Member member;
    private Integer bs; // 혈당수치
    @Enumerated(EnumType.STRING)
    private BSStatus bsstatus; // EMPTY, TWO_HOUR_AFTER, BEFORE_SLEEP
    @Enumerated(EnumType.STRING)
    private Insulin insulin; // Y, N
    @Enumerated(EnumType.STRING)
    private MeasurementLocation measurementLocation; // HOME, HOSPITAL, JOB, ETC

    @Builder
    public BloodSugarRequestDto(Integer bs, BSStatus bsstatus, Insulin insulin, MeasurementLocation measurementLocation) {
        this.bs = bs;
        this.bsstatus = bsstatus;
        this.insulin = insulin;
        this.measurementLocation = measurementLocation;
    }

    public BloodSugar toEntity() {
        return BloodSugar.builder()
                .bs(bs)
                .bsstatus(bsstatus)
                .insulin(insulin)
                .measurementLocation(measurementLocation)
                .build();
    }

}
