<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="bean.SubjectListBean" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>科目情報の登録確認</title>
</head>
<body>
    <h2>登録情報の確認</h2>
    <h2>登録完了しました！</h2>

    <%
      SubjectListBean bl = (SubjectListBean) request.getAttribute("bl");
    %>
        <p> 学校：<%= bl.getSchoolId() %></p>
        <p> クラス：<%= bl.getClassId() %></p>
        <p> 科目番号：<%= bl.getSubjectCode() %></p>
        <p> 科目名：<%= bl.getSubjectName() %></p>

    <br>
        <br><input type="button" value="もう一度登録" onclick="location.href='subjectinput.jsp'"><br>
        <input type="button" value="戻る" onclick="location.href='subjectM.jsp'">
</body>
</html>
