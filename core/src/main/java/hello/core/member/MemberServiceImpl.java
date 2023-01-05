package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository; // 추상화에만 의존 (DIP를 지킴)

    @Autowired // ac.getBean(MemberRepository.class) 와 같이 동작 (현재는 MemoryMemberRepository라는 Component가 있음)
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
    
    // 테스트용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
