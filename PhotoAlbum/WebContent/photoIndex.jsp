<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<img src="images/1.jpg" width="753px" height="200px">
</div>
<table width="600px" border="0" cellpadding="0" cellspacing="0" align="center">
<tr>
<td></td>
<td>
<font>
<a>相冊首頁</a>||
<c:if test="${sessionScope.userInfo==null}">
<a href="">我的相冊</a>||
</c:if>
<c:if test="${sessionScope.userInfo!=null}">
<a href="">我的相冊</a>||
</c:if>
</font>
</td>
<td></td>
</tr>
</table>
</body>
</html>