package softnet.firstBio.lifeLog.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class MemberLoginDto {
    String uid;
    String password;
}
