import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentListDAO;
import tool.Action;

public class StudentdeleteAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response)
        throws Exception {

        try {
            String studentname = request.getParameter("name");

            StudentListDAO dao = new StudentListDAO();
            int deletedCount = dao.deleteByName(studentname);

            request.setAttribute("deletedCount", deletedCount);
            request.setAttribute("deletedName", studentname);

            return "delete.jsp";

        } catch (Exception e) {
            e.printStackTrace();

            return "error.jsp";
        }
    }
}
