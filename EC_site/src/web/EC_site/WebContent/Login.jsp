<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="http://localhost:8080/EC_site/loginServlet" method="POST">
<h2>ログイン</h2>
<table>
</tr>
<th>ログインコード</th>
<td><input type="text" name="login_cd"></td>
</tr>
<tr>
<th>パスワード</th>
<td><input type="text" name="login_pw"></td>
</tr>
</table>
<input type="submit" value="LOGIN">
</form>

</body>
</html>