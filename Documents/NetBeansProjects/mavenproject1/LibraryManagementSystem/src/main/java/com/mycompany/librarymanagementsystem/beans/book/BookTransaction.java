package com.mycompany.librarymanagementsystem.beans.book;

import com.mycompany.librarymanagementsystem.beans.base.am.BaseAlertMesssage;
import com.mycompany.librarymanagementsystem.dao.book.BookDao;
import com.mycompany.librarymanagementsystem.dao.book.BookTransactionDao;
import com.mycompany.librarymanagementsystem.dao.member.MemberDao;
import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@SessionScoped
@ManagedBean
@Entity(name = "book_transaction")
public class BookTransaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int transaction_id;
    private int book_id;
    private int member_id;

    @Temporal(TemporalType.DATE)
    private Date issue_date = new java.util.Date();

    @Temporal(TemporalType.DATE)
    private Date return_date;

    @Temporal(TemporalType.DATE)
    private Date actualReturn_Date;

    private double late_fine;

    @Transient
    @ManagedProperty(value = "#{baseam}")
    BaseAlertMesssage bam;

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

    public BaseAlertMesssage getBam() {
        return bam;
    }

    public void setBam(BaseAlertMesssage bam) {
        this.bam = bam;
    }

    public void add() {
        MemberDao md = new MemberDao();
        BookDao bd = new BookDao();
        BookTransactionDao bdo = new BookTransactionDao();
        if (md.isExist(member_id) && bd.isExist(book_id)) {
            bdo.addTransaction(this);
            bam.setVisibility("lg");
            bam.setMessage("Book Alloted Successfully");
            clear();
        } else {
            bam.setVisibility("lg");
            bam.setMessage("Please Check Book/Member Id");
            clear();
        }

    }

    public void clear() {

        this.setBook_id(0);
        this.setMember_id(0);
    }

}
