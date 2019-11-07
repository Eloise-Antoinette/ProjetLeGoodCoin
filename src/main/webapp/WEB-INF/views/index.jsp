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

</head>
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
<p>${annonce.title}</p>
<p>${annonce.description}</p>
<p>${annonce.prix}€ seulement !</p>
<p>${annonce.postDate}</p>
<p>${annonce.ville}</p>
<a href="http://localhost:8080/delete?id=${annonce.annonceId}">Supprimer cette annonce</a>
</div>

</c:forEach>


<a href="http://localhost:8080/?page=${currentPage-1}">Previous page</a>       


<c:forEach begin = "0" end="${nbDePages}" var="nb">
<a href="http://localhost:8080/?page=${nb}">${nb+1}</a>       
</c:forEach>

<a href="http://localhost:8080/?page=${nb+1}">Next page</a>       

</div>


<div id="utilisateurs" class="div">
<h2>Utilisateurs</h2>

<c:forEach items="${utilisateurs}" var="utilisateur">
<div id="utilisateur">
<p>${utilisateur.utilisateurName}</p>
<a href="http://localhost:8080/formConnexion">Se connecter</a>
</div>

</c:forEach>
</div>

<jsp:include page="footer.jsp" />
</body>
</html>