<%@ include file="./header.jspf"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<h3>New users, please register here</h3>

<sf:form modelAttribute="mov" class="w-50">

	<div class="mb-3">
		<label for="title" class="form-label">title</label>
		<sf:input type="text" class="form-control" id="title" path="title" />
	</div>



	<div class="mb-3">
		<label for="genre" class="form-label">genre</label>
		<sf:input type="text" class="form-control" id="genre"
			path="genre" />
	</div>

	<button type="submit" class="btn btn-primary">ADD</button>
</sf:form>
<%@ include file="./footer.jspf"%>