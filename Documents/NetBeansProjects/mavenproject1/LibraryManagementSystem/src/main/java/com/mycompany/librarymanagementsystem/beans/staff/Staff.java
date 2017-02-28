package com.mycompany.librarymanagementsystem.beans.staff;

import com.mycompany.librarymanagementsystem.beans.base.person.PersonalInfo;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.bean.ManagedProperty;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SessionScoped
public class Staff implements Serializable {

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int staff_id;  
    
    @Embedded
    @ManagedProperty(value = "#{p_info}")
    private PersonalInfo personalInfo;

    private String security_question;
    private String security_answer;

    public Staff() {
    }

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    public String getSecurity_question() {
        return security_question;
    }

    public void setSecurity_question(String security_question) {
        this.security_question = security_question;
    }

    public String getSecurity_answer() {
        return security_answer;
    }

    public void setSecurity_answer(String security_answer) {
        this.security_answer = security_answer;
    }

}
