<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
function register(f){
	var regex=/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;   
	
	var cemail = f.email.value;
	var cpwd = f.pwd.value;
	var ctitle = f.title.value;

	if(cemail==null || cemail==''){
		alert('이메일을 입력하세요.');
		f.email.focus();
		return;
	}
	
	if(regex.test(cemail) === false) {  
	    alert("잘못된 이메일 형식입니다.");  
	    return false;  
	}
	
	if(cpwd==null || cpwd==''){
		alert('비밀번호를 입력하세요.');
		f.pwd.focus();
		return;
	};

	if(ctitle==null || ctitle==''){
		alert('제목을 입력하세요.');
		f.title.focus();
		return;
	};

	var c = confirm('등록 하시겠습니까?');
	if(c==true){
		f.action = 'registerimpl.nhn';
		f.method='POST';
		f.submit();
	}
	
};

</script>
<h1>
    Register  
</h1>
<form>
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
			<td colspan="2"><input type="button" value="등록" onclick="register(this.form);"></td>
		</tr>
	</tbody>
    
</table>
</form>
