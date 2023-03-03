package softnet.firstBio.lifeLog.controller;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.web.bind.annotation.*;
import softnet.firstBio.lifeLog.Entity.member.Member;
import softnet.firstBio.lifeLog.dto.MemberRegisterDto;
import softnet.firstBio.lifeLog.dto.MemberRegisterResponseDto;
import softnet.firstBio.lifeLog.repo.MemberRepository;
import softnet.firstBio.lifeLog.service.MemberServiceImpl;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/member")
public class MemberController {

    private final MemberServiceImpl memberservice;
    private final EntityManager em;


//    @GetMapping()
//    public List<Member> findAllMember() {
//        return memberservice.findAll();
//    }

    @PostMapping("/signUp")
    public MemberRegisterResponseDto signUp(@RequestBody MemberRegisterDto memberRegisterDto) {
        System.out.println("memberRegisterDto = " + memberRegisterDto);
        return memberservice.join(memberRegisterDto);
    }

    @PostMapping(value = "/login")
    @ResponseBody
    int login(
            HttpServletRequest request
    ) {

        return Response.SC_OK;
    }






}
