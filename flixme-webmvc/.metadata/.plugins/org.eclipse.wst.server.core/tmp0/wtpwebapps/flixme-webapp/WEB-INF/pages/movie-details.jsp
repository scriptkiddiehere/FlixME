<%@ include file="./header.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h3>Movie details</h3>

<table class="table w-50">

	<tr>
		<td>ID:</td>
		<td class="lead">${sh.id}</td>
	</tr>
	<tr>
		<td>Movie name:</td>
		<td class="lead">${sh.title}</td>
	</tr>
	<tr>
		<td>Movie gerne:</td>
		<td class="lead">${sh.genre}</td>
	</tr>
</table>

<c:choose>
	<c:when test="${sessionScope.loggedInUser.is_Admin!=null}">
		<a class="btn btn-primary" href="./view-review?movieId=${sh.id}">View
			review</a>
		<a class="btn btn-primary" href="./edit-movie?movieId=${sh.id}">Edit
			Movie</a>
			<a class="btn btn-primary" href="./delete-movie?movieId=${sh.id}">Delete
			Movie</a>
	</c:when>
	<c:otherwise>
		<a class="btn btn-primary" href="./add-review?movieId=${sh.id}">Add
			review</a>
	</c:otherwise>
</c:choose>

<%-- <a class="btn btn-primary" href="./edit-shipper?id=${sh.id}">Edit</a>
<a class="btn btn-danger" href="./delete-shipper?id=${sh.id}">Delete</a> --%>
<%@ include file="./footer.jspf"%>