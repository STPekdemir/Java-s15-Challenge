package com.workintech.book;

import com.workintech.member.Member;


import java.util.Date;
import java.util.Objects;
import java.util.Set;

public class Book {

    private int id;
    private String name;
    private String author;
    private Genre genre;
    private boolean status;



    private Member memberThatHaveLeased;
    private Date publishDate;

    private Date leasedDate;
    public Book(int id, String name, String author, Genre genre, Date publishDate) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.publishDate = publishDate;
        this.status = true;
        this.leasedDate = null;
        this.memberThatHaveLeased = null;
    }
    public Book(int id, String name, String author, Genre genre, Date publishDate, Date leasedDate, Member memberThatHaveLeased,boolean status) {
        this( id,  name,  author,genre, publishDate);
        this.leasedDate = leasedDate;
        this.memberThatHaveLeased = memberThatHaveLeased;
        this.status = status;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Member getMemberThatHaveLeased() {
        return memberThatHaveLeased;
    }

    public void setMemberThatHaveLeased(Member membersThatHaveLeased) {
        this.memberThatHaveLeased = membersThatHaveLeased;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Date getLeasedDate() {
        return leasedDate;
    }

    public void setLeasedDate(Date leasedDate) {
        this.leasedDate = leasedDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Book)) {
            return false;
        }
        Book book = (Book) obj;
        return Objects.equals(id, book.id);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", genre=" + genre +
                ", memberThatHaveLeased=" + memberThatHaveLeased +
                ", publishDate=" + publishDate +
                ", leasedDate=" + leasedDate +
                '}';
    }
}
