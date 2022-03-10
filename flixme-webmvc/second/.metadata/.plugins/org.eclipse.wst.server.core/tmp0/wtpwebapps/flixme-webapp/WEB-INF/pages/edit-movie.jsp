<%@ include file="./header.jspf"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<h3>Update Balance</h3>

<sf:form class="w-50" modelAttribute="movie">
	<sf:hidden path="id" />

	<div class="mb-3">
		<label for="title" class="form-label">Title</label>
		<sf:input type="text" class="form-control" id="title" path="title" />
	</div>
	<div class="mb-3">
		<label for="genre" class="form-label">genre</label>
		<sf:input type="text" class="form-control" id="genre" path="genre" />
	</div>
	<div class="mb-3">
		<label for="rating" class="form-label">rating</label>
		<sf:input type="number" class="form-control" id="rating" path="rating" />
	</div>
	<div class="mb-3">
		<label for="duration" class="form-label">duration</label>
		<sf:input type="number" class="form-control" id="duration"
			path="duration" />
	</div>
	<div class="mb-3">
		<label for="description" class="form-label">description</label>
		<sf:input type="text" class="form-control" id="description"
			path="description" />
	</div>
	<div class="mb-3">
		<label for="releaseYear" class="form-label">releaseYear</label>
		<sf:input type="releaseYear" class="form-control" id="releaseYear"
			path="releaseYear" />
	</div>





	<button type="submit" class="btn btn-primary">Update</button>
</sf:form>
<%@ include file="./footer.jspf"%>