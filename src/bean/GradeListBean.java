package bean;

import java.io.Serializable;

public class GradeListBean implements Serializable {

	 private String schoolid;
	 private String classnumber;
//	 private String subjectid;
//	 private String subjectcode;
	 private String studentname;
	 private String subjectcode;
	 private String subjectname;
//	 private String schoolname;
//	 private String classnumber;
	 private String score;
	 private String grade;
	 private String semester;


	 public String getSchoolId() {
		 return schoolid;
	 }
	 public void setSchoolId(String schoolid) {
		 this.schoolid = schoolid;
	 }

	 public String getClassNumber() {
		 return classnumber;
	 }
	 public void setClassNumber(String classnumber) {
		 this.classnumber = classnumber;
	 }

//	public String getSubjectCode() {
//		return subjectcode;
//	}
//	public void setSubjectCode(String subjectcode) {
//		this. subjectcode = subjectcode;
//	}

	 public String getStudentName() {
		 return studentname;
	 }
	 public void setStudentName(String studentname) {
		 this.studentname = studentname;
	 }

	public String getSubjectName() {
		return subjectname;
	}
	public void setSubjectName(String subjectname) {
		this. subjectname = subjectname;
	}

	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}

	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getSubjectCode() {
		return subjectcode;
	}
	public void setSubjectCode(String subjectcode) {
		this.subjectcode = subjectcode;
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
//	public String getClassId() {
//		return classid;
//	}
//	public void setClassId(String classid) {
//		this.classid = classid;
//	}
//	public String getSubjectId() {
//		return subjectid;
//	}
//	public void setSubjectId(String subjectid) {
//		this.subjectid = subjectid;
//	}
}
