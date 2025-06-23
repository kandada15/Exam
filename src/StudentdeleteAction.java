import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentListDAO;
import tool.Action;

public class StudentdeleteAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response)
        throws Exception {

        try {
        	String semester = (String) request.getSession().getAttribute("semester");  // セッションから学期を取得

            String schoolid = request.getParameter("schoolid");
            String classnumber = request.getParameter("classnumber");
            String studentnumber = request.getParameter("studentnumber");
            String studentname = request.getParameter("studentname");

            StudentListDAO dao = new StudentListDAO();
            int deletedCount = dao.deleteByName(schoolid, classnumber, studentnumber, studentname, semester);

            request.setAttribute("deletedCount", deletedCount);
            request.setAttribute("deletedName", schoolid);
            request.setAttribute("deletedName", classnumber);
            request.setAttribute("deletedName", studentnumber);
            request.setAttribute("deletedName", studentname);

            return "studentdelete.jsp";

        } catch (Exception e) {
            e.printStackTrace();

            return "error.jsp";
        }
    }
}
