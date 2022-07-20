package com.haeny.spock.api.member.repository

import com.haeny.spock.api.member.entity.Member
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class MemberRepositoryTest extends Specification {

    @Autowired
    MemberRepository memberRepository

    def setup() {
        memberRepository.save(Member.builder().name("haeny").build())
        memberRepository.save(Member.builder().name("haeny1").build())
        memberRepository.save(Member.builder().name("haeny2").build())
    }

    def cleanup() {
        memberRepository.deleteAll()
    }

    def "findAll 전체 Member가 조회된다"() {
        when:
        List<Member> members = memberRepository.findAll()

        then:
        members.size() == 3
        members.get(0).name == "haeny"
    }
}
