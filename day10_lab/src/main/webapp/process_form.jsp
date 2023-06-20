<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:useBean id="ipl" class="beans.IPLBean" scope="application" />
<jsp:setProperty property="*" name="ipl"/>
<body>
	<%--seesion.getAtrribute("ipl").validatePlayer()--%>
	<h4>${applicationScope.ipl.validatePlayer()}</h4>
</body>
</html>