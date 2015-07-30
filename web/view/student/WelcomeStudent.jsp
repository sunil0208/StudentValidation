<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sachin
  Date: 10/3/2014
  Time: 10:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" href="/view/custom.css">
    <title></title>

</head>

<body>
<c:if test="${USERNAME==null}">
    <jsp:forward page="../Login.jsp"></jsp:forward>
</c:if>
<c:if test="${USERNAME!=null}">
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
                    <h1>Student Result Viewer</h1>
                </div>
            </div>
        </header>

        <body>
        <div id="container">

            <div id="nav">
                <ul>
                    <li>
                        <a href='/view/student/WelcomeStudent.jsp'>Home</a>
                    </li>

                    <li>
                        <a href="#">See Result</a>
                        <ul>
                            <li>
                                <a href="#">Semester I</a>
                                <ul>
                                    <li>
                                        <a href="/studentdisplay?Semester=First&Examination=Midterm">Midterm</a>
                                    </li>
                                    <li>
                                        <a href="/studentdisplay?Semester=First&Examination=Preboard">Preboard</a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="#">Semester II</a>
                                <ul>
                                    <li>
                                        <a href="/studentdisplay?Semester=Second&Examination=Midterm">Midterm</a>
                                    </li>
                                    <li>
                                        <a href="/studentdisplay?Semester=Second&Examination=Preboard">Preboard</a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="#">Semester III</a>
                                <ul>
                                    <li>
                                        <a href="/studentdisplay?Semester=Third&Examination=Midterm">Midterm</a>
                                    </li>
                                    <li>
                                        <a href="/studentdisplay?Semester=Third&Examination=Midterm">Preboard</a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="#">Semester IV</a>
                                <ul>
                                    <li>
                                        <a href="/studentdisplay?Semester=Fourth&Examination=Midterm">Midterm</a>
                                    </li>
                                    <li>
                                        <a href="/studentdisplay?Semester=Fourth&Examination=Midterm">Preboard</a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="#">Semester V</a>
                                <ul>
                                    <li>
                                        <a href="/studentdisplay?Semester=Fifth&Examination=Midterm">Midterm</a>
                                    </li>
                                    <li>
                                        <a href="/studentdisplay?Semester=Fifth&Examination=Midterm">Preboard</a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="#">Semester VI</a>
                                <ul>
                                    <li>
                                        <a href="/studentdisplay?Semester=Sixth&Examination=Midterm">Midterm</a>
                                    </li>
                                    <li>
                                        <a href="/studentdisplay?Semester=Sixth&Examination=Midterm">Preboard</a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="#">Semester VII</a>
                                <ul>
                                    <li>
                                        <a href="/studentdisplay?Semester=Seventh&Examination=Midterm">Midterm</a>
                                    </li>
                                    <li>
                                        <a href="/studentdisplay?Semester=Seventh&Examination=Midterm">Preboard</a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="#">Semester VIII</a>
                                <ul>
                                    <li>
                                        <a href="/studentdisplay?Semester=Eighth&Examination=Midterm">Midterm</a>
                                    </li>
                                    <li>
                                        <a href="/studentdisplay?Semester=Eighth&Examination=Midterm">Preboard</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href='/logout'>Logout</a>
                    </li>
                </ul>
            </div>
            <!-- end navbar -->

        </div><!--end container-->

        </body>

        <footer>

            <div id="footerWrapper">
                <p>
                    Copyright &copy; 2015
                </p>
            </div>

        </footer>

    </div>

    </c:if>

</body>
</html>


