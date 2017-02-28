/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.librarymanagementsystem.beans.publisher;

import com.mycompany.librarymanagementsystem.beans.base.vendor.VendorBase;
import javax.faces.bean.ManagedBean;



@ManagedBean
public class Publisher {

	VendorBase publisher;
	private int year;
	private int edition;

	public VendorBase getPublisher() {
		return publisher;
	}

	public void setPublisher(VendorBase publisher) {
		this.publisher = publisher;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

}
