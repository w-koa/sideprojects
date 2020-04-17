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
	<div>
		<h1>
			<c:out value="${product.name}" />
		</h1>
	</div>
	<div>
		<c:url var="productPic" value="/images/${product.picLocation}"/>
		<img class="detailImage" src="${productPic}" alt="${product.name} Pic">
		
		<div>
			<h2><c:out value="${product.description}"/></h2>
			<h3><c:out value="$${product.price}"/></h3>
		</div>
		<div>
			<c:url var="cartURL" value="/cart"/>
			<form action="${cartURL}" method="POST">
				<input type="number" name="quantity"/>
				<input type="submit" value="Add to Cart!"/>
			</form>
		</div>
	</div>


</section>





<c:import url="/WEB-INF/jsp/common/footer.jsp" />