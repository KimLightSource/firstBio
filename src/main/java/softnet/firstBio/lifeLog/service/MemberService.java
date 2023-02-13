package softnet.firstBio.lifeLog.service;

import softnet.firstBio.lifeLog.Entity.member.Member;

public interface MemberService {
    void createMember(Member member);

    Member getMember(Long id);

}
