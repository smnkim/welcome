<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>
    Register  
</h1>
<form action="registerimpl.nhn" method="post">
<table>
	<tbody>
		<tr>
    		<td>email</td><td><input type="text" name="email"></td>
	    </tr>
	    <tr>
	    	<td>pwd</td><td><input type="password" name="pwd"></td>
	    </tr>
	    <tr>
	        <td>title</td><td><input type="text" name="title"></td>
	    </tr>
	    <tr>
	        <td>content</td><td><textarea cols="30" rows="15" name="content"></textarea></td>
	    </tr>
		<tr>
<!-- 			<td colspan="2"><input type="submit" value="등록"></td> -->
			<td colspan="2"><button type="submit">등록</button></td>
		</tr>
	</tbody>
    
</table>
</form>
