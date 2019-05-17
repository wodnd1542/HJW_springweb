<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<base href="${pageContext.request.contextPath }/" />

<title>글 조회</title>

</head>
<body>
	<table>
	<tr><td>작성일자 : </td>	<td>${reference.cdate}</td></tr>
	<tr><td>글  번호 : </td>	<td>${reference.articleId}</td></tr>
	<tr><td>학  번 :</td>		<td>${reference.userId}</td></tr>
	<tr><td>이  름 :</td>		<td>${reference.name}</td></tr>
	<tr><td>글 제목 : </td>		<td>${reference.title}</td></tr>
	<tr><td>글 내용 : </td>		<td>${reference.contentHtml}</td></tr>
	</table>
		<a href="./app/articles">[목  록]</a>
</body>
</html>
