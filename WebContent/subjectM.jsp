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
<title>科目管理画面</title>
<link href="css/studentM.css" rel="stylesheet">
</head>
<body>
  <h2>科目管理画面</h2>
  <ul>
   <li><a href="subjectsearch.jsp">科目一覧表示</a></li>
   <li><a href="subjectinput.jsp">科目登録</a></li>
   <li><a href="subjectdelete.jsp">科目削除</a></li>

  </ul>
</body>
</html>