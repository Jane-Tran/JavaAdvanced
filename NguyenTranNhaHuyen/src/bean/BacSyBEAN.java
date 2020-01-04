package bean;

/**
 * BacSiBEAN
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
public class BacSyBEAN {
	private String doctorID;
	private String doctorName;
	private String address;
	private String phoneNumber;
	public String getDoctorID() {
		return doctorID;
	}
	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
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
	public BacSyBEAN(String doctorID, String doctorName, String address, String phoneNumber) {
		super();
		this.doctorID = doctorID;
		this.doctorName = doctorName;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	public BacSyBEAN() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
