package com.mycompany.librarymanagementsystem.beans.member;

import com.mycompany.librarymanagementsystem.beans.base.person.PersonalInfo;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedProperty;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Named(value = "member")
@Dependent
public class Member implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int member_id;

    @Embedded
    @ManagedProperty(value = "#{p_info}")
    private PersonalInfo pIfPersonalInfo;

    public PersonalInfo getpIfPersonalInfo() {
        return pIfPersonalInfo;
    }

    public void setpIfPersonalInfo(PersonalInfo pIfPersonalInfo) {
        this.pIfPersonalInfo = pIfPersonalInfo;
    }

}
