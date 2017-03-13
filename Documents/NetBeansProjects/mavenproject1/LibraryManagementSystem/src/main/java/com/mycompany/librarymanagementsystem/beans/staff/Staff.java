/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.librarymanagementsystem.beans.staff;

import com.mycompany.librarymanagementsystem.beans.base.am.BaseAlertMesssage;
import com.mycompany.librarymanagementsystem.beans.base.person.PersonalInfo;
import com.mycompany.librarymanagementsystem.dao.staff.StaffDao;

import java.io.Serializable;

import javax.faces.bean.ManagedProperty;

import javax.persistence.Embedded;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;

@Entity
@SessionScoped
@ManagedBean
public class Staff implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int staff_id;
    /*
     @Embedded
     @ManagedProperty(value = "#{p_info}")
     public PersonalInfo personalInfo;
     */

    @Embedded
    @ManagedProperty(value = "#{p_info}")
    private PersonalInfo personalInfo;

    @Transient
    @ManagedProperty(value = "#{baseam}")
    BaseAlertMesssage bam;

    public Staff() {

    }

    public BaseAlertMesssage getBam() {
        return bam;
    }

    public void setBam(BaseAlertMesssage bam) {
        this.bam = bam;
    }

    private String staff_type;

    public String getStaff_type() {
        return staff_type;
    }

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    /*
     public PersonalInfo getPersonalInfo() {
     return personalInfo;
     }

     public void setPersonalInfo(PersonalInfo personalInfo) {
     this.personalInfo = personalInfo;
     }
     */
    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public void setStaff_type(String staff_type) {
        this.staff_type = staff_type;
    }

    public void add() {

        StaffDao stffDao = new StaffDao();
        stffDao.save(this);
        bam.setVisibility("lg");
        bam.setMessage("Data Svaed");
        clear();

    }

    public void clear() {

        this.personalInfo.setFirst_name(null);
        this.personalInfo.setMiddle_name(null);
        this.personalInfo.setLast_name(null);
        this.personalInfo.setDateOfBirth(null);
        this.personalInfo.setGender(null);
        this.personalInfo.setMobile_number(null);
        this.personalInfo.setEmail(null);
        this.personalInfo.setDateOfBirth(null);
        this.personalInfo.setSecurity_question(null);
        this.personalInfo.setSecutiyt_answer(null);
        this.personalInfo.setRegistration_date(null);
        this.personalInfo.setAddress(null);
        this.personalInfo.setId_proof_number(null);
    }

    public List<Staff> getStaffList() {

        StaffDao sd = new StaffDao();
        List<Staff> l = sd.getAuthorList();

        return l;
    }
}
