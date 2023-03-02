package softnet.firstBio.lifeLog.dto;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import softnet.firstBio.lifeLog.Entity.member.Member;
@Getter
@Setter
@EqualsAndHashCode
public class MemberRegisterResponseDto {
    private Long id;
    private String uid;
    private String email;
    private String username;
    private String password;


    public MemberRegisterResponseDto(Member member) {
        this.id = member.getId();
        this.email = member.getEmail();
        this.uid = member.getUid();
        this.password = member.getPassword();
        this.username = member.getUsername();
    }

}
