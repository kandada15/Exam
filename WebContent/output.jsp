<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="bean.StudentListBean" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>学生情報の登録確認</title>
</head>
<body>
    <h2>登録情報の確認</h2>

    <%
      StudentListBean bl = (StudentListBean) request.getAttribute("bl");
    %>  
        <p> 学校ID : <%= bl.getSchoolId() %> </p> 
        <p> 学生番号：<%= bl.getStudentNumber() %></p>
        <p> クラス：<%= bl.getClassNumber() %></p>
        <p> 学生名：<%= bl.getStudentName() %></p>

    <br>
        <input type="button" value="総管理画面へ" onclick="location.href='menu.jsp'">
</body>
</html>
