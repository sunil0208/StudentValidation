
<%--
  Created by IntelliJ IDEA.
  User: sachin
  Date: 11/12/2014
  Time: 3:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang=''>
<head>
    <meta charset='utf-8'>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" href="../styles.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/view/styles.css">
    <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
    <script src="script.js"></script>
    <title>DWIT</title>
    <style type="text/css">
        #formWrapper {
            margin-left: 488px;
            padding: 40px;
            margin-top: -506px;
            border: 1px solid ghostwhite;
            width: 256px;
            background: #B9CEE2;
            border-bottom: 1px solid #BACEE0;
            position: relative;
        }
        input[type="text"] {
            margin-top: 20px;
            height: 26px;
            width: 200px;
            margin-left: 31px;
        }
       #submitWrapper{
           margin-left: 174px;
           margin-top: 14px;
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


        <form action="/Add" method="post">
            <c:if test="${result==false}">
                <p>Error!!Already exist</p>
            </c:if>
            <c:if test="${result==true}">
                <p>Inserted Sucessfully</p>
            </c:if>
            <c:if test="${result==null}">
                <p>Insert Result</p>
            </c:if>
            <input type="text" name="RollNo" placeholder="RollNo" required>
            <c:forEach items = "${Subject.subjectName}" var="SubjectName">
            <input type="text" name="${SubjectName}" placeholder="${SubjectName}" required>
            </c:forEach>
            <div id="submitWrapper"><input type="submit" value="Publish"></div>
    </form>
    </div>

</body>
</html>
