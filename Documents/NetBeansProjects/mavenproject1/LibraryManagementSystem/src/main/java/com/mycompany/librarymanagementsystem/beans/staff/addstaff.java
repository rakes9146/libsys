package com.mycompany.librarymanagementsystem.beans.staff;

import com.mycompany.librarymanagementsystem.beans.base.am.BaseAlertMesssage;
import com.mycompany.librarymanagementsystem.beans.base.person.PersonalInfo;
import com.mycompany.librarymanagementsystem.dao.staff.StaffDao;
import com.mycompany.librarymanagementsystem.dao.supplier.SupplierDao;
import com.mycompany.librarymanagementsystem.passwordgenerator.EmailDispatcher;
import com.mycompany.librarymanagementsystem.passwordgenerator.PasswordGenerator;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
@ManagedBean
@SessionScoped
public class addstaff implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int staff_id;

    @Embedded
    @ManagedProperty(value = "#{p_info}")
    private PersonalInfo personalInfo;

    private String option;

    private String updated_value;

    @ManagedProperty(value = "#{baseam}")
    BaseAlertMesssage bam;

    private String password;

    @Id
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

    private String staff_type;

    public String getStaff_type() {
        return staff_type;
    }

    public void setStaff_type(String staff_type) {
        this.staff_type = staff_type;
    }

    @Transient
    public BaseAlertMesssage getBam() {
        return bam;
    }

    public void setBam(BaseAlertMesssage bam) {
        this.bam = bam;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Transient
    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    @Transient
    public String getUpdated_value() {
        return updated_value;
    }

    public void setUpdated_value(String updated_value) {
        this.updated_value = updated_value;
    }

    public void add() {

        EmailDispatcher ed = new EmailDispatcher();
        this.genPas();
        try {
            StaffDao stffDao = new StaffDao();
            stffDao.save(this);
            System.out.println("Data Added Successfully");
            try {
                ed.dispatchEmail(this.getPersonalInfo().getFirst_name(), this.getPersonalInfo().getEmail(), Integer.toString(this.staff_id), this.password);
            } catch (Exception e) {
                e.printStackTrace();
            }
            bam.setVisibility("lg");
            bam.setMessage("Data Svaed");
            clear();
        } catch (Exception e) {

            bam.setMessage("lg");
            bam.setMessage("Data Not saved an Error Occured");
            clear();
        }
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

    @Transient
    public List<addstaff> getStaffList() {

        StaffDao sd = new StaffDao();
        List<addstaff> l = sd.getAuthorList();

        return l;
    }

    public void genPas() {
        PasswordGenerator pg = new PasswordGenerator();
        this.setPassword(pg.generatePassword(this.personalInfo.getId_proof_number(), this.personalInfo.getDateOfBirth()));
        System.out.println(this.password);
    }

    public void updateDetails() {

        StaffDao ad = new StaffDao();
        ad.update(this.getUpdated_value(), this.staff_id, this.getOption());
        this.bam.setVisibility("lg");
        this.bam.setMessage(this.staff_id + " Updated Successfully");
        this.setUpdated_value(null);
        this.setStaff_id(0);
    }

    public void deleteAuthor() {

        StaffDao ad = new StaffDao();
        ad.delete(staff_id);
        this.bam.setVisibility("lg");
        this.bam.setMessage(this.staff_id + " Delete Successfully");
        this.setStaff_id(0);
    }
}
