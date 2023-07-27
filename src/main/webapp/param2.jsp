<%@page import="com.icia.ex.repository.ExRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>param2.jsp</h2>
	<!--  scriptlet(스크립틀릿): JSP에서 자바코드작성 -->
	<%
		//한글깨짐 처리
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		// int로 형변환 후 age에 저장
		int age = Integer.parseInt(request.getParameter("age"));
		String mobile = request.getParameter("mobile");
		
		//객체 생성
		ExRepository ex = new ExRepository();
		int result = ex.save(name, age, mobile);
		if(result >0){
	%>
	<script>
		alert("저장 성공! index.jsp로 돌아갑니다.")
		location.href = "index.jsp";
	</script>
	<%
		} else {
	%>
	
	<script>
		alert("저장 실패");
	</script>
	<%
		}
	%>
	<!-- 스크립틀릿에서 선언한 자바변수값 출력 -->
	<h3>전달받은 값</h3>
	<p><%=name%></p>
	<p><%=age%></p>
	<p><%=mobile%></p>
</body>
</html>