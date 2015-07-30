<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <link type = "text/css" rel = "stylesheet" href="/view/LoginPageDesign.css">
    <title>Result</title>
</head>

<body>
<div class="wraper">
    <div class="header">
        <img class="logo" src="../img/logo.png" height="100px" width="100px">
        <h1 class="headtext">Result Viewer</h1>
    </div>

    <div class="box">
        <form method="post" action="/login">
            <h1>DWIT</h1>
            <ul>
                <li><input type="text" name="Username" placeholder="Username"required=""></li>
                <li><p> </p></li>
                <li><input type="password" name="Password" placeholder="Password" required=""></li>
                <li><p> </p></li>
                <li><input type="submit" value="Login"></li>

            </ul>
        </form>



        <c:if test="${Result=='failed'}">
            <ul>
                <li id="text"><p> </p></li>
                <li id="text"><p> </p></li>
                <li id="text"><p class="warn">Login Failed Username and Password Did Not Match</p></li>
            </ul>
        </c:if>

    </div>

    <div class="footer">
        <p> Best Of Luck </p>
    </div>
</div>
</body>
</html>