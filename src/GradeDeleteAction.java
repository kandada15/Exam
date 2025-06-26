import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GradeListDAO;
import tool.Action;

public class GradeDeleteAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response)
        throws Exception {

        try {
        	String semester = (String) request.getSession().getAttribute("semester");  // セッションから学期を取得

        	String schoolid = request.getParameter("schoolid");
        	String classnumber = request.getParameter("classnumber");
        	String studentname = request.getParameter("studentname");
            String subjectname = request.getParameter("subjectname");

            GradeListDAO dao = new GradeListDAO();
            int deletedCount = dao.deleteByName(schoolid, classnumber, studentname, subjectname,semester);

            request.setAttribute("deletedCount", deletedCount);
            request.setAttribute("deletedName", schoolid);
            request.setAttribute("deletedName", classnumber);
            request.setAttribute("deletedName", studentname);
            request.setAttribute("deletedName", subjectname);

            return "gradedelete.jsp";

        } catch (Exception e) {
            e.printStackTrace();

            return "error.jsp";
        }
    }
}
