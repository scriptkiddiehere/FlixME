<%@ include file="./header.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<h3>Movie Review</h3>

<table class="table w-50">
	<tr>
		<td>Movie Id:</td>
		<td class="lead">${sh.id}</td>
	</tr>
	<tr>
		<td>Movie name:</td>
		<td class="lead">${sh.title}</td>
	</tr>

</table>


<sf:form modelAttribute="review" class="w-50">
	<sf:hidden path="movie.id"></sf:hidden>
	<div class="mb-3">
		<label for="description" class="form-label">Review</label>
		<sf:input type="text" class="form-control" id="discription"
			path="description" />
	</div>



	<div class="mb-3">
		<label for="rating" class="form-label">rating</label>
		<sf:input type="number" class="form-control" id="rating" path="rating" />
	</div>

	<button type="submit" class="btn btn-primary">ADD</button>
</sf:form>

<%@ include file="./footer.jspf"%>