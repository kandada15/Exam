import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.SubjectListBean;
import tool.Action;

public class SubjectBeanSystemAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    	String subjectcode = request.getParameter("subjectcode");
    	String subjectname = request.getParameter("subjectname");
    	String schoolname = request.getParameter("schoolname");
        String classnumber = request.getParameter("classnumber");

        SubjectListBean bl = new SubjectListBean();
        bl.setSubjectCode(subjectcode);
    	bl.setSubjectName(subjectname);
        bl.setSchoolName(schoolname);
        bl.setClassNumber(classnumber);

        request.setAttribute("bl", bl);

        return "SubjectSystem.action";
    }
}
