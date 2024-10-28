package jpabook.jpashop.sample.service;

import jpabook.jpashop.sample.Member;
import jpabook.jpashop.sample.repository.MemberRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class) // junit과 spring 같이 실행
@SpringBootTest // spring boot 띄운 상태로 실행
@Transactional // 테스트 이후 롤백
public class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception{
        // given
        Member member=new Member();
        member.setName("kim");

        // when
        Long id = memberService.join(member);

        // then
        assertEquals(member, memberRepository.findOne(id)); // 같은 영속성 컨텍스트이므로
    }

    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception {
        // given
        Member member1=new Member();
        member1.setName("kim");

        Member member2=new Member();
        member2.setName("kim");

        // when
        memberService.join(member1);
        memberService.join(member2);

        //then
        fail("예외가 발생해야 한다.");

    }
}