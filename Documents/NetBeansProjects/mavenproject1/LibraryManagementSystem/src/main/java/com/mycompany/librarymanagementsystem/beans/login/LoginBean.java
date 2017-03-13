/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.librarymanagementsystem.beans.login;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import com.mycompany.librarymanagementsystem.beans.base.am.BaseAlertMesssage;

@ManagedBean
@RequestScoped
public class LoginBean {

    private String user_id;
    private String user_pass;
    private String user_type;
    private BaseAlertMesssage bam;
    private boolean staff_flag = false;
    private boolean student_flag = false;

    public boolean isStaff_flag() {
        return staff_flag;
    }

    public void setStaff_flag(boolean staff_flag) {
        this.staff_flag = staff_flag;
    }

    public boolean isStudent_flag() {
        return student_flag;
    }

    public void setStudent_flag(boolean student_flag) {
        this.student_flag = student_flag;
    }

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

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public BaseAlertMesssage getBam() {
        return bam;
    }

    public void setBam(BaseAlertMesssage bam) {
        this.bam = bam;
    }

    public String validate() {

        if ("rake".equals(this.user_id) && "rake".equals(this.user_pass) && "admin".equals(this.user_type)) {

            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getSessionMap().put("staff", this.user_id);
            this.setStudent_flag(false);
            this.setStaff_flag(true);

            return "login_home?faces-redirect=true";

        } else {

            return "error?faces-redirect=true";
        }

    }

    public String studentValidate() {

        if ("rake".equals(this.user_id) && "rake".equals("rake")) {

            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getSessionMap().put("student", this.user_id);

            this.setStaff_flag(true);
            this.setStudent_flag(false);
            return "login_home?faces-redirect=true";
        } else {

            return "error?faces-redirect=true";
        }
    }

    public String logout() {

        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "staff_login?faces-redirect=true";
    }

}
