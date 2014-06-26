<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<a href="/app/"><img src="/favicon.ico"  width="25px" height="25px" style="margin-bottom: 18px;"></a>
<span style="font-size: xx-large;"><a href="${param.url}">${param.name}</a></span>
<c:if test="${empty userName}"><a href="/app/bookmark/oauth">認証する</a></c:if>
<c:if test="${!empty userName }">${userName}</c:if>