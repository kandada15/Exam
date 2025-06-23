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
                "INSERT INTO subjectlist (schoolid, classid, subjectcode, subjectname, semester) VALUES (? ,? ,?, ?, ?)")) {
        	    st.setString(1, bl.getSchoolId());
        	    st.setString(2, bl.getClassId());
//        	    st.setString(3, bl.getSubjectId());
        	    st.setString(3, bl.getSubjectCode());
        	    st.setString(4, bl.getSubjectName());
        	    st.setString(5, bl.getSemester());


                st.executeUpdate();
        }

	}


// 削除機能(delete)
public int deleteByName(String schoolid, String classid, String subjectname, String semester) throws Exception {
    int count = 0;

    // 書籍名だけですが、著者名でも実行できるようにしたい

    String sql = "DELETE FROM subjectlist WHERE schoolid = ? AND classid = ? AND subjectname = ? AND semester = ?";

    try (Connection con = getConnection();
         PreparedStatement st = con.prepareStatement(sql)) {

        st.setString(1, schoolid);
        st.setString(2, classid);
        st.setString(3, subjectname);
        st.setString(4, semester);
        count = st.executeUpdate();
    }

    return count;
}
//
// 検索機能(select)
public List<SubjectListBean> search(String SchoolId, String ClassId, String semester) throws Exception {
    List<SubjectListBean> list = new ArrayList<>();

    try (Connection con = getConnection();
         PreparedStatement st = con.prepareStatement(
             "SELECT * FROM subjectlist WHERE schoolid = ? AND classid = ? AND semester = ?")) {

//        String likeKeyword = "%" + keyword + "%";
        st.setString(1, SchoolId);
        st.setString(2, ClassId);
        st.setString(3, semester);

        ResultSet rs = st.executeQuery();
        while (rs.next()) {
        	SubjectListBean bl = new SubjectListBean();
        	bl.setSchoolId(rs.getString("schoolid"));
        	bl.setClassId(rs.getString("classid"));
//        	bl.setSubjectId(rs.getString("subjectid"));
        	bl.setSubjectCode(rs.getString("subjectcode"));
        	bl.setSubjectName(rs.getString("subjectname"));
        	bl.setSemester(rs.getString("semester"));
            list.add(bl);
        }
    }
    return list;
}
}
//
//}
