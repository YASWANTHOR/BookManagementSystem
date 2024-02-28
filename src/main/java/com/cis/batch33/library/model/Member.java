package com.cis.batch33.library.model;

public class Member {

    private int memberId;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private long phoneNumber;
    private String memberShipLevel;
    private int addressId;

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMemberShipLevel() {
        return memberShipLevel;
    }

    public void setMemberShipLevel(String memberShipLevel) {
        this.memberShipLevel = memberShipLevel;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }
}
