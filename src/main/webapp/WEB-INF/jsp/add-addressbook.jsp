<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link href="/webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
	
<div class="container">
	<ul class="nav navbar-nav navbar-right">
			<li><a href="/logout">Logout</a></li>
	</ul>
	<br>	
	<p><B>Please add an address book </B></p>
	<br>
	<form:form action="/add-addressbook" modelAttribute="addressbook">
		<form:hidden path="id" />
		<fieldset class="form-group">
			<form:label path="name">Name</form:label>
			<form:input path="name" type="text" class="form-control"
				required="required" />
			<form:errors path="name" cssClass="text-warning" />
		</fieldset>

		<button type="submit" class="btn btn-success">Add</button>
		<button type="button" class="btn btn-warning" onclick="window.location.href='/add-addressbook';">Clear</button>
		<button type="button" class="btn btn-warning" onclick="window.location.href='/list-addressbooks';">Back to Address book listings</button>
	</form:form>
</div>