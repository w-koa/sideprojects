<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<c:import url="/WEB-INF/jsp/common/header.jsp" />

<head>
<title>Zinogre Fansite - Store</title>
</head>

<h1>Totally Official Zinogre Fansite Store!</h1>
<section>
	<h2>Show your Zinogre Fandom with these great products!</h2>
	<div>
		<table id="storeTable">
			<tr>
				<th></th>
				<th>Name</th>
				<th>Description</th>
				<th>Price</th>
			</tr>
			<c:forEach var="product" items="${productList}">
				<tr>
					<c:url var="picLocation" value="/images/${product.picLocation}" />
					<c:url var="detailURL" value="/detail">
						<c:param name="id" value="${product.id}" />
					</c:url>
					<td><a href="${detailURL}"><img class="storeImage"
							src="${picLocation}"></a></td>
					<td><a href="${detailURL}"><c:out value="${product.name}" /></a></td>
					<td><c:out value="${product.description}" /></td>
					<td><c:out value="$${product.price}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>


</section>





<c:import url="/WEB-INF/jsp/common/footer.jsp" />