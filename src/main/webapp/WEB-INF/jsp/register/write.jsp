<!doctype html>
<!-- 
p.277 [리스트 11.9] 회원가입 화면
 -->
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>글 쓰기</title>
</head>
<body>
	<h2>글 쓰기 입력</h2>
	<form action="./app/register/list" method="post">
		<p>
			제	목:<br> <input type="title" name="title" value="${param.title }">
		</p>
		<p>
			글 내용:<br> <input type="text" name="content" value="${param.content }">
		</p>
		<button type="submit">글 쓰기 완료</button>
	</form>
</body>
</html>