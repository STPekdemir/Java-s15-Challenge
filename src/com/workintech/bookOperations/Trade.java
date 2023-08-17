package com.workintech.bookOperations;

import com.workintech.book.Book;
import com.workintech.book.Books;
import com.workintech.member.Member;
import com.workintech.member.Members;

import java.util.Date;

public class Trade {
    public static void tradeBooks(int member1Id, int Member2Id, int book1Id, int book2Id, Members members, Books books) {
        if(members.isMemberExist(member1Id) && members.isMemberExist(Member2Id) && books.getBookById(book1Id)!=null && books.getBookById(book2Id)!=null) {
            Member member1=members.getMemberById(member1Id);
            Member member2=members.getMemberById(Member2Id);
            Book book1=books.getBookById(book1Id);
            Book book2=books.getBookById(book2Id);
            if(member1.getMemberLeasedBookById(book1Id)!=null && member2.getMemberLeasedBookById(book2Id)!=null) {

                Date leaseDate1 = book1.getLeasedDate();
                Date leaseDate2 = book2.getLeasedDate();
                member1.removeMemberLeasedBookById(book1Id);
                member2.removeMemberLeasedBookById(book2Id);
                book1.setLeasedDate(leaseDate2);
                book1.setMemberThatHaveLeased(member2);
                book2.setLeasedDate(leaseDate1);
                book2.setMemberThatHaveLeased(member1);
                member1.addMemberLeasedBook(book2);
                member2.addMemberLeasedBook(book1);
                System.out.println("Books are traded");
            }
            else {
                System.out.println("One of the member does not have the book");
            }
        }
        else {
            System.out.println("Either one of the member or book does not exist");
        }
    }
}
