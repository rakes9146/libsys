package com.mycompany.librarymanagementsystem.beans.member;

import com.mycompany.librarymanagementsystem.beans.base.am.BaseAlertMesssage;
import com.mycompany.librarymanagementsystem.beans.base.person.PersonalInfo;
import com.mycompany.librarymanagementsystem.dao.member.MemberDao;
import com.mycompany.librarymanagementsystem.passwordgenerator.EmailDispatcher;
import com.mycompany.librarymanagementsystem.passwordgenerator.PasswordGenerator;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@ManagedBean
@SessionScoped
@Entity
public class Member implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int member_id;

    @ManagedProperty(value = "#{p_info}")
    @Embedded
    private PersonalInfo pIfPersonalInfo;

    @Transient
    @ManagedProperty(value = "#{baseam}")
    private BaseAlertMesssage bam;

    private String password;

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public PersonalInfo getpIfPersonalInfo() {
        return pIfPersonalInfo;
    }

    public void setpIfPersonalInfo(PersonalInfo pIfPersonalInfo) {
        this.pIfPersonalInfo = pIfPersonalInfo;
    }

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

    public void add() {

        try {
            MemberDao md = new MemberDao();
            EmailDispatcher ed = new EmailDispatcher();
//            genPas();
            md.save(this);
            ed.dispatchEmail(this.pIfPersonalInfo.getFirst_name(), this.pIfPersonalInfo.getEmail(), Integer.toString(this.getMember_id()), this.getPassword());
            bam.setVisibility("lg");
            bam.setMessage(member_id + "Data Saved Succesffyly and Email Sent to Student");
            clear();
        } catch (Exception e) {

            bam.setMessage("lg");
            bam.setMessage("Data Not saved an Error Occured");
            clear();

        }

    }

    public void clear() {

        this.pIfPersonalInfo.setFirst_name(null);
        this.pIfPersonalInfo.setMiddle_name(null);
        this.pIfPersonalInfo.setLast_name(null);
        this.pIfPersonalInfo.setDateOfBirth(null);
        this.pIfPersonalInfo.setGender(null);
        this.pIfPersonalInfo.setMobile_number(null);
        this.pIfPersonalInfo.setEmail(null);
        this.pIfPersonalInfo.setDateOfBirth(null);
        this.pIfPersonalInfo.setSecurity_question(null);
        this.pIfPersonalInfo.setSecutiyt_answer(null);
        this.pIfPersonalInfo.setRegistration_date(null);
        this.pIfPersonalInfo.setAddress(null);
    }

    public void genPas() {
        PasswordGenerator pg = new PasswordGenerator();
        this.setPassword(pg.generatePassword(this.pIfPersonalInfo.getId_proof_number(), this.pIfPersonalInfo.getDateOfBirth()));
    }

}
