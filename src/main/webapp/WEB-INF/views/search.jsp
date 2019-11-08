<!DOCTYPE html>

<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>

<link href="https://fonts.googleapis.com/css?family=Sigmar+One&display=swap" rel="stylesheet"> 
<link href="https://fonts.googleapis.com/css?family=Supermercado+One&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Fredoka+One&display=swap" rel="stylesheet"> 
<link href="https://fonts.googleapis.com/css?family=Marvel&display=swap" rel="stylesheet"> 


<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form method="GET" action="/searchTitle" modelAttribute="annonce">
             <table>
                <tr>
                    <td><form:label path="title">Title</form:label></td>
                    <td><form:input path="title"/></td>
                    <form:errors path="title" />
				 </tr>
				 <tr>
				<td><form:label path="ville">Ville</form:label></td>
                    <td><form:input path="ville"/></td>
                    <form:errors path="ville" />
                </tr>
                <tr>
                 <tr>
				<td><form:label path="description">Description</form:label></td>
                    <td><form:input path="description"/></td>
                    <form:errors path="description" />
                </tr>
                <tr>
                <td><input type="submit" value="Submit"/></td>
            </tr>
            </table>
        </form:form>

</body>
</html>