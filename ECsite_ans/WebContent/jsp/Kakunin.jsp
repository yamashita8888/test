<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="web.*"%>
<%
	//商品データ取ってくる
	CartBean CB = new CartBean();
	ArrayList<CartBean> CBlist = new ArrayList<CartBean>();
	CBlist = (ArrayList<CartBean>) session.getAttribute("Cartlist");
	int total = ((Integer)(session.getAttribute("total"))).intValue();
	int tax = ((Integer)(session.getAttribute("tax"))).intValue();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>確認画面</title>
</head>
<body>
<center>
<h1>購入してよろしいでしょうか？？</h1>
<table border=1>
<tr>
<td>消費名</td>
<td>単価</td>
<td>数量</td>
</tr>
<%for(int i=0;i<CBlist.size();i++){ %>
<%CB = CBlist.get(i); %>

<tr>
<td><%=CB.getName() %></td>
<td><%=CB.getPrice() %></td>
<td><%=CB.getKosuu() %></td>
</tr>
<% }%>
<tr><td colspan="2">消費税</td><td><%=tax %></td></tr>
<tr><td colspan="2">合計金額</td><td><%=total %></td></tr>
</table>
<table>
<tr>
<td>
<form action="http://localhost:8080/ECsite_ans/Back" method="post">
<input type="submit" value="いいえ">
</form>
</td>
<td>
<form action="http://localhost:8080/ECsite_ans/Kakunin" method="post">
<input type="submit" value="はい" >
</form>
</td>
</tr>
</table>
</form>
</center>
</body>
</html>