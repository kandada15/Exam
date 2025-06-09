package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.StudentListBean;

// 入力機能(search)
public class StudentListDAO extends DAO {
public void insert(StudentListBean bl) throws Exception {

        try (Connection con = getConnection();
            PreparedStatement st = con.prepareStatement(
                "INSERT INTO studentlist (schoolid, studentnumber, studentname, classnumber) VALUES (?, ?, ?, ?)")) {

//        	    st.setString(1, bl.getSchoolName());
        	    st.setString(1, bl.getSchoolId());
                st.setString(2, bl.getStudentNumber());
                st.setString(3, bl.getClassNumber());
                st.setString(4, bl.getStudentName());


                st.executeUpdate();
        }

	}


// 削除機能(delete)
public int deleteByName(String studentname) throws Exception {
    int count = 0;

    // 書籍名だけですが、著者名でも実行できるようにしたい

    String sql = "DELETE FROM studentlist WHERE studentname = ?";

    try (Connection con = getConnection();
         PreparedStatement st = con.prepareStatement(sql)) {

        st.setString(1, studentname);
        count = st.executeUpdate();
    }

    return count;
}
//
// 検索機能(select)
public List<StudentListBean> search(String SchoolId, String ClassNumber) throws Exception {
    List<StudentListBean> list = new ArrayList<>();

    try (Connection con = getConnection();
         PreparedStatement st = con.prepareStatement(
             "SELECT * FROM studentlist WHERE schoolid = ? AND classnumber = ?")) {

//        String likeKeyword = "%" + keyword + "%";
        st.setString(1, SchoolId);
        st.setString(2, ClassNumber);

        ResultSet rs = st.executeQuery();
        while (rs.next()) {
        	StudentListBean bl = new StudentListBean();
//        	bl.setSchoolName(rs.getString("schoolname"));
        	bl.setSchoolId(rs.getString("schoolid"));
            bl.setStudentNumber(rs.getString("studentnumber"));
            bl.setClassNumber(rs.getString("classnumber"));
            bl.setStudentName(rs.getString("studentname"));
            list.add(bl);
        }
    }
    return list;
}
}
//
//}
