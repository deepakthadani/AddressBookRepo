<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link href="/webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">

<div class="container">
	<ul class="nav navbar-nav navbar-right">
			<li><a href="/logout">Logout</a></li>
	</ul>
	<br>
	<p><B>Modify the contact </B></p>
	<br>
	<form:form action="/update-contact" modelAttribute="contact">
		<form:hidden path="id" />
		<fieldset class="form-group">
			<form:label path="name">Name</form:label>
			<form:input path="name" type="text" class="form-control"
				required="required" />
			<form:errors path="name" cssClass="text-warning" />
		</fieldset>

		<fieldset class="form-group">
			<form:label path="number">Phone Number</form:label>
			<form:input path="number" type="text" class="form-control"
				required="required" />
			<form:errors path="number" cssClass="text-warning" />
		</fieldset>

		<button type="submit" class="btn btn-success">Modify</button>
	</form:form>
</div>