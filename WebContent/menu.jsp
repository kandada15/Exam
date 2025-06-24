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
    <title>統一ダッシュボード</title>
    <style>
        body { margin: 0; font-family: Arial, sans-serif; }
        .container { display: flex; height: 100vh; }
        .sidebar {
            width: 30%;
            background-color: #2c3e50;
            color: white;
            padding: 20px;
            box-sizing: border-box;
        }
        .sidebar h2 { margin-top: 0; }
        .sidebar button {
            display: block; width: 100%; padding: 15px;
            margin-bottom: 15px; background-color: #34495e;
            border: none; color: white; font-size: 16px;
            cursor: pointer; border-radius: 5px;
            transition: background-color 0.3s;
        }
        .sidebar button:hover { background-color: #1abc9c; }
        .main-content {
            width: 70%; padding: 0; box-sizing: border-box;
            background-color: #ecf0f1;
        }
        iframe {
            width: 100%;
            height: 100%;
            border: none;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="sidebar">
        <h2>統一ダッシュボード</h2>
        <p>ユーザー: <%= loginUser %></p>
        <p>学期: <%= session.getAttribute("semester") %></p>

        <button onclick="loadPage('studentM.jsp')">学生管理</button>
        <button onclick="loadPage('subjectM.jsp')">科目管理</button>
        <button onclick="loadPage('gradeM.jsp')">成績管理</button>
        <button onclick="location.href='login.jsp'">ログアウト</button>
    </div>

    <div class="main-content">
        <iframe id="contentFrame" src=""></iframe>
    </div>
</div>

<script>
    function loadPage(page) {
        document.getElementById('contentFrame').src = page;
    }
</script>
</body>
</html>

