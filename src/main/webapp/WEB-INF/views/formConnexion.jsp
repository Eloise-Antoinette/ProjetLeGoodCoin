<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TheGoodCoin</title>
<link rel="stylesheet" type="text/css" href="TheGoodCoin.css" />
</head>
<body>
<jsp:include page="header.jsp" />
<form:form method="POST" action="/connexion" modelAttribute="utilisateur">
             <h2>Connexion</h2>
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
				<td><input type="submit" value="Se connecter"/></td>
                </tr>
            </table>
        </form:form>

       
<jsp:include page="footer.jsp" />

</body>
</html>