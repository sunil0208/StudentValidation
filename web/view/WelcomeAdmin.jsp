<%--
  Created by IntelliJ IDEA.
  User: sachin
  Date: 12/29/2014
  Time: 8:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<c:if test="${USERNAME==null}">
    <jsp:forward page="/view/Login.jsp"></jsp:forward>
</c:if>
<c:if test="${USERNAME!=null&&Role=='user'}">
    <jsp:forward page="/view/student/WelcomeStudent.jsp"></jsp:forward>
</c:if>

<c:if test="${USERNAME!=null&&Role=='admin'}">

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
                    <li id="navWrapper">
                        <a href='/view/admin/HomeAdmin.jsp'>Home</a>
                    </li>
                    <li id="navWrapper">
                        <a href='/signup'>New Account</a>
                    </li>

                    <li id="navWrapper">
                        <a href="#">Publish Result</a>
                        <ul>
                            <li>
                                <a href="#">Semester I</a>
                                <ul>
                                    <li>
                                        <a href="/Add?Semester=First&Examination=Midterm">Midterm</a>
                                    </li>
                                    <li>
                                        <a href="/Add?Semester=First&Examination=Preboard">Preboard</a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="#">Semester II</a>
                                <ul>
                                    <li>
                                        <a href="/Add?Semester=Second&Examination=Midterm">Midterm</a>
                                    </li>
                                    <li>
                                        <a href="/Add?Semester=Second&Examination=Preboard">Preboard</a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="#">Semester III</a>
                                <ul>
                                    <li>
                                        <a href="/Add?Semester=Third&Examination=Midterm">Midterm</a>
                                    </li>
                                    <li>
                                        <a href="/Add?Semester=Third&Examination=Midterm">Preboard</a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="#">Semester IV</a>
                                <ul>
                                    <li>
                                        <a href="/Add?Semester=Fourth&Examination=Midterm">Midterm</a>
                                    </li>
                                    <li>
                                        <a href="/Add?Semester=Fourth&Examination=Midterm">Preboard</a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="#">Semester V</a>
                                <ul>
                                    <li>
                                        <a href="/Add?Semester=Fifth&Examination=Midterm">Midterm</a>
                                    </li>
                                    <li>
                                        <a href="/Add?Semester=Fifth&Examination=Midterm">Preboard</a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="#">Semester VI</a>
                                <ul>
                                    <li>
                                        <a href="/Add?Semester=Sixth&Examination=Midterm">Midterm</a>
                                    </li>
                                    <li>
                                        <a href="/Add?Semester=Sixth&Examination=Midterm">Preboard</a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="#">Semester VII</a>
                                <ul>
                                    <li>
                                        <a href="/Add?Semester=Seventh&Examination=Midterm">Midterm</a>
                                    </li>
                                    <li>
                                        <a href="/Add?Semester=Seventh&Examination=Midterm">Preboard</a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="#">Semester VIII</a>
                                <ul>
                                    <li>
                                        <a href="/Add?Semester=Eighth&Examination=Midterm">Midterm</a>
                                    </li>
                                    <li>
                                        <a href="/Add?Semester=Eighth&Examination=Midterm">Preboard</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <li id="navWrapper">
                        <a href='/search'>See Result</a>
                    </li>
                    <li id="navWrapper">
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

</html>
