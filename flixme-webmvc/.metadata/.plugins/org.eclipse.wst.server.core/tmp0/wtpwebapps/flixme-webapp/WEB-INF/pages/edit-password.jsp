<%@ include file="./header.jspf"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<h3>Update Balance</h3>

<form class="w-50" method="POST">

	<div class="mb-3">
		<label for="password" class="form-label">Enter password</label> <input
			type="password" class="form-control" id="name" name="password" />
	</div>




	<button type="submit" class="btn btn-primary">Update</button>
</form>
<%@ include file="./footer.jspf"%>