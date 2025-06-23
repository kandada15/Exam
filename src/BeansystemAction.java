import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.StudentListBean;
import tool.Action;

public class BeansystemAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    	HttpSession session = request.getSession();
    	String semester = (String) session.getAttribute("semester");
//    	String schoolname = request.getParameter("schoolname");
    	String schoolid = request.getParameter("schoolid");
    	String classnumber = request.getParameter("classnumber");
        String studentnumber = request.getParameter("studentnumber");
        String studentname = request.getParameter("studentname");

        StudentListBean bl = new StudentListBean();
//        bl.setSchoolName(schoolname);
        bl.setSchoolId(schoolid);
        bl.setClassNumber(classnumber);
        bl.setStudentNumber(studentnumber);
        bl.setStudentName(studentname);
        bl.setSemester(semester);

        request.setAttribute("bl", bl);

        return "Studentsystem.action";
    }
}
