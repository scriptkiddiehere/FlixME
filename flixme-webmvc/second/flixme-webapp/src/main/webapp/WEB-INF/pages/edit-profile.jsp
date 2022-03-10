<%@ include file="./header.jspf"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<h3>Update Balance</h3>

<sf:form class="w-50" modelAttribute="cust">
<sf:hidden path="id" />

	<div class="mb-3">
		<label for="name" class="form-label">Name</label>
		<sf:input type="text" class="form-control" id="name" path="name" />
	</div>
	<div class="mb-3">
		<label for="email" class="form-label">Email</label>
		<sf:input type="text" class="form-control" id="email"  path="email" />
	</div>
	<div class="mb-3">
		<label for="street" class="form-label">Street</label>
		<sf:input type="text" class="form-control" id="street"  path="street" />
	</div>
	<div class="mb-3">
		<label for="city" class="form-label">City</label>
		<sf:input type="text" class="form-control" id="city" path="city" />
	</div>
	<div class="mb-3">
		<label for="state" class="form-label">State</label>
		<sf:input type="text" class="form-control" id="state" path="state" />
	</div>
	<div class="mb-3">
		<label for="pincode" class="form-label">Pincode</label>
		<sf:input type="text" class="form-control" id="pincode" path="pincode" />
	</div>
	<div class="mb-3">
		<label for="country" class="form-label">Country</label>
		<sf:input type="text" class="form-control" id="country" path="country" />
	</div>




	<button type="submit" class="btn btn-primary">Update</button>
</sf:form>
<%@ include file="./footer.jspf"%>