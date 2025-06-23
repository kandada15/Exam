import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.GradeListBean;
import dao.GradeListDAO;
import tool.Action;



public class GradeSearchAction extends Action {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		try{
			String Semester = (String) request.getSession().getAttribute("semester");  // セッションから学期を取得

			String SchoolId = request.getParameter("schoolid");
			String ClassNumber = request.getParameter("classnumber");
			String StudentName = request.getParameter("studentname");
			GradeListDAO dao = new GradeListDAO();
			List<GradeListBean> list = dao.search(SchoolId, ClassNumber, StudentName, Semester);

			request.setAttribute("list", list);
			request.setAttribute("schoolid", SchoolId);
			request.setAttribute("classnumber", ClassNumber);
			request.setAttribute("studentname", StudentName);

			return "gradesearch.jsp";

		} catch (Exception e) {
			e.printStackTrace();
			return "error.jsp";
		}
	}
}



