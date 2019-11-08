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
<link href="https://fonts.googleapis.com/css?family=Supermercado+One&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Sigmar+One&display=swap" rel="stylesheet"> 
<link href="https://fonts.googleapis.com/css?family=Fredoka+One&display=swap" rel="stylesheet"> 
<link href="https://fonts.googleapis.com/css?family=Marvel&display=swap" rel="stylesheet"> </head>
<body>
<jsp:include page="header.jsp" />
<div id="search" class="div">
<h2>Trouvez votre bonheur</h2>


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
</div>

<div id="annonces" class="div">
<h2>Annonces</h2>



<c:forEach items="${annonces}" var="annonce">

<div class="annonce">
<p class=annoncetitle>${annonce.title}</p>
<p>${annonce.description}</p>
<p>${annonce.prix}€ seulement !</p>
<p>${annonce.postDate}</p>
<p>${annonce.ville}</p>
<c:if test="${utilisateurConnecte.utilisateurId == annonce.proprietaire}">
<a href="http://localhost:8080/delete?id=${annonce.annonceId}">Supprimer cette annonce</a>
</c:if>

</div>

</c:forEach>
<c:choose>
<c:when test="${utilisateurconnecte != null}">



<a href="http://localhost:8080/session?page=${currentPage-1}&utilisateur=${utilisateurConnecte.utilisateurName}">Previous page</a>       


<c:forEach begin = "0" end="${nbDePages}" var="nb">
<a href="http://localhost:8080/session?page=${nb}&utilisateur=${utilisateurConnecte.utilisateurName}">${nb+1}</a>       
</c:forEach>

<a href="http://localhost:8080/session?page=${nb+1}&utilisateur=${utilisateurConnecte.utilisateurName}">Next page</a>       

</c:when>
<c:otherwise>
<a href="http://localhost:8080/?page=${currentPage-1}">Previous page</a>       



<c:forEach begin = "0" end="${nbDePages}" var="nb">
<a href="http://localhost:8080/?page=${nb}">${nb+1}</a>       
</c:forEach>

<a href="http://localhost:8080/?page=${nb+1}">Next page</a>       
</c:otherwise>
</c:choose>
</div>


<div id="utilisateurs" class="div">
<h2>Utilisateurs</h2>

<c:forEach items="${utilisateurs}" var="utilisateur">
<div id="utilisateur">
<p>${utilisateur.utilisateurName}</p>
</div>

</c:forEach>
</div>

<jsp:include page="footer.jsp" />
</body>
</html>