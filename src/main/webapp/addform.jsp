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
	
	<form action="add.do" method="post">
		<font color='orange'>☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆<br></font>
		<table border='1px' cellspacing='2' cellpadding='2px' width=500>
			<tr>
				<td>이 름</td>
				<td><input type="text" name="name"></td>
				<td>비밀번호</td>
				<td><input type="password" name="pw"></td>
			</tr>
			<tr>
				<td colspan=4><textarea rows="10" cols="60" name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan=4><input type="submit" value="♬"></td>
			</tr>
		</table>
		<font color='orange'>☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆<br></font>
	</form>
</body>
</html>