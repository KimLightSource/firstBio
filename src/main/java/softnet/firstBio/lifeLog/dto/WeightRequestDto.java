package softnet.firstBio.lifeLog.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import softnet.firstBio.lifeLog.Entity.Gender;
import softnet.firstBio.lifeLog.Entity.Location;
import softnet.firstBio.lifeLog.Entity.Weight;
import softnet.firstBio.lifeLog.Entity.member.Member;

import javax.persistence.*;

@Getter
@NoArgsConstructor
public class WeightRequestDto {

    private Long id;
    private Member member;

    private Integer height;

    private Integer weight;

    private Integer bodyMass;

    private Integer bodyFat;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private Location location;

    public WeightRequestDto(Member member, Integer height, Integer weight, Integer bodyMass, Integer bodyFat, Gender gender, Location location) {
        this.member = member;
        this.height = height;
        this.weight = weight;
        this.bodyMass = bodyMass;
        this.bodyFat = bodyFat;
        this.gender = gender;
        this.location = location;
    }

    public Weight toEntity() {
        return Weight.builder()
                .height(height)
                .weight(weight)
                .bodyMass(bodyMass)
                .bodyFat(bodyFat)
                .gender(gender)
                .location(location)
                .build();
    }
}

