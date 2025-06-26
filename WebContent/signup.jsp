<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>サインアップ</title>
    <link href="css/signup.css" rel="stylesheet">
</head>
<body>
    <h2>サインアップ</h2>
    <form action="Signup.action" method="post">

        ユーザー名：<input type="text" name="username" required><br><br>

        パスワード：<input type="password" name="password" required><br><br>

        学期を選択：<br>
        <select name="semester">
            <option value="1">一学期</option>
            <option value="2">二学期</option>
        </select><br><br>

        <input type="submit" value="サインアップ">
    </form>

    <p style="color:red;">
        <%= request.getAttribute("message") != null ? request.getAttribute("message") : "" %>
    </p>
    <input type="button" value="ログイン画面へ" onclick="location.href='login.jsp'">
</body>
</html>



