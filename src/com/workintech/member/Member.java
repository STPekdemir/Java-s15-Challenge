package com.workintech.member;

import com.workintech.book.Book;

import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class Member {

    private int id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private Occupation ocuppation;
    private Set<Book> memberLeasedBooks;
    public Member(int id, String name, String email, String password, String phone, Occupation ocuppation, Set<Book> memberLeasedBooks) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.ocuppation = ocuppation;
        this.memberLeasedBooks = memberLeasedBooks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Occupation getOcuppation() {
        return ocuppation;
    }

    public void setOcuppation(Occupation ocuppation) {
        this.ocuppation = ocuppation;
    }

    public Set<Book> getMemberLeasedBooks() {
        return memberLeasedBooks;
    }
    public Book getMemberLeasedBookById(int id) {
        for (Book book : memberLeasedBooks) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public void setMemberLeasedBooks(Set<Book> memberLeasedBooks) {
        this.memberLeasedBooks = memberLeasedBooks;
    }
    public void addMemberLeasedBook(Book book) {

        if(memberLeasedBooks.size() <=5) {
            memberLeasedBooks.add(book);
        }else {
            System.out.println("You are at capacity");
        }


    }
    public void removeMemberLeasedBook(Book book) {
        memberLeasedBooks.remove(book);
    }
    public void removeMemberLeasedBookById(int id) {
        Iterator<Book> iterator = memberLeasedBooks.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getId() == id) {
                iterator.remove();
            }
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return id == member.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", ocuppation=" + ocuppation +
                ", memberLeasedBooks=" + memberLeasedBooks +
                '}';
    }
}
