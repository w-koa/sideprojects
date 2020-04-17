<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

	<head>
	
		<title>ZINOGRE FANSITE - HOME</title>
	</head>
<section>
	<div>
		<h1>Welcome to the Totally Official Zinogre Fansite!</h1>
	</div>
	<div class="wrapper">
		<iframe width="900" height="600" class="responsive" src="https://youtube.com/embed/zHc4Bju0gHg">
				
		</iframe>
	</div>
		<p>Trailer from Playstation official YouTube channel</p>
		<c:url var="aboutURL" value="/about"/>
		<a href="${aboutURL}"><h2>Learn More About Zinogre!</h2></a>
	
</section>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />