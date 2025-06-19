<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>成績情報の削除</title>
</head>
<body>
    <h2>成績情報の削除</h2>

    <p>学校名/クラス名/学生名/科目名を選択してください。</p>

    <form action="GradeDelete.action" method="post">
        学校名：<br>
		<select name="schoolid">
         <option value="1">広島校</option>
         <option value="2">東京校</option>
         <option value="3">難波校</option>
        </select><br><br>
        クラス：<br>
		<select name="classnumber">
         <option value="1-31">1-31</option>
         <option value="2-31">2-31</option>
        </select><br><br>
        学生名：<br>
		<input type="text" name="studentname" required><br><br>
        科目名：
        <select name="subjectname" required>
         <option value="井口">井口</option>
         <option value="ひろあき">ひろあき</option>
        </select><br><br>
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
    <input type="button" value="総管理画面へ" onclick="location.href='menu.jsp'">
</body>
</html>
