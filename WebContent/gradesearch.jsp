<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.util.List, bean.GradeListBean" %>

<%
    String semester = (String) session.getAttribute("semester");
%>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>成績情報表示</title>
</head>
<body>
    <h2>成績情報検索 - <%= semester %>学期</h2>

    <form action="GradeSearch.action" method="post">
        <p>学校とクラスを選択：</p>

        <label for="schoolid">学校：</label>
        <select name="schoolid" id="schoolid">
            <option value="1">広島校</option>
            <option value="2">東京校</option>
            <option value="3">難波校</option>
        </select>

        クラス：<br>
		<label><input type="radio" name="classnumber" value="1-31">1-31</label>
		<label><input type="radio" name="classnumber" value="2-31">2-31</label><br><br>

        学生名：<br>
        <input type="text" name="studentname" required><br><br>

        <input type="submit" value="検索"><br>
    </form>

    <%
        List<GradeListBean> list = (List<GradeListBean>) request.getAttribute("list");
        String schoolid = (String) request.getAttribute("schoolid");
        String classnumber = (String) request.getAttribute("classnumber");
        String studentname = (String) request.getAttribute("studentname");

        if (list != null) {
    %>
        <h3><%= schoolid %> - <%= classnumber %> - <%= studentname %> の検索結果：</h3>
        <ul>
        <% for (GradeListBean grade : list) { %>
            <li>
                学校ID：<%= grade.getSchoolId() %> /
                クラス名：<%= grade.getClassNumber() %> /
                学生名：<%= grade.getStudentName() %> /
                科目名：<%= grade.getSubjectName() %> /
                点数：<%= grade.getScore() %> /
                成績：<%= grade.getGrade() %>
            </li>
        <% } %>
        </ul>

        <% if (list.size() == 0) { %>
            <p style="color: red;">情報無し</p>
        <% } %>

        <!-- 平均点表示 -->
        <%
            String average = (String) request.getAttribute("average");
            if (average != null) {
        %>
            <h4 style="width: 300px; margin: auto; border: 1px solid #ccc; padding: 10px; text-align: center;">
                選択したクラスの平均点：<%= average %> 点
            </h4>
        <% } %>
    <% } %>

    <br><br>
    <input type="button" value="戻る" onclick="location.href='gradeM.jsp'">
</body>
</html>
