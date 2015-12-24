<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>
    Board  
</h1>
<table border="1">
    <tr align="center">
        <td>no</td>
        <td>title</td>
        <td>writer</td>
        <td>hit</td>
    </tr>
<c:forEach var="board" items="${boards}">
    <tr align="center">
        <td>${board.no}</td>
        <td>${board.title}</td>
        <td>${board.email}</td>
        <td>0</td>
    </tr>
</c:forEach>
	<tr>
		<td colspan="4"><a href="register.nhn">글쓰기</a></td>
	</tr>
</table>
