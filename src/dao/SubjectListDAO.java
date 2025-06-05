package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//import bean.StudentListBean;
import bean.SubjectListBean;

// 入力機能(search)
public class SubjectListDAO extends DAO {
public void insert(SubjectListBean bl) throws Exception {

        try (Connection con = getConnection();
            PreparedStatement st = con.prepareStatement(
                "INSERT INTO subjectlist (subjectcode, subjectname, schoolname, classnumber) VALUES (?, ?, ?, ?)")) {

        	    st.setString(1, bl.getSubjectCode());
        	    st.setString(2, bl.getSubjectName());
        	    st.setString(3, bl.getSchoolName());
                st.setString(4, bl.getClassNumber());


                st.executeUpdate();
        }

	}


// 削除機能(delete)
public int deleteByName(String subjectname) throws Exception {
    int count = 0;

    // 書籍名だけですが、著者名でも実行できるようにしたい

    String sql = "DELETE FROM subjectlist WHERE subjectname = ?";

    try (Connection con = getConnection();
         PreparedStatement st = con.prepareStatement(sql)) {

        st.setString(1, subjectname);
        count = st.executeUpdate();
    }

    return count;
}
//
// 検索機能(select)
public List<SubjectListBean> search(String schoolName, String classNumber) throws Exception {
    List<SubjectListBean> list = new ArrayList<>();

    try (Connection con = getConnection();
         PreparedStatement st = con.prepareStatement(
             "SELECT * FROM studentlist WHERE schoolname = ? AND classnumber = ?")) {

//        String likeKeyword = "%" + keyword + "%";
        st.setString(1, schoolName);
        st.setString(2, classNumber);

        ResultSet rs = st.executeQuery();
        while (rs.next()) {
        	SubjectListBean bl = new SubjectListBean();
        	bl.setSubjectCode(rs.getString("subjectcode"));
        	bl.setSubjectName(rs.getString("subjectname"));
        	bl.setSchoolName(rs.getString("schoolname"));
            bl.setClassNumber(rs.getString("classnumber"));
            list.add(bl);
        }
    }
    return list;
}
}
//
//}
