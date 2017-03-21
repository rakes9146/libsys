package com.mycompany.librarymanagementsystem.beans.supplier;

import com.mycompany.librarymanagementsystem.beans.base.am.BaseAlertMesssage;
import com.mycompany.librarymanagementsystem.beans.base.vendor.VendorBase;
import com.mycompany.librarymanagementsystem.beans.book.Book;
import com.mycompany.librarymanagementsystem.dao.book.BookDao;
import com.mycompany.librarymanagementsystem.dao.publisher.PublisherDao;
import com.mycompany.librarymanagementsystem.dao.supplier.SupplierDao;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@ManagedBean
@SessionScoped
@Entity(name="supplier")
public class Supplier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManagedProperty(value = "#{base}")
    private VendorBase vb;

    @Transient
    List<String> supplier_names;

    @Transient
    @ManagedProperty(value = "#{baseam}")
    BaseAlertMesssage bam;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VendorBase getVb() {
        return vb;
    }

    public void setVb(VendorBase vb) {
        this.vb = vb;
    }

    public BaseAlertMesssage getBam() {
        return bam;
    }

    public void setBam(BaseAlertMesssage bam) {
        this.bam = bam;
    }

    public void add() {

        SupplierDao so = new SupplierDao();
        so.save(this);

        bam.setVisibility("lg");
        bam.setMessage("Data Saved Successfully");
        clear();
    }

    public void clear() {

        vb.setName(null);
        vb.setAdddress(null);
        vb.setFax(null);
        vb.setEmail(null);
        vb.setPhone(null);
    }

    public List<Supplier> getSupplierLists() {

        SupplierDao sd = new SupplierDao();
        List<Supplier> sl = sd.getSupplierList();
        return sl;
    }

    public List<String> getSupplier_names() {

        SupplierDao sd = new SupplierDao();
        supplier_names = sd.getSupplierNames();

        return supplier_names;
    }

    public void updateDetails() {

        SupplierDao ad = new SupplierDao();
        ad.update(this.getVb().getUpdated_value(), this.id, this.getVb().getOption());
        this.bam.setVisibility("lg");
        this.bam.setMessage(id + " Updated Successfully");
        this.vb.setUpdated_value(null);
        this.setId(0);
    }

    public void deleteAuthor() {

        SupplierDao ad = new SupplierDao();
        ad.deleteAuthor(this.id);
        this.bam.setVisibility("lg");
        this.bam.setMessage(id + " Delete Successfully");
        this.setId(0);
    }

}
