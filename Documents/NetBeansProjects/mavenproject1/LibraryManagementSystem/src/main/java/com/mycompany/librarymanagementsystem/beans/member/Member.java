package com.mycompany.librarymanagementsystem.beans.member;

import com.mycompany.librarymanagementsystem.beans.base.am.BaseAlertMesssage;
import com.mycompany.librarymanagementsystem.beans.base.person.PersonalInfo;
import com.mycompany.librarymanagementsystem.dao.member.MemberDao;
import com.mycompany.librarymanagementsystem.passwordgenerator.EmailDispatcher;
import com.mycompany.librarymanagementsystem.passwordgenerator.PasswordGenerator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;


@Entity
@javax.enterprise.context.SessionScoped
@ManagedBean
public class Member implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int member_id;

    @Embedded
    @ManagedProperty(value = "#{p_info}")
    private PersonalInfo pIfPersonalInfo;

    @Transient
    @ManagedProperty(value = "#{baseam}")
    private BaseAlertMesssage bam;

    private String password;

    @Id
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

//            genPas();
            md.save(this);
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

    /*
     public void download() throws IOException {

     ByteArrayOutputStream pdfs = new ByteArrayOutputStream();
     FacesContext context = FacesContext.getCurrentInstance();
     HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
     response.setContentType("application/pdf");
     response.setHeader("Content-disposition", "inline=filename=file.pdf");
     try {

     OutputStream file = new FileOutputStream(new File("reports.pdf"));

     Document document = new Document();
     PdfWriter.getInstance(document, file);
     document.open();
     Paragraph p1 = new Paragraph("Hii Rakesh");
     document.add(p1);

     ServletOutputStream reOutputStream = response.getOutputStream();

     context.responseComplete();
     } catch (Exception e) {
     e.printStackTrace();
     } finally {
     response.getOutputStream().flush();
     response.getOutputStream().close();
     }
   

     }
     */
    @Transient
    public List<Member> getMemberList() {

        MemberDao md = new MemberDao();
        List<Member> ls = md.memberList();
        return ls;
    }

}
