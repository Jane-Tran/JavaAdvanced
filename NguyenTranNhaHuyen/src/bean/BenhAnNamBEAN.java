package bean;

import java.util.Date;

/**
 * BenhAnNamBEAN
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
public class BenhAnNamBEAN {
	private String patientID;
	private String patientName;
	private String doctorID;
	private String doctorName;
	private Date examineDate;
	private String result;
	private String treatments;
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
	public Date getExamineDate() {
		return examineDate;
	}
	public void setExamineDate(Date examineDate) {
		this.examineDate = examineDate;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getTreatments() {
		return treatments;
	}
	public void setTreatments(String treatments) {
		this.treatments = treatments;
	}
	public BenhAnNamBEAN(String patientID, String patientName, String doctorID, String doctorName, Date examineDate,
			String result, String treatments) {
		super();
		this.patientID = patientID;
		this.patientName = patientName;
		this.doctorID = doctorID;
		this.doctorName = doctorName;
		this.examineDate = examineDate;
		this.result = result;
		this.treatments = treatments;
	}
	public BenhAnNamBEAN() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
