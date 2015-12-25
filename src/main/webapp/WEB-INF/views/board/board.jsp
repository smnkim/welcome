<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript">

function display(data){
	$('#result_area').empty();
	
	var output = '';
	output += '<table >';
	output+='<tr><th>번호</th><th>제목</th><th>작성자</th><th>최근수정일</th></tr>'
	$(data).each(function(index, item){
		output += '<tr>';
			with(item){
				output += '<td ><a href="myboard.nhn?no='+ no +'">' + no + '</a></td>';
				output += '<td><a href="myboard.nhn?no='+ no +'">' + title + '</a></td>';
				output += '<td><a href="myboard.nhn?no='+ no +'">' + writer + '</a></td>';
				output += '<td><a href="myboard.nhn?no='+ no +'">' + date + '</a></td>';
			}
		output += '</tr>';
	});
	output += '<tr><td colspan="4"><a href="register.nhn">글쓰기</a></td></tr>';
	output += '</table>';
	
	$('#result_area').html(output);
	
};


function getData(){
	$.ajax({
	       type : 'get',
	       dataType : 'json',
	       async : 'false',
	       url : 'selectallajax.nhn',
	       success : function(data) {
	          display(data);	          
	       }
	});    
};

$(document).ready(function(){
	getData();
});

</script>

<h1>
    Board  
</h1>
<div id="result_area">

</div>
