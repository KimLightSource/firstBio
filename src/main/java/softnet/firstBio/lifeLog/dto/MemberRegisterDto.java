package softnet.firstBio.lifeLog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class MemberRegisterDto {
    private final String uid;
    private final String email;
    private final String username;
    private final String password;


}
