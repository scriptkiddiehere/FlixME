<%@ include file="./header.jspf"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<h3>New users, please register here</h3>

<sf:form modelAttribute="cust" class="w-50">

	<div class="mb-3">
		<label for="name" class="form-label">Name</label>
		<sf:input type="text" class="form-control" id="name" path="name" />
	</div>

	<div class="mb-3">
		<label for="email" class="form-label">Email address</label>
		<sf:input type="email" class="form-control" id="email" path="email" />
	</div>

	<div class="mb-3">
		<label for="password" class="form-label">Password</label>
		<sf:input type="password" class="form-control" id="password"
			path="password" />
	</div>

	<button type="submit" class="btn btn-primary">Register</button>
</sf:form>
<%@ include file="./footer.jspf"%>