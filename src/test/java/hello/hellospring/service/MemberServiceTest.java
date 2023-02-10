package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {


    MemberService memberService;
    MemoryMemberRepository memberRepository;



    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }


    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }


    @Test
    void 회원가입() {
        Member member = new Member();
        member.setName("spring");

        Long saveId = memberService.join(member);
        Member findMember = memberService.findOne(saveId).get();

        org.assertj.core.api.Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        memberService.join(member1);
        try {
            memberService.join(member1);
            fail("예외가 발생해야 합니다.");
        } catch(IllegalStateException e) {
            System.out.println("이름 중복");
        }

    }


    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}