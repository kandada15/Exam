import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.GradeListBean;
import dao.GradeListDAO;
import tool.Action;

public class GradeSystemAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    	GradeListBean bl = (GradeListBean) request.getAttribute("bl");

        try {
            GradeListDAO dao = new GradeListDAO();
            dao.insert(bl);

            return "gradeoutput.jsp";

        } catch (Exception e) {
            e.printStackTrace();
            return "error.jsp";
        }
    }
}
