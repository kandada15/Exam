import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.StudentListBean;
import dao.StudentListDAO;
import tool.Action;

public class StudentsearchAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
        	String schoolName = request.getParameter("schoolname");
        	String classNumber = request.getParameter("classnumber");
            StudentListDAO dao = new StudentListDAO();
            List<StudentListBean> list = dao.search(schoolName, classNumber);  // 後述の search() を使用

            request.setAttribute("list", list);
            request.setAttribute("schoolname", schoolName);
            request.setAttribute("classnumber", classNumber);

            return "search.jsp";

        } catch (Exception e) {
            e.printStackTrace();

            return "error.jsp";
        }
    }
}
