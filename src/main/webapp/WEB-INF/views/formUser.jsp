<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="TheGoodCoin.css" />
<link href="https://fonts.googleapis.com/css?family=Sigmar+One&display=swap" rel="stylesheet"> 
<link href="https://fonts.googleapis.com/css?family=Supermercado+One&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Fredoka+One&display=swap" rel="stylesheet"> 
<link href="https://fonts.googleapis.com/css?family=Marvel&display=swap" rel="stylesheet"> 
</head>
<body>

<jsp:include page="header.jsp" />
<h2>Créer un compte</h2>
<form:form method="POST" action="/addUser" modelAttribute="utilisateur">
             <table>
                <tr>
                    <td><form:label path="utilisateurName">Name</form:label></td>
                    <td><form:input path="utilisateurName"/></td>
                    <form:errors path="utilisateurName" />
                    
                </tr>
                <tr>
                    <td><form:label path="motDePasse">Mot de passe</form:label></td>
                    <td><form:input path="motDePasse"/></td>
                    <form:errors path="motDePasse" />
                </tr>
				<tr>
				<td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>

       
<jsp:include page="footer.jsp" />

</body>
</html>