<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%
    String semester = (String) session.getAttribute("semester");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>学生情報の削除</title>
    <link rel="stylesheet" href="css/dashboard-style.css">
</head>
<body>

<div class="main">
    <h2>学生情報の削除</h2>

    <div class="form-box">
        <p>学生名を入力してください。</p>

        <form action="Studentdelete.action" method="post">
            <label>学校名：</label>
            <select name="schoolid">
                <option value="1">広島校</option>
                <option value="2">東京校</option>
                <option value="3">難波校</option>
            </select><br>

            <label>クラス：</label>
            <div class="radio-group">
             <label><input type="radio" name="classnumber" value="1-31">1-31</label>
             <label><input type="radio" name="classnumber" value="2-31">2-31</label><br>
            </div>

            <label>学生番号：</label>
            <input type="text" name="studentnumber" required><br>

            <label>学生名：</label>
            <input type="text" name="studentname" required><br>

            <input class="button" type="submit" value="削除">
        </form>
    </div>

    <%
        Integer deletedCount = (Integer) request.getAttribute("deletedCount");
        String deletedName = (String) request.getAttribute("deletedName");
        if (deletedCount != null && deletedName != null) {
    %>
    <p style="color: blue;">
        「<%= deletedName %>」を <%= deletedCount %> 件削除しました。
    </p>
    <% } %>

    <button class="button" onclick="location.href='studentM.jsp'">学生管理画面へ戻る</button>
</div>
</body>
</html>
