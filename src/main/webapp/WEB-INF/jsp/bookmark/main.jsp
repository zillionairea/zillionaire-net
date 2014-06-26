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
			// 追加
			$("#labelIds").val(labels.join());
			$("form").attr("action", "/app/bookmark/add");
			$("form").submit();
		},
		E04 : function() {
			// 更新
			$("#labelIds").val(labels.join());
			$("form").attr("action", "/app/bookmark/update");
			$("form").submit();
		},
		E05 : function(bookmarkId, url, title, description, labelIdsValue, star, important) {
			// 編集
			$("#bookmarkId").val(bookmarkId);
			$("#url").val(url);
			$("#title").val(title);
			$("#description").val(description);
			
			var star_button = $("#star_button");
			if (star) {
				star_button.removeClass("btn-default");
				star_button.addClass("btn-danger");
				$("#star").val("1");
			} else {
				star_button.removeClass("btn-danger");
				star_button.addClass("btn-default");
				$("#star").val("0");
			}
			
			$("#label_buttons > *").removeClass("btn-info");
			$("#label_buttons > *").addClass("btn-default");
			labels = [];
			
			var labelIds = labelIdsValue.split(',');
			for (var i = 0; i < labelIds.length; i++) {
				$("#label_button_" + labelIds[i]).removeClass("btn-default");
				$("#label_button_" + labelIds[i]).addClass("btn-info");
				labels.push(labelIds[i]);
			}
			
			var important_button = $("#important_button");
			if (important) {
				important_button.removeClass("btn-default");
				important_button.addClass("btn-danger");
				$("#important").val("1");
			} else {
				important_button.removeClass("btn-danger");
				important_button.addClass("btn-default");
				$("#important").val("0");
			}
			
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
		E07 : function() {
			// 検索
			$('<form/>', {action: '/app/bookmark/select', method: 'get', name: 'select'})
			  .append($('<input/>', {type: 'hidden', name: 'star', value: "1"}))
			  .appendTo(document.body)
			  .submit();
		},
		E08 : function() {
			// 検索
			$('<form/>', {action: '/app/bookmark/select', method: 'get', name: 'select'})
			  .append($('<input/>', {type: 'hidden', name: 'important', value: "1"}))
			  .appendTo(document.body)
			  .submit();
		},
		E09 : function(labelId) {
			// 検索
			$('<form/>', {action: '/app/bookmark/select', method: 'get', name: 'select'})
			  .append($('<input/>', {type: 'hidden', name: 'labelId', value: labelId}))
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
							$("#description").val(metas[i].getAttribute("content") || metas[i].getAttribute("edit"));
						}
					}
				}
			});
		},
		E13 : function(bookmarkId, labelId, url) {
			utils.countUp(bookmarkId, labelId);
			window.open(url, "_new");
		},
		E14 : function(bookmarkId, starOrImportant) {
			
			var mark = starOrImportant ? "star_" : "important_";
			var target = $("#mark_" + mark + bookmarkId);
			var updateValue = target.hasClass("on") ? "0" : "1";
			var param = starOrImportant ? "star" : "important";
			
			$.ajax({
				url : "/app/bookmark/updateMark?bookmarkId=" + bookmarkId + "&" + param + "=" + updateValue,
				type : "GET",
				timeout : 2000,
				async : true,
				error : function(req, status, e) {
					alert("updateMark error !!!");
				},
				success : function(res, type) {
					if(target.hasClass("on")) {
						target.removeClass("on");
						target.addClass("off");
					} else {
						target.removeClass("off");
						target.addClass("on");
					}
				}
			});
		}
	};
	
	var utils = {
		countUp : function(bookmarkId, labelId) {
			$.ajax({
				url : "/app/bookmark/countUp?bookmarkId=" + bookmarkId + "&labelId=" + labelId,
				type : "GET",
				timeout : 2000,
				async : true,
				error : function(req, status, e) {
				},
				success : function(res, type) {
				}
			});
		},
		test : function() {
			$("#label_buttons > *").removeClass("btn-info");
			$("#label_buttons > *").addClass("btn-default");
			labels = [];
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
					<h4><a href="#" onclick="actions.E07()">スター</a></h4>
					<h4><a href="#" onclick="actions.E08()">重要</a></h4>
					<h4>ラベル</h4>
					<c:forEach items="${labels}" var="labels">
						<h5><a href="#" onclick="actions.E09('${labels.labelId}')">${labels.labelName}</a><span class="count">&nbsp<c:if test="${labels.labelId > 0}">(${labels.labelId}, ${labels.useCount})</c:if></span></h5>
					</c:forEach>
				</div>
			</div>
			<div class="col-sm-10">
				<button type="button" id="add_button" class="btn btn-info btn-xs" onclick="actions.E02()">ブックマークを追加する</button>
				<button type="button" id="invisible_button" class="btn btn-info btn-xs" style="display: none;" onclick="actions.E01()">入力エリアを非表示にする</button>
				<div class="input_area" style="display: none; margin-top: 2px;">
					<form:form modelAttribute="bookmarkForm" name="bookmark" action="" method="post">
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
									<span id="label_buttons">
									<c:forEach items="${labels}" var="label">
										<c:if test="${label.labelId > 0 }">
											<button type="button" id="label_button_${label.labelId}" class="btn btn-default btn-xs" onclick="actions.E10('${label.labelId}')">${label.labelName}</button>&nbsp;
										</c:if>
									</c:forEach>
									</span>
								</tr>
								<tr>
									<td><form:label path="star" cssErrorClass="error">MARK :</form:label></td>
									<td><button type="button" id="star_button" class="btn btn-default btn-xs" onclick="actions.E11('star')">スター</button>&nbsp;<span class="on">★</span>&nbsp;&nbsp;
										<button type="button" id="important_button" class="btn btn-default btn-xs" onclick="actions.E11('important')">重要</button>&nbsp;<span class="on">◆</span></td>
								</tr>
								<tr>
									<td></td>
									<td><button type="button" class="btn btn-primary btn-sm" onclick="actions.E03()">追加</button>&nbsp;
										<button type="button" class="btn btn-primary btn-sm" onclick="actions.E04()">更新</button></td>
								</tr>
							</tbody>
						</table>
						<form:hidden path="bookmarkId" />
						<form:hidden path="star" />
						<form:hidden path="important" />
						<form:hidden path="labelIds" />
						
					</form:form>
				</div>
				<div class="content">
					<c:forEach items="${labelAndBookmarks}" var="labelAndBookmarks">
						<h5>${labelAndBookmarks.key[1]}</h5>
						<table class="table table-striped table-bordered table-hover table-condensed bookmark">
							<tbody>
								<c:forEach items="${labelAndBookmarks.value}" var="bookmark">
									<tr>
										<td id="mark_star_${bookmark.bookmarkId}" class="star ${bookmark.star ? 'on' : 'off'}"><span class="mark" onclick="actions.E14('${bookmark.bookmarkId}', true)">★</span></td>
										<td id="mark_important_${bookmark.bookmarkId}" class="important ${bookmark.important ? 'on' : 'off'}"><span class="mark" onclick="actions.E14('${bookmark.bookmarkId}', false)">◆</span></td>
										<td class="title"><a href="#" onclick="actions.E13('${bookmark.bookmarkId}', '${labelAndBookmarks.key[0]}', '${bookmark.url}')"><c:out value="${bookmark.title}" /></a><span class="count">&nbsp(${bookmark.bookmarkId},${bookmark.useCount})</span></td>
										<td class="description"><c:out value="${bookmark.description}" /></td>
										<td class="delete"><button type="button" class="btn btn-default btn-xs" onclick="actions.E05('${bookmark.bookmarkId}', '${bookmark.url}', '${bookmark.title}', '${bookmark.description}', '${bookmark.joinedLabelIds}', ${bookmark.star}, ${bookmark.important})">編集</button>&nbsp;<button
											type="button" class="btn btn-default btn-xs" onclick="actions.E06('${bookmark.bookmarkId}')">削除</button></td>
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
