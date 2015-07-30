<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sachin
  Date: 9/24/2014
  Time: 9:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang=''>
<head>
    <meta charset='utf-8'>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/view/styles.css">
    <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
    <script src="script.js"></script>
    <title>DWIT</title>

    <style type="text/css">
        #formWrapper {
            margin-left: 300px;
            padding: 31px;
            margin-top: -506px;
            border: 1px solid ghostwhite;
            width: 209px;
            background: #B9CEE2;
            border-bottom: 1px solid #BACEE0;
            position: relative;
        }

        input[type="text"] {
            width: 205px;
            height: 24px;
            margin-top: 18px;
            text-indent: 76px;
        }
        p {
            font-size: 16px;
            text-align: center;
            margin-top: -28px;
        }

    </style>

</head>
<body>
<jsp:include page="/view/WelcomeAdmin.jsp"></jsp:include>
    <div id="formWrapper">
    <form method="post" action="/signup">
        <c:if test="${Result==null}">
            <p>CreateAccount</p>
        </c:if>

        <c:if test="${Result=='Success'}">
            <p>Account Created Sucessfully.</p>
        </c:if>
        <c:if test="${Result=='RollFailed'}">
            <p>Roll Number already Used..</p>
        </c:if>
        <c:if test="${Result=='UsernameFailed'}">
            <p>Username Already Used...</p>
        </c:if>
            <c:forEach items="${Field}" var="fields">
                <input type="text" name="${fields.field}" placeholder="${fields.field}" required="">
            </c:forEach>
            <input type="submit" value="Create">
        </form>

    </div>

</body>
</html>