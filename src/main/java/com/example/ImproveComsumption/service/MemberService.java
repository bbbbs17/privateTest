package com.example.ImproveComsumption.service;

import com.example.ImproveComsumption.domain.Member;
import com.example.ImproveComsumption.domain.Role;
import com.example.ImproveComsumption.dto.SignupRequestDto;
import com.example.ImproveComsumption.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;


    public void registerMember(SignupRequestDto dto) {
        // 중복 이메일 검사
        if (memberRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }

        // 회원 객체 생성 및 저장
        Member member = new Member();
        member.setEmail(dto.getEmail());
        member.setName(dto.getName());
        member.setPassword(dto.getPassword()); // ⚠️ 추후 암호화 필요
        member.setRole(Role.USER);

        memberRepository.save(member);
    }
    // ✅ 로그인 기능 추가
    public Member login(String email, String password) {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 이메일입니다."));

        if (!member.getPassword().equals(password)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        return member;
    }
}
