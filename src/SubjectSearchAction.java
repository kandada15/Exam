

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.SubjectListBean;
import dao.SubjectListDAO;
import tool.Action;



public class SubjectSearchAction extends Action {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		try{
			String schoolName = request.getParameter("schoolname");
			String classNumber = request.getParameter("classnumber");
			SubjectListDAO dao = new SubjectListDAO();
			List<SubjectListBean> list = dao.search(schoolName, classNumber);

			request.setAttribute("subjectlist", list);
			request.setAttribute("schoolname", schoolName);
			request.setAttribute("classnumber", classNumber);

			return "Subject/subjectsearch.jsp";

		} catch (Exception e) {
			e.printStackTrace();
			return "error.jsp";
		}
	}
}



