<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>
    Board  
</h1>
<table border="1">
    <tr align="center">
        <td>번호</td>
        <td>제목</td>
        <td>작성자</td>
        <td>최근수정일</td>
        <td>조회수</td>
    </tr>
<c:forEach var="board" items="${boards}">
    <tr align="center">
        <td>${board.no}</td>
        <td><a href="confirmpwd.nhn?no=${board.no }">${board.title}</a></td>
        <td>${board.email}</td>
        <td>${board.latest_time }</td>
        <td>0</td>
    </tr>
</c:forEach>
	<tr>
		<td colspan="5"><a href="register.nhn">글쓰기</a></td>
	</tr>
</table>
