<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>学生登録</title>
  <link rel="stylesheet" href="<%= request.getContextPath() %>/css/dashboard-input.css">
</head>
<body>
<div class="container">
  <h2>学生情報の登録</h2>
  <p>学生情報を入力して登録してください。</p>

  <div class="form-card">
    <form action="Beansystem.action" method="POST">
      <label>学校名：</label>
      <select name="schoolid" required>
        <option value="1">広島校</option>
        <option value="2">東京校</option>
        <option value="3">難波校</option>
      </select>

      <label>クラス：</label>
      <div class="radio-group">
             <label><input type="radio" name="classnumber" value="1-31">1-31</label>
             <label><input type="radio" name="classnumber" value="2-31">2-31</label><br>
      </div>


      <label>学生番号：</label>
      <input type="text" name="studentnumber" required>

      <label>学生名：</label>
      <input type="text" name="studentname" required>

      <input type="submit" value="送信">
    </form>
  </div>

  <input type="button" value="学生管理画面へ戻る" onclick="location.href='studentM.jsp'">
</div>
</body>
</html>
