package bean;

import java.util.Date;

/**
 * BenhNhanBEAN
 * 
 * Date: 15-12-2018
 * 
 * Copyright
 * 
 * Modification Logs:
 * DATE			AUTHOR		DESCRIPTION
 * -------------------------------------
 * 15-12-2018	NhaHuyen		Create
 */
public class BenhNhanBEAN {
	private String patientID;
	private String patientName;
	private String sex;
	private Date birthDay;
	private String address;
	private String phoneNumber;
	public String getPatientID() {
		return patientID;
	}
	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public BenhNhanBEAN(String patientID, String patientName, String sex, Date birthDay, String address,
			String phoneNumber) {
		super();
		this.patientID = patientID;
		this.patientName = patientName;
		this.sex = sex;
		this.birthDay = birthDay;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	public BenhNhanBEAN() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
