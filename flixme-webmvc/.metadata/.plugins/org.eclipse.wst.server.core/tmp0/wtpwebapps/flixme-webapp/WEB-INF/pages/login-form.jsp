<%@ include file="./header.jspf"%>

<h3>login form</h3>



<form method="post" action="./login" class="w-50">



	<div class="mb-3">
		<label for="email" class="form-label">Email address</label> <input
			type="email" class="form-control" id="email" name="email" />
	</div>

	<div class="mb-3">
		<label for="password" class="form-label">Password</label>
		<input type="password" class="form-control" id="password" name="password" />
	</div>

	<button type="submit" class="btn btn-primary">Login</button>
</form>
<%@ include file="./footer.jspf"%>