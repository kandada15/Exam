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
                "INSERT INTO studentlist (schoolid, studentnumber, classnumber, studentname, semester) VALUES (?, ?, ?, ?, ?)")) {

//        	    st.setString(1, bl.getSchoolName());
        	    st.setString(1, bl.getSchoolId());
                st.setString(2, bl.getStudentNumber());
                st.setString(3, bl.getClassNumber());
                st.setString(4, bl.getStudentName());
                st.setString(5, bl.getSemester());


                st.executeUpdate();
        }

	}




// 削除機能(delete)
public int deleteByName(String schoolid, String classnumber, String studentnumber, String studentname, String semester) throws Exception {
    int count = 0;

    // 書籍名だけですが、著者名でも実行できるようにしたい

    String sql = "DELETE FROM studentlist WHERE schoolid = ? AND classnumber = ? AND studentnumber = ? AND studentname = ? AND semester = ?";

    try (Connection con = getConnection();
         PreparedStatement st = con.prepareStatement(sql)) {

        st.setString(1, schoolid);
        st.setString(2, classnumber);
        st.setString(3, studentnumber);
        st.setString(4, studentname);
        st.setString(5, semester);
        count = st.executeUpdate();
    }

    return count;
}
//
// 検索機能(select)
public List<StudentListBean> search(String SchoolId, String ClassNumber, String semester) throws Exception {
    List<StudentListBean> list = new ArrayList<>();

    try (Connection con = getConnection();
         PreparedStatement st = con.prepareStatement(
             "SELECT * FROM studentlist WHERE schoolid = ? AND classnumber = ? AND semester = ?")) {

//        String likeKeyword = "%" + keyword + "%";
        st.setString(1, SchoolId);
        st.setString(2, ClassNumber);
        st.setString(3, semester);

        ResultSet rs = st.executeQuery();
        while (rs.next()) {
        	StudentListBean bl = new StudentListBean();
//        	bl.setSchoolName(rs.getString("schoolname"));
        	bl.setSchoolId(rs.getString("schoolid"));
            bl.setClassNumber(rs.getString("classnumber"));
            bl.setStudentNumber(rs.getString("studentnumber"));
            bl.setStudentName(rs.getString("studentname"));
            bl.setSemester(rs.getString("semester"));
            list.add(bl);
        }
    }
    return list;
}
}
//
//}
