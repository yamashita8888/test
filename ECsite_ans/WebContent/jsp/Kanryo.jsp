<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>完了画面</title>
</head>
<body>
<center>
<h1>お買い上げありがとうございました！</h1>
<table>
<tr><td>
<form action="http://localhost:8080/ECsite_ans/Back" method="post">
<button type="submit" name="kesu" value="kesuyo">買い物を続ける</button>
</form>
</td>
<td>
<form action="http://localhost:8080/ECsite_ans/logout" method="post">
<input type="submit" value="ログアウト">
</form>
</td></tr>
</table>
</center>
</body>
</html>