<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>param1.jsp</h2>
	<!--  scriptlet(스크립틀릿): JSP에서 자바코드작성 -->
	<%
		// p1, p2 값 가져오기
		// 스프링: @RequestParam("p1") String p1
		// 순수서블릿 : request.getParameter("p1")
		String p1 = request.getParameter("p1");
		String p2 = request.getParameter("p2");
	%>
	<!-- 스크립틀릿에서 선언한 자바변수값 출력 -->
	<h3>전달받은 값</h3>
	<p><%=p1%></p>
	<p><%=p2%></p>
</body>
</html>