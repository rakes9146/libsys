package com.mycompany.librarymanagementsystem.beans.category;

import com.mycompany.librarymanagementsystem.beans.base.am.BaseAlertMesssage;
import com.mycompany.librarymanagementsystem.beans.book.Book;
import com.mycompany.librarymanagementsystem.dao.book.BookDao;
import com.mycompany.librarymanagementsystem.dao.category.CategoryDao;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@ManagedBean
@SessionScoped
@Entity
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManagedProperty(value = "#{baseam}")
    @Transient
    private BaseAlertMesssage bam;

    private String name;
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BaseAlertMesssage getBam() {
        return bam;
    }

    public void setBam(BaseAlertMesssage bam) {
        this.bam = bam;
    }

    public void add() {

        CategoryDao categoryDao = new CategoryDao();
        categoryDao.save(this);
        bam.setVisibility("lg");
        bam.setMessage("Data Saved");
        clear();
    }

    public void clear() {

        this.setName(null);
        this.setDescription(null);
    }

    public List<Category> getCategoryLists() {

        CategoryDao cd = new CategoryDao();
        List<Category> cl = cd.getCategoryList();
        return cl;
    }

}
