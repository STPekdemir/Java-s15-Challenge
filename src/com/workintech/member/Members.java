package com.workintech.member;

import com.workintech.book.Book;

import java.util.Map;
import java.util.Set;

public class Members {
    private Map<Integer, Member> members;
    public Members(Map<Integer, Member> members) {
        this.members = members;
    }
    public Map<Integer, Member> getMembers() {
        return members;
    }
    public void setMembers(Map<Integer, Member> members) {
        this.members = members;
    }
    public boolean isMemberExist(int id) {
        return members.containsKey(id);
    }
    public void addMember(Member member) {
        if (isMemberExist(member.getId())) {
            System.out.println("Member already exist");
        }else {

            members.put(member.getId(), member);
        }
    }

    public void removeMember(Member member) {
        if(isMemberExist(member.getId())) {
            members.remove(member.getId());
        } else {
            System.out.println("Member not found");
        }
    }

    public void removeMemberById(int id) {
        if(isMemberExist(id)) {
            members.remove(id);
        } else {
            System.out.println("Member not found");
        }
    }
    public void print() {
        Set<Integer> keys = members.keySet();
        for (Integer key : keys) {
            System.out.println(members.get(key));
        }
    }
    public Member getMemberById(int id) {
        if (isMemberExist(id)) {
            return members.get(id);
        } else {
            return null;
        }
    }





}
