<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.util.List, bean.StudentListBean" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>表示用</title>
</head>
<body>
    <h2>学生情報検索</h2>
    <p>学校名とクラス名を選択すると、学生番号と学生名を表示出来るはず</p>

    <form action="../Studentsearch.action" method="post">
        学校ID：
        <select name="schoolid">
         <option value="1">広島校</option>
         <option value="2">東京校</option>
         <option value="3">難波校</option>
        </select><br>
        クラス：
        <select name="classnumber">
         <option value="1-31">1-31</option>
         <option value="2-31">2-31</option>
        </select><br>

        <input type="submit" value="表示">
    </form>


    <%
        List<StudentListBean> list = (List<StudentListBean>) request.getAttribute("list");
        String schoolid = (String) request.getAttribute("schoolid");
        String classNumber = (String) request.getAttribute("classnumber");
        if (list != null) {
    %>
        <h3><%= schoolid %> - <%= classNumber %>の検索結果：</h3>
        <ul>
        <% for (StudentListBean student : list) { %>
            <li>
                学生番号：<%= student.getSchoolId() %> / クラス：<%= student.getClassNumber() %> / 学生名：<%= student.getStudentName() %>
            </li>
        <% } %>
        </ul>
        <% if (list.size() == 0) { %>
            <p style="color: red;">情報無し</p>
        <% } %>
    <% } %>

    <br>
    <input type="button" value="総管理画面へ" onclick="location.href='menu.jsp'">
</body>
</html>
