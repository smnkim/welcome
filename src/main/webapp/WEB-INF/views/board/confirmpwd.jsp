<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>
    비밀번호조회
</h1>
<form action="confirmpwdimpl.nhn" method="post">
<input type="hidden" name="no" value="${no }">
<table>
	<tbody>
		<tr>
    		<td>비밀번호를 입력해주시기바랍니다.</td>
	    </tr>
	    <tr>
	    	<td><input type="password" name="pwd"></td>
	    </tr>
	    <tr>
	    	<td><input type="submit" value="등록"></td>
	    </tr>
	</tbody>
    
</table>
</form>
