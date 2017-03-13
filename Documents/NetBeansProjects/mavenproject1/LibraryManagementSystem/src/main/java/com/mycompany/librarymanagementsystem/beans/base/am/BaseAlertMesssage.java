package com.mycompany.librarymanagementsystem.beans.base.am;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;


@ManagedBean(name = "baseam")
@RequestScoped
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
