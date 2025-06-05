<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.util.List" %><!--必要に応じてbean.bean名-->

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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生管理画面</title>
</head>
<body>
  <h3><%= loginUser %></h3>
  <h2>学生管理画面</h2>
    <ul>
        <li><a href="search.jsp">学生一覧表示</a></li>
        <li><a href="input.html">学生登録</a></li>
        <li><a href="delete.jsp">学生削除</a></li>
        <li><a href="menu.jsp">総管理画面へ</a></li>
    </ul>
</body>
</html>