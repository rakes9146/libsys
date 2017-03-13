/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.librarymanagementsystem.beans.base.vendor;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SessionScoped
@Embeddable
@ManagedBean(name = "base")
public class VendorBase implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String adddress;
    private String phone;
    private String fax;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdddress() {
        return adddress;
    }

    public void setAdddress(String adddress) {
        this.adddress = adddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
