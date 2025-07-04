 import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.StudentListBean;
import dao.StudentListDAO;
import tool.Action;

public class StudentsearchAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
        	String semester = (String) request.getSession().getAttribute("semester");  // セッションから学期を取得

        	String SchoolId = request.getParameter("schoolid");
        	String ClassNumber = request.getParameter("classnumber");

        	StudentListDAO dao = new StudentListDAO();
            List<StudentListBean> list = dao.search(SchoolId, ClassNumber, semester);  // 後述の search() を使用

            request.setAttribute("list", list);
            request.setAttribute("schoolid", SchoolId);
            request.setAttribute("classnumber", ClassNumber);

            return "studentsearch.jsp";

        } catch (Exception e) {
            e.printStackTrace();

            return "error.jsp";
        }
    }
}
