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
                "INSERT INTO subjectlist (classid, subjectid, subjectcode, subjectname, schoolname, classnumber) VALUES (? ,? ,?, ?, ?, ?)")) {
        	    st.setString(1, bl.getClassId());
        	    st.setString(2, bl.getSubjectId());
        	    st.setString(3, bl.getSubjectCode());
        	    st.setString(4, bl.getSubjectName());
        	    st.setString(5, bl.getSchoolName());
                st.setString(6, bl.getClassNumber());


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
public List<SubjectListBean> search(String SchoolId, String ClassNumber) throws Exception {
    List<SubjectListBean> list = new ArrayList<>();

    try (Connection con = getConnection();
         PreparedStatement st = con.prepareStatement(
             "SELECT * FROM studentlist WHERE schoolid = ? AND classnumber = ?")) {

//        String likeKeyword = "%" + keyword + "%";
        st.setString(1, SchoolId);
        st.setString(2, ClassNumber);

        ResultSet rs = st.executeQuery();
        while (rs.next()) {
        	SubjectListBean bl = new SubjectListBean();
        	bl.setClassId(rs.getString("classid"));
        	bl.setSubjectId(rs.getString("subjectid"));
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
