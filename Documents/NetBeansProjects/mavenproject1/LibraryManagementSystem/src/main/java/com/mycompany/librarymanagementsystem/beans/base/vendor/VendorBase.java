/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.librarymanagementsystem.beans.base.vendor;


import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

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

    @Transient
    private String option;
    @Transient
    private String updated_value;

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

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getUpdated_value() {
        return updated_value;
    }

    public void setUpdated_value(String updated_value) {
        this.updated_value = updated_value;
    }

}
