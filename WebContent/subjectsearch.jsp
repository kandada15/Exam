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
    <select name="schoolid">
     <option value="1">広島校</option>
     <option value="2">東京校</option>
     <option value="3">難波校</option>
    </select><br>
    クラス：
    <select name="classid">
     <option value="1">1-31</option>
     <option value="2">2-31</option>
    </select><br>

    <input type="submit" value="表示">

   </form>


   <%
    List<SubjectListBean> list = (List<SubjectListBean>) request.getAttribute("list");
    String schoolid = (String) request.getAttribute("schoolid");
    String classid = (String) request.getAttribute("classid");
    if (list != null) {
  %>

    <h3><%= schoolid %> - <%= classid %>の検索結果：</h3>
    <ul>
      <% for (SubjectListBean subject : list) { %>
        <li>
          科目コード：<%= subject.getSubjectCode() %><br>
          科目名：<%= subject.getSubjectName() %>
        </li>
      <% } %>
    </ul>
      <% if (list.size() == 0) { %>
       <p style="color:red;">一致する科目がありませんでした。</p>
      <% } %>
  <% } %>
  <br>
  <input type="button" value="戻る" onclick="location.href='subjectM.jsp'">

  </body>
  </html>