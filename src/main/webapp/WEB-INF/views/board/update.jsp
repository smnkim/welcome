<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>
    Update  
</h1>
<form action="updateimpl.nhn" method="post">
<input type="hidden" name=no value="${board.no }">
<table>
	<tbody>
		<tr>
    		<td>email</td><td><input type="text" name="email" value ="${board.email }" disabled="disabled"></td>
	    </tr>
	    <tr>
	        <td>title</td><td><input type="text" name="title" value = "${board.title }"></td>
	    </tr>
	    <tr>
	        <td>content</td><td><textarea cols="30" rows="15" name="content">${board.content }</textarea></td>
	    </tr>
		<tr>
			<td colspan="2"><input type="submit" value="수정"></td>
		</tr>
	</tbody>
    
</table>
</form>
