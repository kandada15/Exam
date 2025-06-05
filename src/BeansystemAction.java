import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.StudentListBean;
import tool.Action;

public class BeansystemAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    	String schoolname = request.getParameter("schoolname");
        String studentnumber = request.getParameter("studentnumber");
        String classnumber = request.getParameter("classnumber");
        String studentname = request.getParameter("studentname");

        StudentListBean bl = new StudentListBean();
        bl.setSchoolName(schoolname);
        bl.setStudentNumber(studentnumber);
        bl.setClassNumber(classnumber);
        bl.setStudentName(studentname);

        request.setAttribute("bl", bl);

        return "Studentsystem.action";
    }
}
