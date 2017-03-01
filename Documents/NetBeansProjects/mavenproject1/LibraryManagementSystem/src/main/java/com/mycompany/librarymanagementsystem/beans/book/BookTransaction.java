package com.mycompany.librarymanagementsystem.beans.book;

import java.io.Serializable;
import java.sql.Date;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name = "book_transaction")
@SessionScoped
public class BookTransaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int transaction_id;
    private int book_id;
    private int member_id;

    @Temporal(TemporalType.DATE)
    private Date issue_date;

    @Temporal(TemporalType.DATE)
    private Date return_date;

    @Temporal(TemporalType.DATE)
    private Date actualReturn_Date;

    private double late_fine;

    public BookTransaction() {
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public Date getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(Date issue_date) {
        this.issue_date = issue_date;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    public Date getActualReturn_Date() {
        return actualReturn_Date;
    }

    public void setActualReturn_Date(Date actualReturn_Date) {
        this.actualReturn_Date = actualReturn_Date;
    }

    public double getLate_fine() {
        return late_fine;
    }

    public void setLate_fine(double late_fine) {
        this.late_fine = late_fine;
    }

}
