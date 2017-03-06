package com.mycompany.librarymanagementsystem.passwordgenerator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PasswordGenerator {

    public String generatePassword(String proof_number, Date date) {

        String proof = proof_number.substring(proof_number.length() - 4);
        DateFormat fmt = new SimpleDateFormat("dd/mm/yyyy");
        String d = fmt.format(date);
        String brek_date = d.substring(d.length() - 4);
        String password = proof.concat(brek_date);

        return password;
    }

    /*
    public static void main(String[] args) {

        String aadhar_number = "1010202030304040";
        String a = aadhar_number.substring(aadhar_number.length() - 4);

        DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
        Date d = new Date();
        String date = df.format(d);
        String sw = date.substring(date.length() - 4);
        System.out.println("Aadhar Last Digits " + a);
        System.out.println("Date of birth last digit " + sw);

        String password = a.concat(sw);
        System.out.println("Your Password is " + password);

    }
    */
}
