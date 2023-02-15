package softnet.firstBio.lifeLog.dto;

import lombok.Data;
import softnet.firstBio.lifeLog.Entity.BloodPressure;
import softnet.firstBio.lifeLog.Entity.DrugField;
import softnet.firstBio.lifeLog.Entity.Location;
import softnet.firstBio.lifeLog.Entity.member.Member;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class BloodPressureResponseDto {
    private Long id;
    private LocalDateTime dateTime;
    private Integer maxBp;
    private Integer minBp;
    private Integer pulse;
    private Location location;
    private DrugField drugField;

    public BloodPressureResponseDto(BloodPressure entity) {
        this.id = entity.getId();
        this.dateTime = entity.getCreatedDate();
        this.maxBp = entity.getMaxBp();
        this.minBp = entity.getMinBp();
        this.pulse = entity.getPulse();
        this.location = entity.getLocation();
        this.drugField = entity.getDrugField();
    }
}
