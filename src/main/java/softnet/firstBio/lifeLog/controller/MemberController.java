package softnet.firstBio.lifeLog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import softnet.firstBio.lifeLog.Entity.member.Member;
import softnet.firstBio.lifeLog.repo.MemberRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/member")
public class MemberController {

    private final MemberRepository memberRepository;


    @GetMapping()
    public List<Member> findAllMember() {
        return memberRepository.findAll();
    }

    @PostMapping()
    public Member signUp() {
        final Member member = Member.builder()
                .username("testMember")
                .password("1234")
                .build();
        return memberRepository.save(member);
    }

    @PostMapping("login")
    Void login(
            HttpServletRequest request
    ) {
        return null;
    }





}
