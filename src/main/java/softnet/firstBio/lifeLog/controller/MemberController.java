package softnet.firstBio.lifeLog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import softnet.firstBio.lifeLog.Entity.member.Member;
import softnet.firstBio.lifeLog.repo.MemberRepository;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/")
public class MemberController {

    private final MemberRepository memberRepository;


    @GetMapping("member")
    public List<Member> findAllMember() {
        return memberRepository.findAll();
    }

    @PostMapping("member")
    public Member signUp() {
        final Member member = Member.builder()
                .username("testMember")
                .password("1234")
                .build();
        return memberRepository.save(member);
    }





}
