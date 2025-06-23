import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import tool.Action;

public class SignupAction extends Action {

    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");


        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String semester = request.getParameter("semester");

        // DAOでユーザー登録（例としてUserDAOを仮定）
        UserDAO dao = new UserDAO();

        boolean result = dao.signup(username, password, semester);

        if (result) {
        	// 登録成功時はセッションに情報をセット
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("semester", semester);
            // 成功時：ログイン画面にリダイレクト
            request.setAttribute("message", "ユーザー登録が完了しました!!");

        } else {
            // 失敗時：同じサインアップ画面に戻す
            request.setAttribute("message", "このユーザーは既に登録されています");

        }
        return "signup.jsp";
    }
}
