<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<% response.setCharacterEncoding("UTF-8"); request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html lang="pl">
	<head>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	    <title><tiles:insertAttribute name="title" /></title>
	    
	    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	
	    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700&amp;subset=latin-ext" rel="stylesheet">
	    <link href="https://fonts.googleapis.com/css?family=Raleway:100,600" rel="stylesheet" type="text/css">
		<link href="https://fonts.googleapis.com/css?family=Montserrat:100,400&amp;subset=cyrillic-ext" rel="stylesheet">
	    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	
	    <link rel="stylesheet" href="<c:url value="/css/style.css" />">
	</head>
	<body>
		<div id="<tiles:insertAttribute name="wrapper" />">
			<tiles:insertAttribute name="header" />
		
			<tiles:insertAttribute name="nav" />
		
			<tiles:insertAttribute name="body" />
			
			<tiles:insertAttribute name="aside" />
			
		    <tiles:insertAttribute name="footer" />
	    </div>
	</body>
</html>