<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.util.List, bean.GradeListBean" %>

<%
    String semester = (String) session.getAttribute("semester");
%>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>表示用</title>
</head>
<body>
    <h2>成績情報検索 - <%= semester %>学期</h2>

    <script>
      function updateSubjectName() {
       var select = document.getElementById("subjectSelect");
       var selectedOption = select.options[select.selectedIndex];
       var codeName = selectedOption.value.split(":");

       document.getElementById("subjectcode").value = codeName[0];
       document.getElementById("subjectname").value = codeName[1];
     }
    </script>
    <p>学校名とクラス名を選択すると、学生番号と学生名を表示出来るはず</p>

    <form action="GradeSearch.action" method="post">
        学校ID：
        <select name="schoolid">
         <option value="1">広島校</option>
         <option value="2">東京校</option>
         <option value="3">難波校</option>
        </select><br>
        クラス：<br>
		<label>
		<input type="radio" name="classnumber" value="1-31">1-31
        </label>
		<label>
		<input type="radio" name="classnumber" value="2-31">2-31
        </label><br><br>
        学生名：<br>
		<input type="text" name="studentname" required><br><br>



        <input type="submit" value="表示"><br>
    </form>




    <%
        List<GradeListBean> list = (List<GradeListBean>) request.getAttribute("list");
        String schoolid = (String) request.getAttribute("schoolid");
        String classnumber = (String) request.getAttribute("classnumber");
        String studentname = (String) request.getAttribute("studentname");
        if (list != null) {
    %>
        <h3><%= schoolid %> - <%= classnumber %> - <%= studentname %>の検索結果：</h3>
        <ul>
        <% for (GradeListBean grade : list) { %>
            <li>
               学校ID：<%= grade.getSchoolId() %> / クラス名：<%=grade.getClassNumber() %> / 学生名：<%= grade.getStudentName() %> / 科目名：<%= grade.getSubjectName() %> / 点数：<%= grade.getScore() %> / 成績：<%= grade.getGrade() %>
            </li>
        <% } %>
        </ul>
        <% if (list.size() == 0) { %>
            <p style="color: red;">情報無し</p>


        <% } %>

       <%
           }
       %><br><br>
        <!-- 平均点出力ボタン -->
        <form action="ClassAverage.action" method="POST">
        クラスを選択して平均点を出力：<br>
        学校名：<br>
		<select name="schoolid">
         <option value="1">広島校</option>
         <option value="2">東京校</option>
         <option value="3">難波校</option>
        </select><br><br>
		クラス：<br>
		<label>
		<input type="radio" name="classnumber" value="1-31">1-31
        </label>
		<label>
		<input type="radio" name="classnumber" value="2-31">2-31
        </label><br><br>
        科目選択：<br>
        <select id="subjectSelect" onchange="updateSubjectName()" required>
         <option value="">-- 選択してください --</option>
         <option value="IT101:プログラミング基礎">IT101 - プログラミング基礎</option>
         <option value="IT102:データベース基礎">IT102 - データベース基礎</option>
         <option value="IT103:ネットワーク基礎">IT103 - ネットワーク基礎</option>
         <option value="IT104:Web開発技術">IT104 - Web開発技術</option>
         <option value="IT105:セキュリティ基礎">IT105 - セキュリティ基礎</option>
         <option value="IT106:アルゴリズムとデータ構造">IT106 - アルゴリズムとデータ構造</option>
         <option value="IT107:オブジェクト指向プログラミング">IT107 - オブジェクト指向プログラミング</option>
         <option value="IT108:クラウドコンピューティング">IT108 - クラウドコンピューティング</option>
         <option value="IT109:モバイルアプリ開発">IT109 - モバイルアプリ開発</option>
         <option value="IT110:機械学習入門">IT110 - 機械学習入門</option>
        </select><br><br>

        <!-- 隠しフィールドでコードと名前を送る -->
        <input type="hidden" name="subjectcode" id="subjectcode">
        <input type="hidden" name="subjectname" id="subjectname">

        <input type="submit" value="平均点出力">
        </form>

       <%-- 平均点がセットされていれば表示 --%>
       <%
            String average = (String) request.getAttribute("average");
            if (average != null) {
       %>
           <h4>選択したクラスの平均点：<%= average %> 点</h4>
        <% } %><br>








    <br>
    <input type="button" value="戻る" onclick="location.href='gradeM.jsp'">
</body>
</html>
