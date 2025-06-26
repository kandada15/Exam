<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.util.List, bean.StudentListBean" %>

<%
    String semester = (String) session.getAttribute("semester");
    String loginUser = (String) session.getAttribute("loginUser");
    if (loginUser == null) {
     response.sendRedirect("login.jsp");
     return;
}
%>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>学生情報一覧表示</title>
    <link rel="stylesheet" href="css/dashboard-style.css">
</head>
<body>
    <div class="main">
        <h2>学生情報検索</h2>
        <p>学校名とクラス名を選択すると、学生番号と学生名を表示します。</p>

        <form action="Studentsearch.action" method="post" class="form-box">
            <label>学校ID：
                <select name="schoolid" required>
                    <option value="1">広島校</option>
                    <option value="2">東京校</option>
                    <option value="3">難波校</option>
                </select>
            </label><br><br>

            クラス：<br>
            <div class="radio-group">
             <label><input type="radio" name="classnumber" value="1-31">1-31</label>
             <label><input type="radio" name="classnumber" value="2-31">2-31</label><br>
            </div>

            <input type="submit" value="表示" class="button">
        </form>

        <%
            List<StudentListBean> list = (List<StudentListBean>) request.getAttribute("list");
            String schoolid = (String) request.getAttribute("schoolid");
            String classnumber = (String) request.getAttribute("classnumber");

            if (list != null) {
        %>
            <h3>検索結果：<%= schoolid %> / <%= classnumber %></h3>

            <% if (list.size() == 0) { %>
                <p class="warning">情報無し</p>
            <% } else { %>
                <table class="styled-table">
                    <tr>
                        <th>学校ID</th>
                        <th>学生番号</th>
                        <th>クラス</th>
                        <th>学生名</th>
                    </tr>
                    <% for (StudentListBean student : list) { %>
                        <tr>
                            <td><%= student.getSchoolId() %></td>
                            <td><%= student.getStudentNumber() %></td>
                            <td><%= student.getClassNumber() %></td>
                            <td><%= student.getStudentName() %></td>
                        </tr>
                    <% } %>
                </table>
            <% } %>
        <% } %>

        <br>
        <a href="studentM.jsp" class="button">学生管理画面へ戻る</a>
    </div>
</body>
</html>