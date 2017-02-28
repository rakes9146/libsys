/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.librarymanagementsystem.beans.author;

import com.mycompany.librarymanagementsystem.beans.base.vendor.VendorBase;
import com.mycompany.librarymanagementsystem.dao.author.AuthorDao;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedProperty;
import javax.persistence.Embedded;

/**
 *
 * @author RAKESHLOHAR
 */
@ApplicationScoped
public class AuthorDetails implements Serializable {

    private static final long serialVersionUID = 2L;
    @Embedded
    @ManagedProperty(value = "#{base}")
    private VendorBase base1;
    @javax.persistence.Transient
    String msg = "";
    @javax.persistence.Transient
    String visible = "";

    public VendorBase getBase1() {
        return base1;
    }

    public void setBase1(VendorBase base1) {
        this.base1 = base1;
    }

    public String getVisible() {
        return visible;
    }

    public void save() {

        /*
        AuthorDao d = new AuthorDao();
        d.save(this);
        this.msg = "Data Saved";
        this.visible = "lg";
*/
    }
                

}
