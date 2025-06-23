package bean;

import java.io.Serializable;

public class StudentListBean implements Serializable {

	 private String schoolid;
	 private String schoolname;
	 private String studentnumber;
	 private String classnumber;
	 private String studentname;
	 private String semester;


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

	public String getSchoolId() {
		return schoolid;
	}
	public void setSchoolId(String schoolid) {
		this.schoolid = schoolid;
	}


	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
}