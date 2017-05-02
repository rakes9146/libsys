package com.mycompany.librarymanagementsystem.beans.staff;

import com.mycompany.librarymanagementsystem.beans.base.person.PersonalInfo;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedProperty;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@SessionScoped
@ManagedBean
public class Staff implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int staff_id;

    @Embedded
    @ManagedProperty(value = "#{p_info}")
    private PersonalInfo personalInfo;

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

  
    

}

 