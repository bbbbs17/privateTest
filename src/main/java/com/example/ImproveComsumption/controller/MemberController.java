package com.example.ImproveComsumption.controller;


import com.example.ImproveComsumption.domain.Member;
import com.example.ImproveComsumption.dto.SignupRequestDto;
import com.example.ImproveComsumption.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public Map<String, String> signup(@RequestBody SignupRequestDto dto) {
        memberService.registerMember(dto);
        return Collections.singletonMap("message", "회원가입이 완료되었습니다.");
    }


    // ✅ 로그인 API 추가
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String password = request.get("password");

        Member member = memberService.login(email, password);

        return Collections.singletonMap("message", member.getName() + "님, 로그인에 성공했습니다.");
    }
}
