<%@ include file="./header.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h3>Review details</h3>

<table class="table w-50">

	<tr>
		<td>Review :</td>
		<td class="lead">${sh.description}</td>
	</tr>
	<tr>
		<td>Customer name:</td>
		<td class="lead">${customer.name}</td>
	</tr>
	<tr>
		<td>Movie name:</td>
		<td class="lead">${movie.name}</td>
	</tr>
</table>



<%-- <a class="btn btn-primary" href="./edit-shipper?id=${sh.id}">Edit</a>
<a class="btn btn-danger" href="./delete-shipper?id=${sh.id}">Delete</a> --%>
<%@ include file="./footer.jspf"%>