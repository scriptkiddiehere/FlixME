<%@ include file="./header.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h3>Movie list</h3>

<ul>
	<c:forEach items="${movies}" var="sh">
		<li><a href="./movie-details?id=${sh.id}"> ${sh.title} </a></li>
	</c:forEach>
</ul>
<hr/>
<p>Search by:</p>
<a class="btn btn-primary" href="./search-by-title">title</a>
<a class="btn btn-primary" href="./search-by-genre">genre</a>

<%@ include file="./footer.jspf"%>S