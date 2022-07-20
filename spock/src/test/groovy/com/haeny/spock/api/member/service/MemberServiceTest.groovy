package com.haeny.spock.api.member.service

import com.haeny.spock.api.member.entity.Member
import com.haeny.spock.api.member.repository.MemberRepository
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import spock.lang.Specification

import static org.mockito.ArgumentMatchers.any
import static org.mockito.BDDMockito.given

@DataJpaTest
class MemberServiceTest extends Specification {

    @Mock
    MemberRepository memberRepository

    @InjectMocks
    MemberService memberService

    def "Member ID로 회원이름 조회"() {
        given:
        long id = 1L
        given(this.memberRepository.findById(any()))
                .willReturn(Optional.ofNullable(new Member("haeny")))

        when:
        String name = memberService.getMemberName(id)

        then:
        name == "haeny"
    }

    def "Member ID로 회원이름 조회2"() {
        given:
        long id = 1L
        MemberRepository mockMemberRepository = Mock(MemberRepository.class)
        MemberService memberService = new MemberService(mockMemberRepository)

        when:
        String name = memberService.getMemberName(id)

        then:
        mockMemberRepository.findById(id) >> Optional.ofNullable(new Member("haeny"))
        "haeny" == name
    }
}
