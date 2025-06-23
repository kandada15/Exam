import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SubjectListDAO;
import tool.Action;

public class SubjectDeleteAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response)
        throws Exception {

        try {
        	String semester = (String) request.getSession().getAttribute("semester");  // セッションから学期を取得

            String schoolid = request.getParameter("schoolid");
            String classid = request.getParameter("classid");
            String subjectname = request.getParameter("subjectname");

            SubjectListDAO dao = new SubjectListDAO();
            int deletedCount = dao.deleteByName(schoolid, classid, subjectname, semester);

            request.setAttribute("deletedCount", deletedCount);
            request.setAttribute("deletedName", schoolid);
            request.setAttribute("deletedName", classid);
            request.setAttribute("deletedName", subjectname);

            return "subjectdelete.jsp";

        } catch (Exception e) {
            e.printStackTrace();

            return "error.jsp";
        }
    }
}
