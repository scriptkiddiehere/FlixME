<%@ include file="./header.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h3>Review</h3>

<ul>
	<c:forEach items="${review}" var="sh">
		<li><a> ${sh.customer.name } : ${sh.description} </a> <a class="btn btn-primary" href="./delete-review?reviewId=${sh.id }">Delete
			Review</a></li>

	</c:forEach>
</ul>
<hr />


<%@ include file="./footer.jspf"%>S
