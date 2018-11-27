<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.javalec.guestbook.vo.GuestBookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="getguestbooklist.do"> 메인으로 돌아가기 </a>
	<br/><br/>
	
	<%
		List<GuestBookVO> result = (List<GuestBookVO>)request.getAttribute("resultList");
	
		Iterator iter = result.iterator();

		if(iter.hasNext()) {
			GuestBookVO g_vo = (GuestBookVO) iter.next();
	%>
			<table border='1px' cellspacing='2' cellpadding='2px' width=500>
				<tr>
					<td><%=g_vo.getNo()%></td>
					<td><%=g_vo.getName()%></td>
					<td><%=g_vo.getDate()%></td>
				</tr>
				<tr>
					<td colspan=3><%=g_vo.getContent()%></td>
				</tr>
			</table>
	<%
		}
	%>

</body>
</html>