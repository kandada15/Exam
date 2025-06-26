<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>ログイン</title>
    <link href="css/login.css" rel="stylesheet">
</head>
<body>
    <h2>ログイン</h2>
    <form action="Login.action" method="post">

        ユーザー名：<input type="text" name="username" required><br><br>
        パスワード：<input type="password" name="password" required><br><br>
        学期：<select name="semester">
         <option value="1">一学期</option>
         <option value="2">二学期</option>
        </select><br><br>

        <input type="submit" value="ログイン">
    </form><br>
    <input type="button" value="未登録の方はこちら" onclick="location.href='signup.jsp'">

    <p style="color:red;">
        <%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %>
    </p>
</body>
</html>



