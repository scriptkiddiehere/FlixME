<%@ include file="./header.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<ul>
	<c:forEach items="${sh}" var="sh">
		<li><a href="./movie-details?id=${sh.id}"> ${sh.title} </a></li>
	</c:forEach>
</ul>
<%@ include file="./footer.jspf"%> 