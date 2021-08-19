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
			<caption><B>Your Address books :</B></caption>
			<thead>
				<tr>
					<th>Name</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${addressbooks}" var="addressbook">
					<tr>
						<td>${addressbook.name}</td>
						<td><a type="button" class="btn btn-success"
							href="/addressbook/${addressbook.id}">Get Contacts from the Address book</a></td>
						<td><a type="button" class="btn btn-success"
							href="/addressbook/${addressbook.id}/add-contact">Add Contact to address book</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<button type="button" class="btn btn-success" onclick="window.location.href='/add-addressbook';">Add Address Book</button>
			<button type="button" class="btn btn-warning" onclick="window.location.href='/list-uniquecontacts';">Get Unique Contacts across all Address Books</button>
		</div>
	</div>
