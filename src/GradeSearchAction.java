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
			String SubjectCode = request.getParameter("subjectcode");
			String SubjectName = request.getParameter("subjectname");
//			String StudentName = request.getParameter("studentname");
			GradeListDAO dao = new GradeListDAO();
			List<GradeListBean> list = dao.search(SchoolId, ClassNumber, SubjectCode, SubjectName, Semester);

			request.setAttribute("list", list);
			request.setAttribute("schoolid", SchoolId);
			request.setAttribute("classnumber", ClassNumber);
			request.setAttribute("subjectcode", SubjectCode);
			request.setAttribute("subjectname", SubjectName);
//			request.setAttribute("studentname", StudentName);


			// 平均点を計算してセット
	        if (list != null && !list.isEmpty()) {
	            int total = 0;
	            for (GradeListBean grade : list) {
	                total += Integer.parseInt(grade.getScore());
	            }

	            double average = (double) total / list.size();
	            request.setAttribute("average", String.format("%.1f", average));
	        } else {
	            request.setAttribute("average", "0");
	        }

			return "gradesearch.jsp";

		} catch (Exception e) {
			e.printStackTrace();
			return "error.jsp";
		}
	}
}



