<%@page import="java.util.Iterator"%>
<%@page import="com.javalec.guestbook.vo.GuestBookVO"%>
<%@page import="java.util.List"%>
<%@page import="com.javalec.guestbook.dao.GuestBookDAO"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 spring</title>
</head>
<body>

<%
	List<GuestBookVO> list = (List<GuestBookVO>)request.getAttribute("list");
// 	String id = (String)request.getSession().getAttribute("Log_ID");
// 	System.out.println("log_id = " + id);	
%>
	<form action="gb" method="post">
		<input type="hidden" name="a" value="logout">
		<input type="submit" value="로그아웃">	
	</form>
	
	<form action="searchkeywordlist.do" method="post">
		<table border=1 width=500>
		<tr>
			<td>검색</td> <td><input type="text" name="searchKeyword" value='${searchKeyword}'></td>
		</tr>
		<tr>
			<td colspan=2 align=right><input type="submit" value="확인"></td>
		</tr>
		</table>
<!-- 		<input type="hidden" name="a" value="searchName"> -->
<!-- 		작성자 이름으로 검색 <input type="text" name="searchname"> -->
<!-- 		<input type="submit" value="검색">	 -->
	</form>
	
	<form action="searchkeywordlist.do" method="post">	
		검색 
		<select name = "searchOption">
			<option value='${search_name}'> 작성자 </option>
			<option value='${search_cnt}'> 글내용 </option>
			<option value='${search_date}'> 작성날짜 </option>
		</select>
		<input type="text" name="keyword" value='${searchKeyword}'>
		<input type="submit" value="검색">	
	</form>
	
	<br>
	<font color='orange'>☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆<br></font>
	
	<form action="addform.do" method="post">
		<input type="submit" value="글작성">	
	</form>
	
	<font color='orange'>☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆<br></font>
	
	<br/>

	<%
		Iterator iter = list.iterator();

		while (iter.hasNext()) {
			GuestBookVO g_vo = (GuestBookVO) iter.next();
	%>
			<table border='1px' cellspacing='2' cellpadding='2px' width=500>
				<tr>
					<td><%=g_vo.getNo()%></td>
					<td><%=g_vo.getName()%></td>
					<td><%=g_vo.getDate()%></td>
					<td><form action="deleteform.do" method="post">
						<input type="hidden" name="no" value="<%=g_vo.getNo()%>">
						<input type="submit" value="삭제"> </form></td>
 					<td><a href="updateform.do?no=<%=g_vo.getNo()%>">수정</a></td>
				</tr>
				<tr>
					<td colspan=4><%=g_vo.getContent()%></td>
					<td><a href="showcontent.do?no=<%=g_vo.getNo()%>">보기</a></td>
				</tr>
			</table>
	<%
		}
	%>
	
	
</body>
</html>