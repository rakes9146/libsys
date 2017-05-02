/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.librarymanagementsystem.beans.author;

import com.mycompany.librarymanagementsystem.beans.base.vendor.VendorBase;
import com.mycompany.librarymanagementsystem.dao.author.AuthorDao;
import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedProperty;
import javax.persistence.Embedded;
import javax.persistence.Transient;
import com.mycompany.librarymanagementsystem.beans.base.am.BaseAlertMesssage;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@ManagedBean
@SessionScoped
@Entity(name = "author")
public class AuthorDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private static final long serialVersionUID = 2L;
    @Embedded
    @ManagedProperty(value = "#{base}")

    private VendorBase base1;

    @ManagedProperty(value = "#{baseam}")
    @Transient
    private BaseAlertMesssage bam;

    @Transient
    List<String> ls;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VendorBase getBase1() {
        return base1;
    }

    public void setBase1(VendorBase base1) {
        this.base1 = base1;
    }

    public BaseAlertMesssage getBam() {
        return bam;
    }

    public void setBam(BaseAlertMesssage bam) {
        this.bam = bam;
    }

    public void add() {

        AuthorDao d = new AuthorDao();
        d.add(this);
        bam.setVisibility("lg");
        bam.setMessage("Data Added");

        clear();
    }

    public void clear() {

        this.base1.setName(null);
        this.base1.setAdddress(null);
        this.base1.setEmail(null);
        this.base1.setPhone(null);
        this.base1.setFax(null);

    }

    public List<AuthorDetails> getAuthroLists() {

        AuthorDao bd = new AuthorDao();
        List<AuthorDetails> bl = bd.getAuthorList();
        return bl;
    }

    public List<String> getLs() {

        AuthorDao ad = new AuthorDao();
        ls = ad.getNames();
        for (String s : ls) {
            System.out.println(s);
        }
        return ls;
    }

    public void updateDetails() {

        AuthorDao ad = new AuthorDao();
        ad.update(this.getBase1().getUpdated_value(), this.id, this.getBase1().getOption());
        this.bam.setVisibility("lg");
        this.bam.setMessage(id + " Updated Successfully");
        this.base1.setUpdated_value(null);
        this.setId(0);
    }

    public void deleteAuthor() {

        AuthorDao ad = new AuthorDao();
        ad.deleteAuthor(this.id);
        this.bam.setVisibility("lg");
        this.bam.setMessage(id + " Delete Successfully");
        this.setId(0);
    }

}
