<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: sachin
  Date: 9/26/2014
  Time: 8:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang=''>
<head>
 <%--   <meta charset='utf-8'>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    &lt;%&ndash;<link rel="stylesheet" href="/view/styles.css">
    <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
    <script src="script.js"></script>&ndash;%&gt;
    <title>DWIT</title>--%>
    <style type="text/css">
        #formWrapper {
            margin-top: -475px;
            margin-left: 370px;
            height: 174px;
            text-align: center;
            position: relative;
        }

        #tableWrapper{
            margin-left: 42px;
            margin-top: -50px;
        }

        tr {
            background-color: ghostwhite;
        }
        td {
            border: 1px rgb(182, 185, 186);
        }
        h3 {
            margin-left: 800px;
        }

        table {
            width: 960px;
            border: 1px solid black;
            margin-left: 159px;
        }


    </style>
</head>
<body>
 <jsp:include page="/view/WelcomeAdmin.jsp"></jsp:include>
<div id="formWrapper">
    <form method="post" action="/search">
        <h2>See Result</h2>
        <input type="number" name="RollNo" placeholder="RollNo" required="">
        Semester<select name="Semester">
       <%-- <option value="All">All</option>--%>
        <option value="First">First</option>
        <option value="Second">Second</option>
        <option value="Third">Third</option>
        <option value="Fourth">Fourth</option>
        <option value="Fifth">Fifth</option>
        <option value="Sixth">Sixth</option>
        <option value="Seventh">Seventh</option>
        <option value="Eighth">Eighth</option>
    </select>
        Examination<select name="Examination">
       <%-- <option value="All">All</option>--%>
        <option value="Midterm">Midterm</option>
        <option value="Preboard">Preboard</option>

    </select>
        <input type="submit" value="Search">
    </form>
</div>
<div id="tableWrapper">

    <c:if test="${student==true}">
        <c:if test="${marks==true}">
            <table>
                <tr>
                    <td>Name</td>
                    <td>RollNo</td>
                    <td>Batch</td>
                </tr>
                <tr>
                    <td>${Student.name}</td>
                    <td>${Student.rollno}</td>
                    <td>${Student.batch}</td>
                </tr>
            </table>
            <table>
                <tr>
                    <c:forEach items="${Subject.subjectName}" var="SubjectName">
                        <td>
                                ${SubjectName}
                        </td>
                    </c:forEach>
                    <td>Total</td>
                    <td>Percentage</td>
                    <td>Status</td>

                </tr>
                <tr>

                    <c:forEach items="${Subject.marks}" var="subjectMarks">
                        <td>
                                ${subjectMarks}
                        </td>
                    </c:forEach>
                    <td>${Result.total}</td>
                    <td><fmt:formatNumber type="number" maxFractionDigits="3" value="${Result.percentage}" /></td>
                    <td>${Result.status}</td>
                </tr>
            </table>

        </c:if>
        <c:if test="${marks==false}">
            <h3>No Result found!!!!</h3>
        </c:if>
    </c:if>
    <c:if test="${student==false}">
        <h3>No User found!!!</h3>
    </c:if>
</div>

</body>

</html>


