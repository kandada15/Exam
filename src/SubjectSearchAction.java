

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.SubjectListBean;
import dao.SubjectListDAO;
import tool.Action;



public class SubjectSearchAction extends Action {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		try{
			String SchoolId = request.getParameter("schoolid");
			String ClassNumber = request.getParameter("classnumber");
			SubjectListDAO dao = new SubjectListDAO();
			List<SubjectListBean> list = dao.search(SchoolId, ClassNumber);

			request.setAttribute("subjectlist", list);
			request.setAttribute("schoolid", SchoolId);
			request.setAttribute("classnumber", ClassNumber);

			return "Subject/subjectsearch.jsp";

		} catch (Exception e) {
			e.printStackTrace();
			return "error.jsp";
		}
	}
}



