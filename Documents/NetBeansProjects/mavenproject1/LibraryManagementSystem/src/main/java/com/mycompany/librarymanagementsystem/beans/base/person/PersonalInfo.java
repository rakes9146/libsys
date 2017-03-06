package com.mycompany.librarymanagementsystem.beans.base.person;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
@ManagedBean(name = "p_info")
public class PersonalInfo implements Serializable {

    private String first_name;
    private String middle_name;
    private String last_name;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    private String address;
    private String email;
    private String mobile_number;
    private String gender;
    private String id_proof_number;
    private String id_proof_type;

    @Temporal(TemporalType.DATE)
    private Date registration_date = new Date();
    private String security_question;
    private String secutiyt_answer;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }

    public String getSecurity_question() {
        return security_question;
    }

    public void setSecurity_question(String security_question) {
        this.security_question = security_question;
    }

    public String getSecutiyt_answer() {
        return secutiyt_answer;
    }

    public void setSecutiyt_answer(String secutiyt_answer) {
        this.secutiyt_answer = secutiyt_answer;
    }

    public String getId_proof_number() {
        return id_proof_number;
    }

    public void setId_proof_number(String id_proof_number) {
        this.id_proof_number = id_proof_number;
    }

    public String getId_proof_type() {
        return id_proof_type;
    }

    public void setId_proof_type(String id_proof_type) {
        this.id_proof_type = id_proof_type;
    }

}
