<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>科目情報の削除</title>
</head>
<body>
    <h2>科目情報の削除</h2>

    <p>科目名を入力してください。</p>

    <form action="SubjectDelete.action" method="post">
        科目名：<input type="text" name="subjectname" required><br><br>
        <input type="submit" value="削除">
    </form>

    <%
        Integer deletedCount = (Integer) request.getAttribute("deletedCount");
        String deletedName = (String) request.getAttribute("deletedName");
        if (deletedCount != null && deletedName != null) {
    %>
        <p style="color: blue;">
            「<%= deletedName %>」を <%= deletedCount %> 削除完了
        </p>
    <%
        }
    %>

    <br>
    <input type="button" value="総管理画面へ" onclick="location.href='../menu.jsp'">
</body>
</html>
