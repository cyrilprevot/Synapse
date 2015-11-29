<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springForm"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Synapse Gaming | Statistiques</title>
    <!-- Meta -->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- CSS -->
    <link rel="shortcut icon" type="image/x-icon" href="<c:url value="/resources/img/favicon.ico" />"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/common.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/home.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/header.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/menu.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/news.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/slider.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/videos.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/blogs.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/achievement.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/recruitment.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/footer.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/JQcalendar.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/raid.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/statistiques.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery.datetimepicker.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery.fancybox.css" />">
    <!-- JS -->
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-2.0.3.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.calendar.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.datetimepicker.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.fancybox.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/raid.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/common.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/statistique.js" />"></script>
</head>
<body>
<div id="page-wrapper">
	<div id="header-wrapper">
		<jsp:include page="portal/Header.jsp"/>
	</div>
	<div id="persistent-menu-wrapper">
		<jsp:include page="portal/PersistentMenu.jsp"/>
	</div>
	<div id="menu-wrapper">
		<jsp:include page="portal/Menu.jsp"/>
	</div>
	<div id="news-wrapper">
		<jsp:include page="portal/News.jsp"/>
	</div>
	<div id="middle-wrapper">
		<div id="middle-container">
			<div class="Stats">
			<div class="TopRace">
			<h3><span>Top des Races</span></h3>
			<c:forEach items="${statsRace}" var="stat">
			<p stattype="race" idtype="${stat.key.id }">${ stat.key.name } : ${ stat.value }</p>
			</c:forEach>
			</div>
			
			<div class="TopClazz">
			<h3><span>Top des Classes</span></h3>
			<c:forEach items="${statsClazz}" var="stat">
     		<p stattype="clazz" idtype="${stat.key.id }">${ stat.key.name } : ${ stat.value }</p>
			</c:forEach>
			</div>
			
			<div class="TopSpec">
			<h3><span>Top des Spécialisations</span></h3>
			<c:forEach items="${statsSpec}" var="stat">
     			<p>${ stat.key.name } : ${ stat.value }</p>
			</c:forEach>
			</div>

		<div class="stats_inf">
			<div class="TopUsers">
			<h3><span>Top des Utilisateurs</span></h3>
			<c:forEach items="${statsUser}" var="stat">
     			<p>${ stat.key.nickname } : ${ stat.value }</p>
			</c:forEach>
			</div>
			
						
			<div class="UsersWithoutAvatar">
			<h3><span>Utilisateurs sans avatar</span></h3>
			<c:forEach items="${statsUsersWithoutAvatar}" var="stat">
     			<p>${ stat.nickname }</p>
			</c:forEach>
			</div>
		</div>

			</div>
		</div>
	</div>
	<div id="footer-wrapper">
		<jsp:include page="portal/Footer.jsp"/>
	</div>
</div>
</body>
</html>