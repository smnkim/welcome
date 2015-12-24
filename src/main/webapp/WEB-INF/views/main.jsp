<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>BaseCamp.3rd by KSMN</title>
	<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
	
	<style type='text/css'>
    /* 화면 초기화 CSS */
	*{
		margin:0;padding:0;
	}
	a{
		text-decoration: none;
		color: black;
	}
	ul{
		list-style: none;
	}
	 
	/* UI CSS */
	header{
		position: relative;	
		margin: 0 auto;
		width: 900px;
		height: 120px;
	}
	 section{ 
	 	margin: 0 auto; 
	 	width: 900px; 
	 	height: 650px; 
		border-bottom: red 3px solid;
		border-top: red 3px solid;
		
	 }
	footer{
		margin: 0 auto;
		width: 900px;
		height: 60px;
	}
	</style>
</head>
<body>
	<header>
		<jsp:include page="${head}"/>
	</header>
	<section>
		<jsp:include page="${body}"/>
	</section>
	<footer>
		<jsp:include page="${foot}"/>
	</footer>
    
</body>
</html>