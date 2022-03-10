<%@ include file="./header.jspf"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<h3>Update Balance</h3>

<form class="w-50" method="POST" >

	<div class="mb-3">
		<label for="balance" class="form-label">balance</label>
		<input type="text" class="form-control" id="name" name="balance"  value="${sessionScope.loggedInUser.balance}"/>
	</div>



	<button type="submit" class="btn btn-primary">Update</button>
</form>
<%@ include file="./footer.jspf"%>