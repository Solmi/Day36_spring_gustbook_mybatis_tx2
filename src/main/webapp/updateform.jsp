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
	System.out.println("[updateform.jsp] no : " + no);
	String noo = (String)request.getAttribute("no");
	System.out.println("[updateform.jsp] noo : " + noo);
%>
	<form action="update.do" method="post">
	<input type="Hidden" name="a" value="update" > <%
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
	<br/> <br/>
	수정내용입력 <textarea rows="10" cols="60" name="content"></textarea> 
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