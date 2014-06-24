<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>トップ</title>

<c:import url="/WEB-INF/jsp/head.jsp" />

</head>
<body>
	<h3>トップ画面</h3>
	
	<a href="/app/memo/">メモアプリ</a>
	<a href="app/info/">株価情報表示アプリ</a>


	<c:import url="/WEB-INF/jsp/foot.jsp" />
</body>
</html>