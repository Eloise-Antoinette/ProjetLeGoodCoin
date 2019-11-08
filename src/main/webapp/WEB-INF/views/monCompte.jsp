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
<link href="https://fonts.googleapis.com/css?family=Sigmar+One&display=swap" rel="stylesheet"> 
<link href="https://fonts.googleapis.com/css?family=Supermercado+One&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Fredoka+One&display=swap" rel="stylesheet"> 
<link href="https://fonts.googleapis.com/css?family=Marvel&display=swap" rel="stylesheet"> 
<jsp:include page="header.jsp" />
</head>

    <body>
        <h3>Bienvenue dans votre espace perso ${utilisateurConnecte.utilisateurName} ! </h3>
        
       
<div id="annonces" class="div">
<h2>Annonces</h2>


<c:forEach items="${annonces}" var="annonce">

<div class="annonce">
<p class="annnoncetitle">${annonce.title}</p>
<p>${annonce.description}</p>
<p>${annonce.prix}€ seulement !</p>
<p>${annonce.postDate}</p>
<p>${annonce.ville}</p>
<c:if test="${annonce.sold == true }">
<p> CETTE ANNONCE EST EN LIGNE</p>
<a href="http://localhost:8080/delete?id=${annonce.annonceId}">Supprimer cette annonce du site</a>
</c:if>

<c:if test="${annonce.sold == false }">
<p>CETTE ANNONCE N'EST PAS EN LIGNE</p>
<a href="http://localhost:8080/activer?id=${annonce.annonceId}">Afficher cette annonce sur le site</a>
</c:if>
</div>

</c:forEach>
       
</div>       
       
          </body>
    
 <jsp:include page="footer.jsp" />
</html>