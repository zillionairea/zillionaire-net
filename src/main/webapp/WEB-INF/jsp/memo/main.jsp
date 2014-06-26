<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>メモ</title>

<c:import url="/WEB-INF/jsp/head.jsp" />
<link href="/css/memo.css" rel="stylesheet">

<script type="text/javascript">
<!--
	var actions = {
		E01 : function() {
			$("form").submit();
		},
		E02 : function(id) {
			$('<form/>', {action: '/app/memo/delete', method: 'get', name: 'delete'})
			  .append($('<input/>', {type: 'hidden', name: 'memoId', value: id}))
			  .appendTo(document.body)
			  .submit();
		},
		E03 : function(year, month, day) {
			var formObj = $('<form/>', {action: '/app/memo/search', method: 'get', name: 'search'});
			formObj.append($('<input/>', {type: 'hidden', name: 'year', value: year}));
			if (month) {
				formObj.append($('<input/>', {type: 'hidden', name: 'month', value: month}));
			}
			if (day) {
				formObj.append($('<input/>', {type: 'hidden', name: 'day', value: day}));
			}
			formObj.submit();
		}
	};
//-->
</script>

</head>
<body>

	<header class="container"><c:import url="/WEB-INF/jsp/header.jsp" >
		<c:param name="url" value="/app//app/memo/" />
		<c:param name="name" value="メモ" />
	</c:import></header>
	<section class="container">
		<div class="row">
			<div class="col-sm-1">
				<c:forEach items="${calenderMap}" var="year">
					<span class="year" onclick="actions.E03('${year.key}')"><c:out value="${year.key}" />年</span><br>
					<c:forEach items="${year.value}" var="month">
						<span class="month" onclick="actions.E03('${year.key}','${month.key}')"><c:out value="${month.key}" />月</span><br>
						<c:forEach items="${month.value}" var="day">
							<span class="day" onclick="actions.E03('${year.key}','${month.key}','${day}')"><c:out value="${day}" />日</span><br>
						</c:forEach>
					</c:forEach>
				</c:forEach>
			</div>
			<div class="col-sm-11">
				<div class="input_area">
					<form name="main" action="/app/memo/add" method="post">
						<textarea name="content" cols="140" rows="3"></textarea><br>
						<button class="btn btn-sm" onclick="actions.E01()">保存</button>
					</form>
				</div>
				<c:forEach items="${memos}" var="item">
					<h3><c:out value="${item.key}" /></h3>
					<c:forEach items="${item.value}" var="memo">
						<p><c:out value="${memo.memoContent}" /></p>
						<button class="btn btn-sm" onclick="actions.E02('${memo.memoId}')">削除</button>
						<br>
						<br>
					</c:forEach>
				</c:forEach>
			</div>
		</div>
	</section>
	<footer class="container"></footer>

	<c:import url="/WEB-INF/jsp/foot.jsp" />
</body>
</html>
