<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="web.*" %>
<%
	//カテゴリー名用
	CateBean CB = new CateBean();
	ArrayList<CateBean> CBlist =new ArrayList<CateBean>();
	CBlist = (ArrayList<CateBean>)session.getAttribute("catename");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索画面</title>
</head>
<body>
<center>
<h1>検索</h1>
<form action="http://localhost:8080/ECsite_ans/Serch" method="post">
<input type="text" name="key">
<br>
<select name="cat">
<option selected></option>

<% for(int i=0;i<CBlist.size();i++){%>
<% CB= CBlist.get(i); %>
<option value="<%=CB.getId() %>"><%=CB.getCana() %></option>
<% }%>
</select>
<br>
<input type="submit" value="検索">
</form>
</center>
</body>
</html>