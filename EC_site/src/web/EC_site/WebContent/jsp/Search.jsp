<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<h2>検索</h2>
<input type="text">
<form action=http://localhost:8080/EC_site/>
カテゴリ
<select name="example">
<option value="選択肢1">家電</option>
<option value="選択肢2">かでん</option>
<option value="選択肢3">カデン</option>
</select><br>
<input type="submit" value="検索">
<table>
<tr>
<th>商品名</th>
<th>価格</th>
<th>詳細</th>
</tr>
<tr>
<td>炊飯器</td>
<td>a</td>
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
</form>
</body>
</html>