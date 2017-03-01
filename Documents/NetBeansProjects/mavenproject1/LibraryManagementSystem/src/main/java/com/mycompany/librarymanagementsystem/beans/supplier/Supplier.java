package com.mycompany.librarymanagementsystem.beans.supplier;

import com.mycompany.librarymanagementsystem.beans.base.am.BaseAlertMesssage;
import com.mycompany.librarymanagementsystem.beans.base.vendor.VendorBase;
import com.mycompany.librarymanagementsystem.dao.supplier.SupplierDao;
import java.io.Serializable;
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
@Entity
public class Supplier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManagedProperty(value = "#{base}")
    private VendorBase vb;

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
    }

    public void clear() {

        vb.setName(null);
        vb.setAdddress(null);
        vb.setFax(0);
        vb.setEmail(null);
        vb.setPhone(0);
    }

}
