<%@ include file="./header.jspf"%>

<form method="post" action="./search-by-title" class="w-50">



	<div class="mb-3">
		<label for="title" class="form-label"> Movie Name</label> <input
			type="title" class="form-control" id="title" name="title" />
	</div>


	<button type="submit" class="btn btn-primary">Search</button>
</form>
<%@ include file="./footer.jspf"%>