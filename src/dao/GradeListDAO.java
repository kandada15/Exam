package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.GradeListBean;
//import bean.StudentListBean;
//import bean.SubjectListBean;

// 入力機能(search)
public class GradeListDAO extends DAO {
public void insert(GradeListBean bl) throws Exception {

        try (Connection con = getConnection();
            PreparedStatement st = con.prepareStatement(
                "INSERT INTO gradelist (schoolid, classnumber, studentname, subjectname, score, grade, semester) VALUES (? ,? ,?, ?, ?, ?, ?)")) {
        	    st.setString(1, bl.getSchoolId());
        	    st.setString(2, bl.getClassNumber());
        	    st.setString(3, bl.getStudentName());
        	    st.setString(4, bl.getSubjectName());
        	    st.setString(5, bl.getScore());
        	    st.setString(6, bl.getGrade());
        	    st.setString(7, bl.getSemester());


                st.executeUpdate();
        }

	}


// 削除機能(delete)
public int deleteByName(String schoolid, String classnumber, String studentname,  String subjectname, String semester) throws Exception {
    int count = 0;

    // 複数の条件で実行できるようにする

    String sql = "DELETE FROM gradelist WHERE schoolid = ? AND classnumber = ? AND studentname = ? AND subjectname = ? AND semester = ?";

    try (Connection con = getConnection();
         PreparedStatement st = con.prepareStatement(sql)) {

    	st.setString(1, schoolid);
    	st.setString(2, classnumber);
    	st.setString(3, studentname);
        st.setString(4, subjectname);
        st.setString(5, semester);
        count = st.executeUpdate();
    }

    return count;
}
//
// 検索機能(select)
public List<GradeListBean> search(String SchoolId, String ClassNumber, String StudentName, String Semester) throws Exception {
    List<GradeListBean> list = new ArrayList<>();

    try (Connection con = getConnection();
         PreparedStatement st = con.prepareStatement(
             "SELECT * FROM gradelist WHERE schoolid = ? AND classnumber = ? AND studentname = ? AND semester = ?")) {

//        String likeKeyword = "%" + keyword + "%";
        st.setString(1, SchoolId);
        st.setString(2, ClassNumber);
        st.setString(3, StudentName);
        st.setString(4, Semester);

        ResultSet rs = st.executeQuery();
        while (rs.next()) {
        	GradeListBean bl = new GradeListBean();
        	bl.setSchoolId(rs.getString("schoolid"));
        	bl.setClassNumber(rs.getString("classnumber"));
//        	bl.setSubjectId(rs.getString("subjectid"));
//        	bl.setSubjectCode(rs.getString("subjectcode"));
        	bl.setStudentName(rs.getString("studentname"));
        	bl.setSubjectName(rs.getString("subjectname"));
        	bl.setScore(rs.getString("score"));
        	bl.setGrade(rs.getString("grade"));
        	bl.setSemester(rs.getString("semester"));
            list.add(bl);
        }
    }
    return list;
}
}
//
//}
