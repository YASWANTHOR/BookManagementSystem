package com.cis.bookmanagementsystem.service;

import com.cis.bookmanagementsystem.pojo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class MemberService {
    private final Map<Integer, Member> integerMemberMap = new HashMap<>();
    public Member createMember(Member member) {
        member.setMemberId(Math.abs(new Random().nextInt()));
        integerMemberMap.put(member.getMemberId(), member);
        return member;
    }

    public Member readMember(int memberId) {
        System.out.println(integerMemberMap.get(memberId).getFirstName());
        return integerMemberMap.get(memberId);
    }



    public Member updateMemberData(int memberId, Member updatedMember) {
        System.out.println(integerMemberMap);
        if(integerMemberMap.containsKey(memberId)) {
            Member member = integerMemberMap.get(memberId);
            if(!member.getFirstName().isEmpty()) {
                member.setFirstName(updatedMember.getFirstName());
            }
            if(!member.getLastName().isEmpty()) {
                member.setLastName(updatedMember.getLastName());
            }
            if(!member.getEmailId().isEmpty()) {
                member.setEmailId(updatedMember.getEmailId());
            }
            if(!member.getPhoneNumber().isEmpty()) {
                member.setPhoneNumber(updatedMember.getPhoneNumber());
            }
            integerMemberMap.put(memberId, member);
            System.out.println("updated successfully");
            return member;
        }
        return null;
    }

    public Member deleteMember(int memberId) {
        return integerMemberMap.remove(memberId);
    }
}
