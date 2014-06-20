<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>情報表示</title>

<c:import url="/WEB-INF/jsp/head.jsp" />

<script type="text/javascript">
<!--
	var actions = {
		E01 : function(id) {
			$(".meigara > *").hide();
			$(".idn_" + id).show();
		},
		E02 : function(id) {
			
		}
	};
//-->
</script>

</head>
<body>

	<header class="container">
		<h3>情報表示</h3>
	</header>
	<section class="container">
		<div class="row">
			<div class="col-sm-3" style="background-color: #ddd">
				<c:import url="/WEB-INF/jsp/info/menu.jsp" />
			</div>
			<div class="col-sm-9" style="background-color: #eee">
				<div class="industory">
					<c:forEach items="${industories}" var="industry" varStatus="index">
						<button type="button" class="btn btn-default btn-xs" style="background-color: #fcc" onclick="actions.E01('${industry.id}')">${industry.name}</button>
					</c:forEach>
				</div>
				<div class="meigara">
					<c:forEach items="${industories}" var="industry" varStatus="index">
						<div class="idn_${industry.id}" style="display: none;">
						<c:forEach items="${industry.stockList}" var="stock" varStatus="index">
							<button type="button" class="btn btn-default btn-xs" style="background-color: #cfc" onclick="actions.E02('${stock.id}')">${stock.name}</button>
						</c:forEach>
						</div>
					</c:forEach>
				</div>
				<div>
					<img src="${pageContext.request.contextPath}/img/html5b.png">
				</div>
			</div>
		</div>
	</section>
	<footer class="container">免責事項など</footer>

	<c:import url="/WEB-INF/jsp/foot.jsp" />
</body>
</html>
