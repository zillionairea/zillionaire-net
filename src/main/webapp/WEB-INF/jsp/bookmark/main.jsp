<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!doctype html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ブックマーク</title>

<c:import url="/WEB-INF/jsp/head.jsp" />
<link href="/css/bookmark.css" rel="stylesheet">

<script type="text/javascript">
<!--
	var actions = {
		E01 : function() {
			$(".input_area").hide();
			$("#invisible_button").hide();
			$("#add_button").show();
		},
		E02 : function() {
			$(".input_area").show();
			$("#invisible_button").show();
			$("#add_button").hide();
		},
		E03 : function() {
			$("#labelIds").val(labels.join());
			$("form").submit();
		},
		E04 : function() {
			// 更新
		},
		E05 : function() {
			// 編集
			$('html,body').animate({ scrollTop: 0 }, 'fast');
			actions.E02();
		},
		E06 : function(id) {
			// 削除
			$('<form/>', {action: '/app/bookmark/delete', method: 'get', name: 'delete'})
			  .append($('<input/>', {type: 'hidden', name: 'bookmarkId', value: id}))
			  .appendTo(document.body)
			  .submit();
		},
		E10 : function(labelId) {
			var btn = $("#label_button_" + labelId);
			if(btn.hasClass("btn-info")) {
				btn.removeClass("btn-info");
				btn.addClass("btn-default");
				
				var index = $.inArray(labelId, labels);
				if (index > -1) {
					labels.splice(index, 1);
				}
				
			} else {
				btn.removeClass("btn-default");
				btn.addClass("btn-info");
				
				labels.push(labelId);
			}
			
			alert(labels.toString());
		},
		E11 : function(labelId) {
			var btn = $("#" + labelId + "_button");
			if(btn.hasClass("btn-danger")) {
				btn.removeClass("btn-danger");
				btn.addClass("btn-default");
				
				$("#" + labelId).val("0");
				
			} else {
				btn.removeClass("btn-default");
				btn.addClass("btn-danger");
				
				$("#" + labelId).val("1");
				
			}
		},
		E12 : function() {
			$.ajax({
				url : $("#url").val(),
				type : "GET",
				timeout : 2000,
				error : function(req, status, e) {
					$("#title").val("タイトル不明");
					$("#description").val("説明無し");
				},
				success : function(res, type) {
					$("#title").val($(res.responseText).filter("title").text());
					var xmlDoc=new DOMParser().parseFromString(res.responseText,"text/xml");
					
					var metas = xmlDoc.getElementsByTagName("meta");
					for (var i = 0; i < metas.length; i++) {
						if (metas[i].getAttribute("name") == "description") {
							//alert(metas[i].getAttribute("content") || metas[i].getAttribute("edit"));
							$("#description").val(metas[i].getAttribute("content") || metas[i].getAttribute("edit"));
						}
					}
				}
			});
		}
	};
	
	var labels = [];
//-->
</script>

</head>

<body>

	<header class="container">
		<h1><a href="/app/bookmark/">Bookmark</a></h1>
	</header>
	<section class="container">
		<div class="row">
			<div class="col-sm-2">
				<div class="label_area">
					<h4>スター</h4>
					<h4>重要</h4>
					<h4>ラベル</h4>
					<c:forEach items="${labelAndBookmarks}" var="labelAndBookmarks">
						<h5><a href="">${labelAndBookmarks.key}</a></h5>
					</c:forEach>
				</div>
			</div>
			<div class="col-sm-10">
				<button type="button" id="add_button" class="btn btn-info btn-xs" style="display: none;" onclick="actions.E02()">追加する</button>
				<button type="button" id="invisible_button" class="btn btn-info btn-xs" onclick="actions.E01()">非表示にする</button>
				<div class="input_area">
					<form:form modelAttribute="bookmarkForm" name="bookmark" action="/app/bookmark/add" method="post">
						<table>
							<tbody>
								<tr>
									<td style="width: 115px;"><form:label path="url" cssErrorClass="error">URL :</form:label></td>
									<td><form:input path="url" onblur="actions.E12()"/><br><form:errors path="url" cssStyle="color:red; font-weight: bold;"/></td>
								</tr>
								<tr>
									<td><form:label path="title" cssErrorClass="error">TITLE :</form:label></td>
									<td><form:input path="title" /></td>
								</tr>
								<tr>
									<td><form:label path="description" cssErrorClass="error">DESCRIPTION :</form:label></td>
									<td><form:textarea path="description" cols="80" rows="2" /></td>
								</tr>
								<tr>
									<td><form:label path="label" cssErrorClass="error">LABEL :</form:label></td>
									<td><form:input path="label" style="width: 200px;" /><br>
									<c:forEach items="${labels}" var="label">
										<button type="button" id="label_button_${label.labelId}" class="btn btn-default btn-xs" onclick="actions.E10('${label.labelId}')">${label.labelName}</button>&nbsp;
									</c:forEach>
								</tr>
								<tr>
									<td><form:label path="star" cssErrorClass="error">MARK :</form:label></td>
									<td><button type="button" id="star_button" class="btn btn-default btn-xs" onclick="actions.E11('star')">スター</button>&nbsp;☆&nbsp;&nbsp;
										<button type="button" id="important_button" class="btn btn-default btn-xs" onclick="actions.E11('important')">重要</button>&nbsp;◎</td>
								</tr>
								<tr>
									<td></td>
									<td><button type="button" class="btn btn-primary btn-sm" onclick="actions.E03()">追加</button>&nbsp;
										<button type="button" class="btn btn-primary btn-sm" onclick="actions.E04()">更新</button></td>
								</tr>
							</tbody>
						</table>
						<form:hidden path="star" />
						<form:hidden path="important" />
						<form:hidden path="labelIds" />
						
					</form:form>
				</div>
				<div class="content">
					<c:forEach items="${labelAndBookmarks}" var="labelAndBookmarks">
						<h5>${labelAndBookmarks.key}</h5>
						<table class="table table-striped table-bordered table-hover table-condensed bookmark">
							<tbody>
								<c:forEach items="${labelAndBookmarks.value}" var="bookmark">
									<tr>
										<td class="star">${bookmark.star ? "☆" : "★"}</td>
										<td class="important">${bookmark.important ? "◎" : "●"}</td>
										<td class="title"><a href="${bookmark.url}" target="_blank"><c:out value="${bookmark.title}" /></a></td>
										<td class="description"><c:out value="${bookmark.description}" /></td>
										<td class="delete"><button type="button" class="btn btn-default btn-xs" onclick="actions.E05()">編集</button>&nbsp;<button type="button" class="btn btn-default btn-xs" onclick="actions.E06('${bookmark.bookmarkId}')">削除</button></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:forEach>
				</div>
			</div>
		</div>
	</section>
	<footer class="container"></footer>

	<c:import url="/WEB-INF/jsp/foot.jsp" />
</body>
</html>
