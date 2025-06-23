package bean;

import java.io.Serializable;

public class SubjectListBean implements Serializable {

	 private String schoolid;
	 private String classid;
//	 private String subjectid;
	 private String subjectcode;
	 private String subjectname;
	 private String semester;
//	 private String schoolname;
//	 private String classnumber;



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
//	public String getSchoolName() {
//		return schoolname;
//	}
//	public void setSchoolName(String schoolname) {
//		this. schoolname = schoolname;
//	}
//
//
//
//	public String getClassNumber() {
//		return classnumber;
//	}
//	public void setClassNumber(String classnumber) {
//		this. classnumber= classnumber;
//	}
	public String getClassId() {
		return classid;
	}
	public void setClassId(String classid) {
		this.classid = classid;
	}
//	public String getSubjectId() {
//		return subjectid;
//	}
//	public void setSubjectId(String subjectid) {
//		this.subjectid = subjectid;
//	}
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
