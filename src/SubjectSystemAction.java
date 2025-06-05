import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import bean.StudentListBean;
import bean.SubjectListBean;
import dao.SubjectListDAO;
import tool.Action;

public class SubjectSystemAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    	SubjectListBean bl = (SubjectListBean) request.getAttribute("bl");

        try {
            SubjectListDAO dao = new SubjectListDAO();
            dao.insert(bl);

            return "subjectoutput.jsp";

        } catch (Exception e) {
            e.printStackTrace();
            return "error.jsp";
        }
    }
}
