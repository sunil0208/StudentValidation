<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sachin
  Date: 10/13/2014
  Time: 2:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <style type="text/css">

        table {
            width: 1036px;
            border: 1px solid black;
            margin-left: 162px;
        }

        tr {
            background-color: ghostwhite;
        }
        td {
            border: 1px solid ghostwhite;
        }
        h3 {
            margin-left: 800px;
        }







    </style>
</head>

<body>
<jsp:include page="/view/student/WelcomeStudent.jsp"></jsp:include>
<div id="tableWrapper">

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
</div>


</body>
</html>
