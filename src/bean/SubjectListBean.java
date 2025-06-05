package bean;

import java.io.Serializable;

public class SubjectListBean implements Serializable {
	 private String subjectcode;
	 private String subjectname;
	 private String schoolname;
	 private String classnumber;


	public String getSubjectCode() {
		return subjectcode;
	}
	public void setSubjectCode(String subjectcode) {
		this. subjectcode = subjectcode;
	}
	public String getSubjectName() {
		return subjectname;
	}
	public void setSubjectName(String subjectname) {
		this. subjectname = subjectname;
	}
	public String getSchoolName() {
		return schoolname;
	}
	public void setSchoolName(String schoolname) {
		this. schoolname = schoolname;
	}



	public String getClassNumber() {
		return classnumber;
	}
	public void setClassNumber(String classnumber) {
		this. classnumber= classnumber;
	}
}
