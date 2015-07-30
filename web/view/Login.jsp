<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>

<!DOCTYPE html>
<html lang="en">

	<head>
		<title> Student Result Viewer </title>
		<link rel="stylesheet" href="/view/css/custom.css" />

	</head>
	<div id="mainWrapper">
		<header>
			<div id="headerWrapper">
				<div id="logo">
					<img src="/view/img/dwit_logo.png"/>
				</div>
				<div id="prName">
					<h1>Result Viewer</h1>
				</div>
			</div>
		</header>

		<body>
			<div id="container">

				<form  class="loginForm" method="post" action="/login">
					<fieldset>
						<legend>
							<h2>Login</h2>
						</legend>

						<div class="loginFormInside">

							<input type="text" name="Username" placeholder="Username"required="">
							<br>
							<br>
							<input type="password" name="Password" placeholder="Password" required="">
							<br>
							<br>
							<input type="submit" value="Login">
							<br>
							<br>
                            <br>
							<c:if test="${Result=='failed'}">
								<p class="warn">
									Login Failed Username and Password Did Not Match
								</p>
							</c:if>
						</div>
					</fieldset>
				</form>

			</div>

		</body>

		<footer>

			<div id="footerWrapper">
				<p>
					Copyright &copy; 2015
				</p>
			</div>

		</footer>

	</div>

</html>