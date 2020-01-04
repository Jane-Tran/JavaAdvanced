package bean;

import java.util.Date;

/**
 * BenhAnBEAN
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
public class BenhAnBEAN {
	private String patientID;
	private String doctorID;
	private Date examineDate;
	private String Result;
	private String treatments;
	public String getPatientID() {
		return patientID;
	}
	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}
	public String getDoctorID() {
		return doctorID;
	}
	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}
	public Date getExamineDate() {
		return examineDate;
	}
	public void setExamineDate(Date examineDate) {
		this.examineDate = examineDate;
	}
	public String getResult() {
		return Result;
	}
	public void setResult(String result) {
		Result = result;
	}
	public String getTreatments() {
		return treatments;
	}
	public void setTreatments(String treatments) {
		this.treatments = treatments;
	}
	public BenhAnBEAN(String patientID, String doctorID, Date examineDate, String result, String treatments) {
		super();
		this.patientID = patientID;
		this.doctorID = doctorID;
		this.examineDate = examineDate;
		Result = result;
		this.treatments = treatments;
	}
	public BenhAnBEAN() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
