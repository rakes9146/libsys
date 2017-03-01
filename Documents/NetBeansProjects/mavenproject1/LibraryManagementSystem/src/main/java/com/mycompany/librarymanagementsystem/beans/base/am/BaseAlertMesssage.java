package com.mycompany.librarymanagementsystem.beans.base.am;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "baseam")
@SessionScoped
public class BaseAlertMesssage implements Serializable {

    String visibility = "xs";
    String message = null;

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getVisibility() {
        return visibility;
    }

    public String getMessage() {
        return message;
    }

}
