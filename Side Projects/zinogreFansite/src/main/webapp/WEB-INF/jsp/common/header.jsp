<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<c:url var="cssURL" value="/css/zinogreSite.css" />
<link rel="stylesheet" href="${cssURL}" />
<title>Zinogre Fansite!</title>
</head>
<body>
	<header>
		<h1>The Totally Official Zinogre Fansite</h1>
		<c:url var="homeURL" value="/" />
		<c:url var="iconPic" value="/images/zinogre_icon.png" />
		<a href="${homeURL}"><img src="${iconPic}" alt="zinogreIcon"></a>

	</header>
	<div>
		<nav>
			<ul>
				<c:url var="aboutURL" value="/about" />
				<c:url var="galleryURL" value = "/gallery"/>
				<c:url var="storeURL" value="/store" />
				<li><a href="${homeURL}">Home</a></li>
				<li><a href="${aboutURL}">About</a></li>
				<li><a href ="${galleryURL}">Gallery</a></li>
				<li><a href="${storeURL}">Store</a></li>
			</ul>
		</nav>
	</div>