package com.cis.bookmanagementsystem.controller;

import com.cis.bookmanagementsystem.pojo.Member;
import com.cis.bookmanagementsystem.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping("/create")
    public Member createdMember(@RequestBody Member member) {
        return memberService.createMember(member);
    }

    @GetMapping("/read")
    public String getMemberById(@RequestParam int memberId) {
        System.out.println(memberService.readMember(memberId));
        return memberService.readMember(memberId).getFirstName();
    }


    @PutMapping("/update")
    public Member update(@RequestParam int memberId,
                         @RequestBody Member member) {
        return memberService.updateMemberData(memberId, member);
    }

    @DeleteMapping("/delete")
    public Member delete(@RequestParam int memberId) {
        System.out.println("Member Deleted");
        return memberService.deleteMember(memberId);
    }
}
