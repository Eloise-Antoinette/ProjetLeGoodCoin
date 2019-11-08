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

<h2>Ajouter une annonce</h2>
<form:form method="POST" action="/addAnnonce?utilisateurConnecte=${utilisateurConnecte.utilisateurName}" modelAttribute="annonce">
             <table>
                <tr>
                    <td><form:label path="title">Title</form:label></td>
                    <td><form:input path="title"/></td>
                    <form:errors path="title" />
                    
                </tr>
                <tr>
                    <td><form:label path="description">Description</form:label></td>
                    <td><form:input path="description"/></td>
                    <form:errors path="description" />
                </tr>
                <tr>
                    <td><form:label path="prix">
                      Prix</form:label></td>
                    <td><form:input type="number" path="prix"/></td>
                    <form:errors path="prix" />
                </tr>
                 <tr>
                    <td><form:label path="codePostal">
                      Code Postal</form:label></td>
                    <td><form:input path="codePostal"/></td>
                </tr>	
                                 <tr>
                    <td><form:label path="ville">
                      Ville</form:label></td>
                    <td><form:input path="ville"/></td>
                </tr>	
                                 <tr>
                    
                    <td><form:hidden value="${utilisateurConnecte.utilisateurId}" path="proprietaire"/></td>
                </tr>	
                <tr>
                    <td><input type="submit" value="SubmitAnnonce"/></td>
                </tr>
            </table>
        </form:form>

       <jsp:include page="footer.jsp" />


</body>
</html>