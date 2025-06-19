package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO extends DAO {

    // サインアップ処理
    public boolean signup(String username, String password) throws Exception {
        boolean isRegistered = false;

        // まず重複チェック
        if (isUserExists(username)) {
            return false;  // 既に存在するユーザー名は登録させない
        }

        try (Connection con = getConnection();
             PreparedStatement st = con.prepareStatement(
                     "INSERT INTO users (username, password) VALUES (?, ?)")) {

            st.setString(1, username);
            st.setString(2, password);

            int rows = st.executeUpdate();
            if (rows > 0) {
                isRegistered = true;
            }
        }
        return isRegistered;
    }

    // ユーザー名の重複確認
    private boolean isUserExists(String username) throws Exception {
        boolean exists = false;

        try (Connection con = getConnection();
             PreparedStatement st = con.prepareStatement(
                     "SELECT * FROM users WHERE username = ?")) {

            st.setString(1, username);

            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    exists = true;
                }
            }
        }
        return exists;
    }
}
