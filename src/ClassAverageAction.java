import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import tool.Action;

public class ClassAverageAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String classnumber = request.getParameter("classnumber");

        // DB接続
        DAO dao = new DAO();
        Connection con = dao.getConnection(); // ※独自のDB接続クラス

        // 平均点を取得するSQL
        String sql = "SELECT AVG(CAST(score AS DECIMAL)) FROM gradelist WHERE classnumber = ?";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, classnumber);

        ResultSet rs = ps.executeQuery();

        String average = "0";
        if (rs.next()) {
            double avg = rs.getDouble(1);
            average = String.format("%.2f", avg); // 小数点2桁
        }

        rs.close();
        ps.close();
        con.close();

        request.setAttribute("average", average);

        return "gradesearch.jsp";
    }
}
