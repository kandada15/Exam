package bean;

import java.io.Serializable;

public class SubjectListBean implements Serializable {

	 private String classid;
	 private String subjectid;
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
	public String getClassId() {
		return classid;
	}
	public void setClassId(String classid) {
		this.classid = classid;
	}
	public String getSubjectId() {
		return subjectid;
	}
	public void setSubjectId(String subjectid) {
		this.subjectid = subjectid;
	}
}
