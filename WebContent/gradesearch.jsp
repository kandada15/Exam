<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.util.List, bean.GradeListBean" %>
<%
    String semester = (String) session.getAttribute("semester");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>成績情報表示</title>
    <link rel="stylesheet" href="css/dashboard-style.css">
</head>
<body>
<div class="main">
    <h2>成績情報検索 - <%= semester %> 学期</h2>

    <div class="form-box">
        <form action="GradeSearch.action" method="post">
            <label for="schoolid">学校：</label>
            <select name="schoolid" id="schoolid">
                <option value="1">広島校</option>
                <option value="2">東京校</option>
                <option value="3">難波校</option>
            </select><br>

            <label>クラス：</label>
            <div class="radio-group">
             <label><input type="radio" name="classnumber" value="1-31">1-31</label>
             <label><input type="radio" name="classnumber" value="2-31">2-31</label><br>
            </div>

            <label>科目選択：</label>
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
            </select>

            <!-- 隠しフィールドでコードと名前を送る -->
            <input type="hidden" name="subjectcode" id="subjectcode">
            <input type="hidden" name="subjectname" id="subjectname">

            <br><input type="submit" value="検索" class="button">
        </form>
    </div>

    <script>
        function updateSubjectName() {
            var select = document.getElementById("subjectSelect");
            var selectedOption = select.options[select.selectedIndex];
            var codeName = selectedOption.value.split(":");
            document.getElementById("subjectcode").value = codeName[0];
            document.getElementById("subjectname").value = codeName[1];
        }
    </script>

    <%
        List<GradeListBean> list = (List<GradeListBean>) request.getAttribute("list");
        String schoolid = (String) request.getAttribute("schoolid");
        String classnumber = (String) request.getAttribute("classnumber");
        String subjectcode = (String) request.getAttribute("subjectcode");
        String subjectname = (String) request.getAttribute("subjectname");

        if (list != null) {
    %>
        <h3><%= schoolid %> - <%= classnumber %> - <%= subjectcode %> - <%= subjectname %> の検索結果：</h3>

        <%
            if (list.size() > 0) {
        %>
            <table class="styled-table">
                <thead>
                <tr>
                    <th>学校ID</th>
                    <th>クラス名</th>
                    <th>学生名</th>
                    <th>科目名</th>
                    <th>点数</th>
                    <th>成績</th>
                </tr>
                </thead>
                <tbody>
                <% for (GradeListBean grade : list) { %>
                    <tr>
                        <td><%= grade.getSchoolId() %></td>
                        <td><%= grade.getClassNumber() %></td>
                        <td><%= grade.getStudentName() %></td>
                        <td><%= grade.getSubjectName() %></td>
                        <td><%= grade.getScore() %></td>
                        <td><%= grade.getGrade() %></td>
                    </tr>
                <% } %>
                </tbody>
            </table>
        <%
            } else {
        %>
            <p class="warning">情報無し</p>
        <%
            }
        %>

        <%
            String average = (String) request.getAttribute("average");
            if (average != null) {
        %>
            <h4 style="width: 300px; margin: 30px auto 0; border: 1px solid #ccc; padding: 10px; text-align: center; background: #fff;">
                選択したクラスの平均点：<%= average %> 点
            </h4>
        <%
            }
        %>
    <% } %>

    <br><input type="button" value="戻る" class="button" onclick="location.href='gradeM.jsp'">
</div>
</body>
</html>
