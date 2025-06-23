<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>学生情報の削除</title>
</head>
<body>
    <h2>学生情報の削除</h2>

    <p>学生名を入力してください。</p>

    <form action="Studentdelete.action" method="post">
        学校名ID：
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
        学生番号：<br>
		<input type="text" name="studentnumber" required><br><br>
        学生名：<br>
        <input type="text" name="studentname" required><br><br>

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
    <input type="button" value="戻る" onclick="location.href='studentM.jsp'">
</body>
</html>
