import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import tool.Action;

public class SignupAction extends Action {

    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // DAOでユーザー登録（例としてUserDAOを仮定）
        UserDAO dao = new UserDAO();

        boolean result = dao.signup(username, password);

        if (result) {
            // 成功時：ログイン画面にリダイレクト
            request.setAttribute("message", "ユーザー登録が完了しました");
            return "login.jsp";
        } else {
            // 失敗時：同じサインアップ画面に戻す
            request.setAttribute("error", "ユーザー登録に失敗しました");
            return "signup.jsp";
        }
    }
}
