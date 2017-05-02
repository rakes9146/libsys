package com.mycompany.librarymanagementsystem.beans.book;

import com.mycompany.librarymanagementsystem.beans.base.am.BaseAlertMesssage;
import com.mycompany.librarymanagementsystem.dao.book.BookDao;
import com.mycompany.librarymanagementsystem.dao.member.MemberDao;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@ManagedBean
@SessionScoped
@Entity(name = "book")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int book_id;
    private String book_title;
    private String book_descrription;
    private String book_qunatity;
    private float book_price;
    private String book_isbn;
    private String category_name;
    private String supplier_name;
    private String publisher_name;
    private String author_name;
    private String new_value;
    private String update_type;

    @Transient
    @ManagedProperty(value = "#{baseam}")
    BaseAlertMesssage bam;

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public String getBook_descrription() {
        return book_descrription;
    }

    public void setBook_descrription(String book_descrription) {
        this.book_descrription = book_descrription;
    }

    public String getBook_qunatity() {
        return book_qunatity;
    }

    public void setBook_qunatity(String book_qunatity) {
        this.book_qunatity = book_qunatity;
    }

    public float getBook_price() {
        return book_price;
    }

    public void setBook_price(float book_price) {
        this.book_price = book_price;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getSupplier_name() {
        return supplier_name;
    }

    public void setSupplier_name(String supplier_supplier) {
        this.supplier_name = supplier_supplier;
    }

    public String getPublisher_name() {
        return publisher_name;
    }

    public void setPublisher_name(String publisher_name) {
        this.publisher_name = publisher_name;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getBook_isbn() {
        return book_isbn;
    }

    public void setBook_isbn(String book_isbn) {
        this.book_isbn = book_isbn;
    }

    public void Book() {

    }

    public BaseAlertMesssage getBam() {
        return bam;
    }

    public void setBam(BaseAlertMesssage bam) {
        this.bam = bam;
    }

    public void add() {

        BookDao bd = new BookDao();
        bd.saveBook(this);

        this.bam.setVisibility("lg");
        this.bam.setMessage("Data Added Successfully");
        clear();
    }

    public String getNew_value() {
        return new_value;
    }

    public void setNew_value(String new_value) {
        this.new_value = new_value;
    }

    public String getUpdate_type() {
        return update_type;
    }

    public void setUpdate_type(String update_type) {
        this.update_type = update_type;
    }

    public void clear() {

        this.setAuthor_name(null);
        this.setBook_descrription(null);
        this.setBook_isbn(null);
        this.setBook_price(0);
        this.setBook_title(null);
        this.setPublisher_name(null);
        this.setSupplier_name(null);
        this.setCategory_name(null);
        this.setBook_price(0.0F);

    }

    public List<Book> getBookLists() {

        BookDao bd = new BookDao();
        List<Book> bl = bd.getBookList();
        return bl;
    }

    public void updateDetails() {

        BookDao bd = new BookDao();
        bd.updateBooks(book_id, update_type, new_value);
        this.bam.setVisibility("lg");
        this.bam.setMessage(this.book_id + " Data Update Successfully");
        this.setNew_value(null);
        this.setUpdate_type(null);
        this.setBook_id(0);
    }

    public void deleteBook() {

        BookDao bd = new BookDao();
        MemberDao md = new MemberDao();
        if (bd.isExist(book_id)) {
            bd.delete(book_id);
            this.bam.setVisibility("lg");
            this.bam.setMessage(this.book_id + " Deleted Successfully");
            this.setBook_id(0);
        } else {
            this.bam.setVisibility("lg");
            this.bam.setMessage(this.book_id + " Id Doesn't Exist");
            this.setBook_id(0);
        }
    }
}
