<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link href="/webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">

<div class="container">
	<p><B>Modify the address book</B></p>
	<br>
	<form:form action="/update-addressbook" modelAttribute="addressbook">
		<form:hidden path="id" />
		<fieldset class="form-group">
			<form:label path="name">Name</form:label>
			<form:input path="name" type="text" class="form-control"
				required="required" />
			<form:errors path="name" cssClass="text-warning" />
		</fieldset>

		<button type="submit" class="btn btn-success">Modify</button>
	</form:form>
</div>