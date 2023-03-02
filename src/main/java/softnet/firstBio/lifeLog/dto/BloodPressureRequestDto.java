package softnet.firstBio.lifeLog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import softnet.firstBio.lifeLog.Entity.BloodPressure;
import softnet.firstBio.lifeLog.Entity.DrugField;
import softnet.firstBio.lifeLog.Entity.Location;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BloodPressureRequestDto {
    private Integer maxBp;
    private Integer minBp;
    private Integer pulse;
    @Enumerated(EnumType.STRING)
    private Location location;
    @Enumerated(EnumType.STRING)
    private DrugField drugField;

    public BloodPressure toEntity() {
        return BloodPressure.builder()
                .maxBp(maxBp)
                .minBp(minBp)
                .pulse(pulse)
                .location(location)
                .drugField(drugField)
                .build();
    }
}
