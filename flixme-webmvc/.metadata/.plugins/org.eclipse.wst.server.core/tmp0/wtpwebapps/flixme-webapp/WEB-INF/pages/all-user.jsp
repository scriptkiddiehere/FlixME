<%@ include file="./header.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h3>User list</h3>

<ul>
	<c:forEach items="${user}" var="sh">
		<li><a href="./user-details?id=${sh.id}"> ${sh.name} </a></li>
	</c:forEach>
</ul>
<hr/>


<%@ include file="./footer.jspf"%>S