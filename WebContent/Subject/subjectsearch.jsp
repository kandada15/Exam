<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.util.List, bean.SubjectListBean" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>科目一覧の表示</title>
</head>
<body>
 <h2>科目一覧の表示</h2>
 <p>学校名とクラス名を記入⇒科目一覧表示</p>

 <form action="SubjectSearch.action" method="post">
  学校：
  <select name="schoolname">
   <option value="広島校">広島校</option>
   <option value="東京校">東京校</option>
   <option value="難波校">難波校</option>
  </select><br>
  クラス：
  <select name="classnumber">
   <option value="1-31">1-31</option>
   <option value="2-31">2-31</option>
  </select><br>

  <input type="submit" value="表示">

 </form>


 <%
  List<SubjectListBean> list = (List<SubjectListBean>) request.getAttribute("subjectList");
  if (list != null) {
%>
  <h3>検索結果：</h3>
  <table border="1">
    <tr><th>科目コード</th><th>科目名</th></tr>
    <% for (SubjectListBean sb : list) { %>
      <tr>
        <td><%= sb.getSubjectCode() %></td>
        <td><%= sb.getSubjectName() %></td>
      </tr>
    <% } %>
  </table>
  <% if (list.size() == 0) { %>
    <p style="color:red;">一致する科目がありませんでした。</p>
  <% } %>
<% } %>

<br>
<input type="button" value="戻る" onclick="location.href='../subjectM.jsp'">

</body>
</html>