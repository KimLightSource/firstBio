package softnet.firstBio.lifeLog.dto;

import lombok.Data;
import softnet.firstBio.lifeLog.Entity.Gender;
import softnet.firstBio.lifeLog.Entity.Location;
import softnet.firstBio.lifeLog.Entity.Weight;
import softnet.firstBio.lifeLog.Entity.member.Member;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
public class WeightResponseDto {
    private Long id;
    private Integer height;
    private LocalDateTime dateTime;
    private Integer weight;

    private Integer bodyMass;

    private Integer bodyFat;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Location location;


    public WeightResponseDto(Weight entity) {
        this.id = entity.getId();
        this.dateTime = entity.getCreatedDate();
        this.height = entity.getHeight();
        this.weight = entity.getWeight();
        this.bodyMass = entity.getBodyMass();
        this.bodyFat = entity.getBodyFat();
        this.gender = entity.getGender();
        this.location = entity.getLocation();
    }
}
