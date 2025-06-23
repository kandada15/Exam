import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.SubjectListBean;
import dao.SubjectListDAO;
import tool.Action;



public class SubjectSearchAction extends Action {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		try{
			String semester = (String) request.getSession().getAttribute("semester");  // セッションから学期を取得

			String SchoolId = request.getParameter("schoolid");
			String ClassId = request.getParameter("classid");

			SubjectListDAO dao = new SubjectListDAO();
			List<SubjectListBean> list = dao.search(SchoolId, ClassId, semester);

			request.setAttribute("list", list);
			request.setAttribute("schoolid", SchoolId);
			request.setAttribute("classid", ClassId);

			return "subjectsearch.jsp";

		} catch (Exception e) {
			e.printStackTrace();
			return "error.jsp";
		}
	}
}



