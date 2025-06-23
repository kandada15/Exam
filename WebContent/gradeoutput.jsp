<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="bean.GradeListBean" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>成績情報の登録確認</title>
</head>
<body>
    <h2>登録情報の確認</h2>
    <h2>登録完了しました！</h2>

    <%
      GradeListBean bl = (GradeListBean) request.getAttribute("bl");
    %>
        <p> 学校：<%= bl.getSchoolId() %></p>
        <p> クラス：<%= bl.getClassNumber() %></p>
        <p> 学生名：<%= bl.getStudentName() %></p>
        <p> 科目名：<%= bl.getSubjectName() %></p>
        <p> 得点：<%= bl.getScore() %></p>
        <p> 成績：<%= bl.getGrade() %></p>

    <br><input type="button" value="もう一度登録" onclick="location.href='gradeinput.html'"><br>
    <br><input type="button" value="戻る" onclick="location.href='gradeM.jsp'"><br>
        <input type="button" value="総管理画面へ" onclick="location.href='menu.jsp'">
</body>
</html>
