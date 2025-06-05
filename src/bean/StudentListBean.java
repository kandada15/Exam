package bean;

import java.io.Serializable;

public class StudentListBean implements Serializable {
	 private String schoolname;
	 private String studentnumber;
	 private String classnumber;
	 private String studentname;

	 
	public String getSchoolName() {
		return schoolname;
	}
	public void setSchoolName(String schoolname) {
		this. schoolname = schoolname;
	}
	 
	public String getStudentNumber() {
		return studentnumber;
	}
	public void setStudentNumber(String studentnumber) {
		this. studentnumber= studentnumber;
	}
	

	public String getClassNumber() {
		return classnumber;
	}
	public void setClassNumber(String classnumber) {
		this. classnumber= classnumber;
	}

	public String getStudentName() {
		return studentname;
	}
	public void setStudentName(String studentname) {
		this.studentname = studentname;
	}
}