package com.workintech.bookOperations;

import com.workintech.book.Book;
import com.workintech.book.Books;
import com.workintech.member.Member;
import com.workintech.member.Members;

import java.util.Date;

public class Lease {
    public static void leaseBook(int bookId, int memberId, Members members, Books books) {
        if (members.getMemberById(memberId) != null && books.getBookById(bookId) != null&& books.getBookById(bookId).isStatus() &&members.getMemberById(memberId).getMemberLeasedBooks().size()<5) {
            books.getBookById(bookId).setStatus(false);
            books.getBookById(bookId).setLeasedDate(new Date());
            books.getBookById(bookId).setMemberThatHaveLeased(members.getMemberById(memberId));
            members.getMemberById(memberId).addMemberLeasedBook(books.getBookById(bookId));

            System.out.println("Book Leased");
        }else{
            System.out.println("You cant lease");
        }
    }}