<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Style.css" type="text/css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>商品紹介</h2>
<form http://localhost:8080/EC_site/ method="GET">
<table>
<img src="picture/suihanki.jpg">
<tr>
<td>商品名</td>
<td>商品パス</td>
</tr>
<tr>
<td>カテゴリ</td>
<td>調理家電</td>
</tr>
<td>価格</td>
<td>価格パス</td>
</tr>
<tr>
<td>商品紹介</td>
<td>商品紹介パス</td>
</tr>
</table>
個数
<select name="example">
<option value="選択肢1">1</option>
<option value="選択肢2">2</option>
<option value="選択肢3">3</option>
</select>
<input type="submit" value="カートへ">
<input type="submit" value="戻る">
</form>
</body>
</html>