<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link href="/webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
	
	<div class="container">
		<ul class="nav navbar-nav navbar-right">
			<li><a href="/logout">Logout</a></li>
		</ul>
		<br>
		<table class="table table-striped">
			<caption><B>Your Unique Contacts :</B></caption>
			<thead>
				<tr>
					<th>Name</th>
					<th>Phone Number</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${contacts}" var="contact">
					<tr>
						<td>${contact.name}</td>
						<td>${contact.number}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<button type="button" class="btn btn-warning" onclick="window.location.href='/list-addressbooks';">Back to Address book listings</button>
		</div>
	</div>
