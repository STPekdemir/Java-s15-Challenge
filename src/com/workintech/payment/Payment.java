package com.workintech.payment;

import com.workintech.book.Book;
import com.workintech.book.Books;
import com.workintech.member.Members;
import com.workintech.member.Member;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Payment {
    public static double paymentForOneBook(int memberId, int bookId, Members members,Books books){
        if(!(members.isMemberExist(memberId))|| books.getBookById(bookId)==null) {
            return 0;
        }
        Member member=members.getMemberById(memberId);
        Book leasedBook=member.getMemberLeasedBookById(bookId);
        LocalDate leasedDate = leasedBook.getLeasedDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate currentDate = LocalDate.now();
        double payment =( ChronoUnit.DAYS.between(leasedDate, currentDate) + 1)*1.5;
        switch (member.getOcuppation()){
            case STUDENT:
                payment = payment*0.8;
                break;
            case LIBRARIAN:
                payment = payment*0.9;
                break;
            case OTHER:

                break;
            default:
                break;

        }
        return payment;
    }
}
