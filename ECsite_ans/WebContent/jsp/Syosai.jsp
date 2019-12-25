<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="web.*"%>
<%
	//商品データ取ってくる
	SyosaiBean SB = new SyosaiBean();
	ArrayList<SyosaiBean> SBlist = new ArrayList<SyosaiBean>();
	SBlist = (ArrayList<SyosaiBean>) session.getAttribute("syobeanlist");
	String cana = (String) request.getAttribute("cana");
	SB = SBlist.get(0);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>詳細</title>
</head>
<body>
<center>
<h1>商品紹介画面</h1>
<form action="http://localhost:8080/ECsite_ans/Syosai" method="post">
<img src="<%=SB.getImg()%>" >

<table border=1>
<tr><td>商品名</td><td><%=SB.getPro_name() %></td></tr>
<tr><td>カテゴリ名</td><td><%=cana%></td></tr>
<tr><td>価格</td><td><%=SB.getPrice() %></td></tr>
<tr><td>在庫</td><td><%=SB.getStock() %></td></tr>
<tr><td>説明</td><td><%=SB.getMsg() %></td></tr>
</table>
<%int zaiko = Integer.parseInt(SB.getStock()); %>
個数
<select name ="kosuu">
<%for(int i=1;i<=zaiko;i++){ %>
<option value=<%=i %>><%=i %></option>
<%} %>
</select>
<input type="submit" value="カートへ">
</form>
<form action="http://localhost:8080/ECsite_ans/Back" method="post">
<input type="submit" value="戻る">
</form>
</center>
</body>
</html>