package com.cis.batch33.library.controller;

import com.cis.batch33.library.entity.LibraryMember;
import com.cis.batch33.library.model.Member;
import com.cis.batch33.library.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    // Get a member by memberId
    @GetMapping("/{memberId}")
    public LibraryMember getMember(@PathVariable int memberId) {
        return memberService.getMember(memberId);
    }

    // Create a member
    @PostMapping
    public LibraryMember createMember(@RequestBody LibraryMember member) {
        return memberService.createMember(member);
    }

    // Update a member
    @PutMapping("/{memberId}")
    public LibraryMember updateMember(@PathVariable int memberId, @RequestBody Member updatedMember) {
        return memberService.updateMember(memberId, updatedMember);
    }

    // Delete a member by memberId
    @DeleteMapping("/{memberId}")
    public void deleteMember(@PathVariable int memberId) {
        memberService.deleteMember(memberId);
    }
}