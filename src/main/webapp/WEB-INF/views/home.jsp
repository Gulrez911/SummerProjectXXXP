<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page isELIgnored="false"%>
<html>
<title>Home</title>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<link href='http://fonts.googleapis.com/css?family=Oswald:400,300,700'
	rel='stylesheet' type='text/css'>
<style>
body {
	font-family: 'Georgia', sherif;
}
</style>
</head>
<body>


<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Link</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Dropdown
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="#">Action</a></li>
            <li><a class="dropdown-item" href="#">Another action</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">Something else here</a></li>
          </ul>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
        </li>
      </ul>
      <form class="d-flex">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>







	<div class="container">
		<button onclick="window.location.href='list'" class="btn btn-primary">Student
			List</button>
		${student.fname}
		<table>
			<form:form action="save" modelAttribute="student" method="post">
				<form:hidden path="id" />
<%-- 				<form:hidden path="isDeleted" value="false" /> --%>
				<tr>
					<td>First Name:</td>
					<%-- 					<td><form:input path="fname" /></td> --%>
					<td><input type="text" name="fname" value="${student.fname}"></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<%-- 					<td><form:input path="lname" /></td> --%>
					<td><input type="text" name="lname" value="${student.lname}"></td>
				</tr>
				<tr>
					<td>Email:</td>
					<%-- 					<td><form:input path="email" /></td> --%>
					<td><input type="email" name="email" value="${student.email}"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<%-- 					<td><form:password path="password" /></td> --%>
					<td><input type="password" name="password"
						value="${student.password}"></td>
				</tr>
				<tr>
					<td></td>
					<td><button class="btn btn-primary">Submit</button></td>
				</tr>
			</form:form>

		</table>

	</div>
</body>
</html>
