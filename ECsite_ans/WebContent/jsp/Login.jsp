<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>
<center>
<%Object msg = request.getAttribute("errorlogin");%>
<%if(msg != null){%>
<font color="red"><%=msg %></font>
<%}%>
<h1>ログイン画面</h1>
<form action="http://localhost:8080/ECsite_ans/Login" method="post">
<table>
<tr><td>ユーザーコード</td><td><input type="text" name="name"></td></tr>
<tr><td>パスワード</td><td><input type="password" name="pw"></td></tr>
</table>
<input type="submit" value="ログイン">
</form>
</center>
</body>
</html>