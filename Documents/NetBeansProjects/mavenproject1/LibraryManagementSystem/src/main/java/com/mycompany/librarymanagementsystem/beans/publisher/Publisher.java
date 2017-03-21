/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.librarymanagementsystem.beans.publisher;

import com.mycompany.librarymanagementsystem.beans.base.am.BaseAlertMesssage;
import com.mycompany.librarymanagementsystem.beans.base.vendor.VendorBase;
import com.mycompany.librarymanagementsystem.beans.book.Book;
import com.mycompany.librarymanagementsystem.dao.author.AuthorDao;
import com.mycompany.librarymanagementsystem.dao.book.BookDao;
import com.mycompany.librarymanagementsystem.dao.publisher.PublisherDao;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@ManagedBean
@Entity(name="publisher")
public class Publisher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Embedded
    @ManagedProperty(value = "#{base}")
    VendorBase p;
    private int year;
    private int edition;

    @Transient
    List<String> publisher_names;

    @Transient
    private int[] years = {2001, 2002, 2003, 2004, 2005, 2006};

    @ManagedProperty(value = "#{baseam}")
    @Transient
    private BaseAlertMesssage bam;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VendorBase getP() {
        return p;
    }

    public void setP(VendorBase p) {
        this.p = p;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int[] getYears() {
        return years;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public BaseAlertMesssage getBam() {
        return bam;
    }

    public void setBam(BaseAlertMesssage bam) {
        this.bam = bam;
    }

    public void add() {

        PublisherDao pd = new PublisherDao();
        pd.save(this);
        bam.setVisibility("lg");
        bam.setMessage(" Data Saved");
        clear();
    }

    public void clear() {

        this.setEdition(0);
        this.p.setName(null);
        this.p.setEmail(null);
        this.p.setAdddress(null);
        this.p.setPhone(null);
        this.p.setFax(null);

    }

    public List<Publisher> getPublsiherLists() {

        PublisherDao pd = new PublisherDao();
        List<Publisher> pl = pd.getPublisherList();
        return pl;
    }

    public List<String> getPublisher_names() {
        PublisherDao pd = new PublisherDao();
        publisher_names = pd.getPublisherName();
        return publisher_names;
    }

    public void updateDetails() {

        PublisherDao ad = new PublisherDao();
        ad.update(this.getP().getUpdated_value(), this.id, this.getP().getOption());
        this.bam.setVisibility("lg");
        this.bam.setMessage(id + " Updated Successfully");
        this.p.setUpdated_value(null);
        this.setId(0);
    }

    public void deleteAuthor() {

        PublisherDao ad = new PublisherDao();
        ad.deleteAuthor(this.id);
        this.bam.setVisibility("lg");
        this.bam.setMessage(id + " Delete Successfully");
        this.setId(0);
    }

}
