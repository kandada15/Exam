<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String loginUser = (String) session.getAttribute("loginUser");
    if (loginUser == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>総管理画面</title>
</head>
<body>
    <h3> <%= loginUser %> </h3>
    <h2>総管理画面</h2>
    <ul>
        <li><a href="studentM.jsp">学生管理</a></li>
        <li><a href="subjectM.jsp">科目管理</a></li>
        <li><a href="gradeM.jsp">成績管理</a></li>
        <li><a href="login.jsp">ログアウト</a></li>
    </ul>
</body>
</html>
