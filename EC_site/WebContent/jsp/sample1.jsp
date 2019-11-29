<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>検索</h2>
<form action="http://localhost:8080/EC_site/category1" method="POST">
<input type="text">
<input type="submit" value="検索">
<select name="category">
<option value="1">サンプル１</option>
<option value="2">サンプル２</option>
<option value="3">サンプル３</option>
</select><br>
</form>
<table>
<tr>
<th>商品名</th>
<th>価格</th>
<th>詳細</th>
</tr>
<tr>
<td>炊飯器</td>
<td></td>
<td><input type="submit" value="詳細"></td>
</tr>
<tr>
<td>GOD</td>
<td>a</td>
<td><input type="submit" value="詳細"></td>
</tr>
<tr>
<td>パソコン</td>
<td>a</td>
<td><input type="submit" value="詳細"></td>
</tr>
</table>
</body>
</html>