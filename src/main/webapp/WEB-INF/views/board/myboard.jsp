<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>
    MyBoard  
</h1>
<table style="width: 500px;">
	<tbody>
		<tr>
    		<td>email</td><td>${board.email }</td>
	    </tr>
	    <tr>
	        <td>title</td><td>${board.title }</td>
	    </tr>
	    <tr>
	        <td>content</td><td>${board.content }</td>
	    </tr>
		<tr>
			<td>origin_T</td><td>${board.origial_time }</td>
		</tr>	   
		<tr>
			<td>latest_T</td><td>${board.latest_time }</td>
		</tr> 
		<tr>
			<td colspan="2"><a href="confirmpwd.nhn?no=${board.no }">게시글수정</a></td>
		</tr>
	</tbody>
</table>
