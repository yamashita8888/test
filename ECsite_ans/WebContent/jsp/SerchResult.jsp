<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="web.*"%>
<%
	//カテゴリー名用
	CateBean CB = new CateBean();
	ArrayList<CateBean> CBlist = new ArrayList<CateBean>();
	CBlist = (ArrayList<CateBean>) session.getAttribute("catename");

	//商品データ用
	SyoBean SB = new SyoBean();
	ArrayList<SyoBean> SBlist = new ArrayList<SyoBean>();
	SBlist = (ArrayList<SyoBean>) request.getAttribute("syohin");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果</title>
</head>
<body>
	<center>
		<%
			Object msg = request.getAttribute("error");
		%>
		<%
			if (msg != null) {
		%>
		<font color="red"><%=msg%></font>
		<%
			}
		%>

		<h1>検索</h1>
		<form action="http://localhost:8080/ECsite_ans/Serch" method="post">
			<input type="text" name="key"> <br> <select name="cat">
				<option selected></option>

				<%
					for (int i = 0; i < CBlist.size(); i++) {
				%>
				<%
					CB = CBlist.get(i);
				%>
				<option value="<%=CB.getId()%>"><%=CB.getCana()%></option>
				<%
					}
				%>
			</select> <br> <input type="submit" value="検索"> <br>
			<br>
			<table border=1>
				<tr>
					<td>商品名</td>
					<td>価格</td>
					<td>詳細</td>
				</tr>
				<%
					for (int j = 0; j < SBlist.size(); j++) {
				%>
				<%
					SB = SBlist.get(j);
				%>
				<tr>
					<td><%=SB.getProname()%></td>
					<td><%=SB.getProprice()%></td>
					<td><button type="submit" name="syosai"
							value="<%=SB.getProcd()%>">詳細</button></td>
				</tr>
				<%
					}
				%>
			</table>
		</form>
	</center>
</body>
</html>