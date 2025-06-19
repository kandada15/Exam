import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SubjectListDAO;
import tool.Action;

public class SubjectDeleteAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response)
        throws Exception {

        try {
            String subjectname = request.getParameter("subjectname");

            SubjectListDAO dao = new SubjectListDAO();
            int deletedCount = dao.deleteByName(subjectname);

            request.setAttribute("deletedCount", deletedCount);
            request.setAttribute("deletedName", subjectname);

            return "subjectdelete.jsp";

        } catch (Exception e) {
            e.printStackTrace();

            return "error.jsp";
        }
    }
}
