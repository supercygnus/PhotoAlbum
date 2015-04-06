<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ page import="java.util.*,site.photo.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="dao" class="site.photo.dao.OperationData" scope="page"></jsp:useBean>
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
<table cellpadding="0" cellspacing="0" align="center" border="0" height="600px">
<tr>
<td>
<img src="images/10.gif" height="600px" width="9px" />
</td>
<td width="535px" valign="top" background="images/3.jpg">
<% 
List<Photo> list=(List<Photo>)request.getAttribute("list");
for(Photo photo:list){
%>
<table>
<tr height="20px">
<td colspan="2"><%=photo.getPhotoType()%></td>
<td>
<a href="photoservlet?info=queryPhotoList&type=<%=photo.getPhotoType()%>">更多</a>
</td>
</tr>
<tr>
<%
List<Photo> typeList=dao.photo_queryList("photoType='"+photo.getPhotoType()+"'");
int b=0;
for(Photo tphoto:typeList){
%>
<td>
<a href="photoservlet?info=queryOnePhoto&id=<%=tphoto.getId()%>"><img src="<%=tphoto.getPhotoAddress()%>"></a>
</td>
<%	
}
%>
</tr>
</table>
<% 
}
%>
</td>
<td></td>
</tr>
</table>
</body>
</html>