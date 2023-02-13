package softnet.firstBio.lifeLog.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import softnet.firstBio.lifeLog.Entity.BloodPressure;
import softnet.firstBio.lifeLog.Entity.DrugField;
import softnet.firstBio.lifeLog.Entity.Location;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class BloodPressureRequestDto {
    private LocalDateTime dateTime;
    private Integer maxBp;
    private Integer minBp;
    private Integer pulse;
    @Enumerated(EnumType.STRING)
    private Location location;
    @Enumerated(EnumType.STRING)
    private DrugField drugField;

    @Builder
    public BloodPressureRequestDto(LocalDateTime dateTime, Integer maxBp, Integer minBp, Integer pulse, Location location, DrugField drugField) {
        this.dateTime = dateTime;
        this.maxBp = maxBp;
        this.minBp = minBp;
        this.pulse = pulse;
        this.location = location;
        this.drugField = drugField;
    }

    public BloodPressure toEntity() {
        return BloodPressure.builder()
                .maxBp(maxBp)
                .minBp(minBp)
                .dateTime(dateTime)
                .pulse(pulse)
                .location(location)
                .drugField(drugField)
                .build();
    }
}