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
			<caption><B>Your Contacts for Address Book : ${addressbook.name}</B></caption>
			<thead>
				<tr>
					<th>Name</th>
					<th>Phone Number</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${addressbook.contacts}" var="contact">
					<tr>
						<td>${contact.name}</td>
						<td>${contact.number}</td>
						<td><a type="button" class="btn btn-success"
							href="/update-contact?id=${contact.id}">Update</a></td>
						<td><a type="button" class="btn btn-warning"
							href="/delete-contact?id=${contact.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<button type="button" class="btn btn-success" onclick="window.location.href='/addressbook/${addressbook.id}/add-contact';">Add Contact</button>
			<button type="button" class="btn btn-warning" onclick="window.location.href='/list-addressbooks';">Back to Address book listings</button>
		</div>
	</div>
