package softnet.firstBio.lifeLog.service;

import com.google.firebase.auth.FirebaseAuth;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softnet.firstBio.lifeLog.Entity.member.Member;
import softnet.firstBio.lifeLog.dto.MemberRegisterDto;
import softnet.firstBio.lifeLog.dto.MemberRegisterResponseDto;
import softnet.firstBio.lifeLog.repo.MemberRepository;

import java.util.Optional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
@Service
public class MemberServiceImpl implements UserDetailsService {

    private final MemberRepository memberRepository;
    private final FirebaseAuth firebaseAuth;

    //계정 검증
    private void validateAlreadyRegistered(MemberRegisterDto memberRegisterDto) {
        Optional<Member> optionalMember = memberRepository.findByUid(memberRegisterDto.getUid());
        if (optionalMember.isPresent()) {
            throw new RuntimeException("해당 계정으로 이미 회원가입을 했습니다.");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return memberRepository.findByUid(username)
                .orElseThrow(() -> {
                    throw new UsernameNotFoundException("해당 회원이 존재하지 않습니다.");
                });
    }

    //회원 등록
    @Transactional
    public MemberRegisterResponseDto register(MemberRegisterDto memberRegisterDto) {
        validateAlreadyRegistered(memberRegisterDto);
        return new MemberRegisterResponseDto(memberRepository.save(createMember(memberRegisterDto)));
    }

    private Member createMember(MemberRegisterDto memberRegisterDto) {
        Member member = Member.builder()
                .uid(memberRegisterDto.getUid())
                .username(memberRegisterDto.getUsername())
                .password(memberRegisterDto.getPassword())
                .email(memberRegisterDto.getEmail())
                .build();
        return member;
    }

    //회원 가입
    @Transactional
    public MemberRegisterResponseDto join(MemberRegisterDto memberRegisterDto) {
        return register(memberRegisterDto);
    }


}
