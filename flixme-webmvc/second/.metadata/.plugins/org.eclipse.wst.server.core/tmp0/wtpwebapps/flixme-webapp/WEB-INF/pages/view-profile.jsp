<%@ include file="./header.jspf"%>
<table class="table w-50">

	<tr>
		<td>Name:</td>
		<td class="lead">${sessionScope.loggedInUser.name}</td>
	</tr>
	<tr>
		<td>Balance</td>
		<td class="lead">${sessionScope.loggedInUser.balance}</td>
	</tr>
	<tr>
		<td>Address</td>
		<td>${sessionScope.loggedInUser.street}
			${sessionScope.loggedInUser.city }
			${sessionScope.loggedInUser.state }
			${sessionScope.loggedInUser.pincode }<br>
			${sessionScope.loggedInUser.country }</td>
	</tr>
</table>
<a class="btn btn-primary" href="./edit-profile"> Edit Profile </a>
<a class="btn btn-primary" href="./edit-password"> Edit Password </a>
<%@ include file="./footer.jspf"%>