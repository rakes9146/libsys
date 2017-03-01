/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.librarymanagementsystem.beans.login;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class LoginBean {

    private String user_id;
    private String user_pass;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }

    public String validate() {

        if ("rake".equals(this.user_id) && "rake".equals(this.user_pass)) {

            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getSessionMap().put("user", this.user_id);
            return "member?faces-redirect=true";

        } else {
            return "home?faces-redirect=true";
        }

    }

    public String logout() {

        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login?faces-redirect=true";
    }
}
