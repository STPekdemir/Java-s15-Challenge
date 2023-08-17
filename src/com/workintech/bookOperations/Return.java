package com.workintech.bookOperations;

import com.workintech.book.Book;
import com.workintech.book.Books;
import com.workintech.member.Member;
import com.workintech.member.Members;
import com.workintech.payment.Payment;

public class Return {
    public static void returnBook(int bookId, int memberId, Members members, Books books) {
        if (members.getMemberById(memberId) != null && books.getBookById(bookId) != null&&members.getMemberById(memberId).getMemberLeasedBookById(bookId)!=null){
            Member member =members.getMemberById(memberId);
            member.removeMemberLeasedBookById(bookId);
            Book book = books.getBookById(bookId);
            book.setStatus(true);
            book.setLeasedDate(null);
            book.setMemberThatHaveLeased(null);
            System.out.println("Book return payment is:"+Payment.paymentForOneBook( bookId,  memberId,  members,  books));

        }else{
            System.out.println("You Cannot Return Book");
        }

    }
}