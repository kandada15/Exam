package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO extends DAO {

    public boolean checkLogin(String username, String password, String semester) throws Exception {
        boolean isValid = false;

        try (Connection con = getConnection();
             PreparedStatement st = con.prepareStatement(
                 "SELECT * FROM users WHERE username = ? AND password = ? AND semester = ?")) {

            st.setString(1, username);
            st.setString(2, password);
            st.setString(3, semester);

            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    isValid = true;
                }
            }
        }

        return isValid;
    }
}

