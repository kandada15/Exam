package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO extends DAO {

    // サインアップ処理
    public boolean signup(String username, String password, String semester) throws Exception {
        boolean isRegistered = false;

        // 最初に重複チェック
        if (isUserExists(username, semester)) {
            return false;  // 既に存在するユーザー名は登録させない
        }

        try (Connection con = getConnection();
             PreparedStatement st = con.prepareStatement(
                     "INSERT INTO users (username, password, semester) VALUES (?, ?, ?)")) {

            st.setString(1, username);
            st.setString(2, password);
            st.setString(3, semester);

            int rows = st.executeUpdate();
            if (rows > 0) {
                isRegistered = true;
            }
        }
        return isRegistered;
    }

    // ユーザー名の重複確認
    private boolean isUserExists(String username, String semester) throws Exception {
        boolean exists = false;

        try (Connection con = getConnection();
             PreparedStatement st = con.prepareStatement(
                     "SELECT * FROM users WHERE username = ? AND semester = ?")) {

            st.setString(1, username);
            st.setString(2, semester);

            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    exists = true;
                }
            }
        }
        return exists;
    }
}
