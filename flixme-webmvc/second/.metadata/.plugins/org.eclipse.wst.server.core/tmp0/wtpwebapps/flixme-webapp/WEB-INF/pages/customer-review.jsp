<%@ include file="./header.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h3>Review</h3>

<ul>
	<c:forEach items="${review}" var="sh">
		<li><a> ${sh.movie.title } : ${sh.description} </a></li>

	</c:forEach>
</ul>
<hr />


<%@ include file="./footer.jspf"%>S
