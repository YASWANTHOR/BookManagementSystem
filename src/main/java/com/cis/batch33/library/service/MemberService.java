package com.cis.batch33.library.service;

import com.cis.batch33.library.entity.LibraryMember;
import com.cis.batch33.library.model.Member;
import com.cis.batch33.library.repository.LibraryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class MemberService {

    @Autowired
    private LibraryMemberRepository memberRepository;

    public LibraryMember createMember(LibraryMember member){
        Integer memberId = new Random().nextInt();
        member.setMemberId(memberId);
        return memberRepository.save(member);
    }

    public LibraryMember getMember(int memberId) {
        Optional<LibraryMember> memberOptional =
                memberRepository.findById(memberId);
        if (memberOptional.isPresent()) {
            return  memberOptional.orElse(new LibraryMember());
        } else {
            return null; // Member not found for the given memberId
        }
    }

    public LibraryMember updateMember(int memberId, Member updatedMember) {
        Optional<LibraryMember> memberOptional = memberRepository.findById(memberId);

        if (memberOptional.isPresent()) {
            LibraryMember existingMember = memberOptional.get();

            // Update the fields of existingMember with the values from updatedMember
            existingMember.setFirstName(updatedMember.getFirstName());
            existingMember.setLastName(updatedMember.getLastName());
            existingMember.setEmailAddress(updatedMember.getEmailAddress());
            existingMember.setPhoneNumber(updatedMember.getPhoneNumber());
            existingMember.setMemberShipLevel(updatedMember.getMemberShipLevel());
            existingMember.setAddressId(updatedMember.getAddressId());

            // Save the updated member and return the updated member
            return memberRepository.save(existingMember);
        } else {
            return null; // Member not found for the given memberId
        }
    }

    public void deleteMember(int memberId) {
        // Simulating database delete
        memberRepository.deleteById(memberId);
    }
}