<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록4</title>
</head>
<body>
<%
	String no = request.getParameter("no");
	String noo = (String)request.getAttribute("no");
	
	System.out.println("[deleteform] no : " + no);
	System.out.println("[deleteform] noo : " + noo);
	
%>
	<form action="delete.do" method="post">
		<%
		if(noo == null) { %>
			<input type="Hidden" name="no" value="<%=no%>">
		<%	
		} else { %>
			<input type="Hidden" name="no" value="<%=noo%>">
		<%
		}
		%>
	
		비밀번호 입력 <input type="password" name="pw">
		<input type="submit" value="♬">
			<a href="getguestbooklist.do"> 메인으로 돌아가기 </a>
	</form>
	<%
		String msg = (String)request.getAttribute("msg");
	
		if(msg != null){	%>
		<h3> <%=msg%> </h3>
	<%		
		}
	%>
</body>
</html>