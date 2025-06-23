import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.SubjectListBean;
import tool.Action;

public class SubjectBeanSystemAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    	HttpSession session = request.getSession();
    	String semester = (String) session.getAttribute("semester");

    	String schoolid = request.getParameter("schoolid");
    	String classid = request.getParameter("classid");
    	String subjectcode = request.getParameter("subjectcode");
    	String subjectname = request.getParameter("subjectname");

        SubjectListBean bl = new SubjectListBean();
        bl.setSchoolId(schoolid);
        bl.setClassId(classid);
        bl.setSubjectCode(subjectcode);
    	bl.setSubjectName(subjectname);
    	bl.setSemester(semester);


        request.setAttribute("bl", bl);

        return "SubjectSystem.action";
    }
}
