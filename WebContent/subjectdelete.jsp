<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>科目情報の削除</title>
    <link rel="stylesheet" href="css/dashboard-style.css">
</head>
<body>
<div class="main">
    <h2>科目情報の削除</h2>

    <script>
        function updateSubjectName() {
            var select = document.getElementById("subjectSelect");
            var selectedOption = select.options[select.selectedIndex];
            var codeName = selectedOption.value.split(":");
            document.getElementById("subjectcode").value = codeName[0];
            document.getElementById("subjectname").value = codeName[1];
        }
    </script>

    <div class="form-box">
        <p>削除したい科目を選択してください。</p>
        <form action="SubjectDelete.action" method="post">
            <label>学校名：</label>
            <select name="schoolid" required>
                <option value="1">広島校</option>
                <option value="2">東京校</option>
                <option value="3">難波校</option>
            </select>

            <label>クラス：</label>
            <div class="radio-group">
             <label><input type="radio" name="classid" value="1">1-31</label>
             <label><input type="radio" name="classid" value="2">2-31</label><br>
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

            <br><input type="submit" value="削除" class="button">
        </form>
    </div>

    <%
        Integer deletedCount = (Integer) request.getAttribute("deletedCount");
        String deletedName = (String) request.getAttribute("deletedName");
        if (deletedCount != null && deletedName != null) {
    %>
        <p style="color: blue; text-align: center;">
            「<%= deletedName %>」を <%= deletedCount %> 件削除しました。
        </p>
    <%
        }
    %>

    <br>
    <input type="button" value="戻る" class="button" onclick="location.href='subjectM.jsp'">
</div>
</body>
</html>
