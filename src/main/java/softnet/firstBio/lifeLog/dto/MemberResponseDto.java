package softnet.firstBio.lifeLog.dto;

import lombok.Data;
import softnet.firstBio.lifeLog.Entity.member.Member;

@Data
public class MemberResponseDto {
    private Long id;
    private String username;
    private String password;
    public MemberResponseDto(Member entity) {
        this.id = entity.getId();
        this.username = entity.getUsername();
        this.password = entity.getPassword();
    }
}
