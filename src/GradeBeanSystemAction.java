import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.GradeListBean;
import tool.Action;

public class GradeBeanSystemAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    	String schoolid = request.getParameter("schoolid");
    	String classnumber = request.getParameter("classnumber");
    	String studentname = request.getParameter("studentname");
    	String subjectname = request.getParameter("subjectname");
    	String score = request.getParameter("score");
//    	String grade = request.getParameter("grade");
//    	String subjectname = request.getParameter("subjectname");
    	
    	int scoreInt = Integer.parseInt(score);

    	String grade;
        if (scoreInt >= 80) {
            grade = "A";
        } else if (scoreInt >= 71) {
            grade = "B";
        } else if (scoreInt >= 41) {
            grade = "C";
        } else if (scoreInt >= 21) {
            grade = "D";
        } else {
            grade = "E";
        }
    	
        GradeListBean bl = new GradeListBean();
        bl.setSchoolId(schoolid);
        bl.setClassNumber(classnumber);
    	bl.setStudentName(studentname);
    	bl.setSubjectName(subjectname);
    	bl.setScore(score);
    	bl.setGrade(grade);
    	
        request.setAttribute("bl", bl);

        return "GradeSystem.action";
    }
}
