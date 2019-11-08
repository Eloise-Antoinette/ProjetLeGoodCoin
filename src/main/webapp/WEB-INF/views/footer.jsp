<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<footer>
<div id="footerdiv">
<a href="/">Accueil</a>

      

<c:if test="${utilisateurConnecte == null}">

<a href="/formUser">Creer un compte</a> 
</c:if>



<c:if test="${utilisateurConnecte != null}">

<a href="http://localhost:8080/formAnnonce?utilisateurConnecte=${utilisateurConnecte.utilisateurName}">Ajouter une annonce</a>
</c:if>




<c:if test="${utilisateurConnecte == null}">

<a href="http://localhost:8080/formConnexion">Se connecter</a>
</c:if>

<c:if test="${utilisateurConnecte != null}">

<a href="http://localhost:8080/monCompte?utilisateurConnecte=${utilisateurConnecte.utilisateurName}">Accéder à mon espace perso</a>
</c:if>

</div>
</footer>