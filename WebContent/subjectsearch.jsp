<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.util.List, bean.SubjectListBean" %>
<%
    String semester = (String) session.getAttribute("semester");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>科目一覧の表示</title>
  <link rel="stylesheet" href="css/dashboard-style.css">
</head>
<body>
<div class="main">
  <h2>科目一覧の表示 - <%= semester %> 学期</h2>
  <p>学校名とクラス名を記入⇒科目一覧表示</p>

  <div class="form-box">
    <form action="SubjectSearch.action" method="post">
      <label>学校：</label>
      <select name="schoolid">
        <option value="1">広島校</option>
        <option value="2">東京校</option>
        <option value="3">難波校</option>
      </select>

      <label>クラス：</label><br>
      <div class="radio-group">
             <label><input type="radio" name="classid" value="1">1-31</label>
             <label><input type="radio" name="classid" value="2">2-31</label><br>
            </div>

      <input type="submit" value="表示" class="button">
    </form>
  </div>

  <%
    List<SubjectListBean> list = (List<SubjectListBean>) request.getAttribute("list");
    String schoolid = (String) request.getAttribute("schoolid");
    String classid = (String) request.getAttribute("classid");
    if (list != null) {
  %>
    <h3><%= schoolid %> - <%= classid %> の検索結果：</h3>

    <%
      if (list.size() > 0) {
    %>
      <table class="styled-table">
        <tr>
          <th>科目コード</th>
          <th>科目名</th>
        </tr>
        <% for (SubjectListBean subject : list) { %>
        <tr>
          <td><%= subject.getSubjectCode() %></td>
          <td><%= subject.getSubjectName() %></td>
        </tr>
        <% } %>
      </table>
    <%
      } else {
    %>
      <p class="warning">一致する科目がありませんでした。</p>
    <%
      }
    %>
  <%
    }
  %>

  <br>
  <input type="button" value="戻る" class="button" onclick="location.href='subjectM.jsp'">
</div>
</body>
</html>
