import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.StudentListBean;
import dao.StudentListDAO;
import tool.Action;

public class StudentsystemAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    	StudentListBean bl = (StudentListBean) request.getAttribute("bl");

        try {
            StudentListDAO dao = new StudentListDAO();
            dao.insert(bl);

            return "output.jsp";

        } catch (Exception e) {
            e.printStackTrace();
            return "error.jsp";
        }
    }
}
