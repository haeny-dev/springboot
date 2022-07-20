package com.haeny.spock.api.member.service;

import com.haeny.spock.api.member.entity.Member;
import com.haeny.spock.api.member.repository.MemberRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public String getMemberName(Long memberId) {
        return memberRepository.findById(memberId)
            .map(Member::getName)
            .orElse("NONE");
    }

}
