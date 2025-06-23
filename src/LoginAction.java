import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LoginDAO;
import tool.Action;

public class LoginAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String semester = request.getParameter("semester");

        try {
            LoginDAO dao = new LoginDAO();
            boolean isValid = dao.checkLogin(username, password, semester);

            if (isValid) {
                request.getSession().setAttribute("loginUser", username);
                request.getSession().setAttribute("semester", semester);
                return "menu.jsp";  // 学期はセッションから取得するので分けなくてOK
            } else {
                request.setAttribute("error", "ユーザー名・パスワード・学期が一致しません");
                return "login.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "システムエラーが発生しました。");
            return "login.jsp";
        }
    }
}