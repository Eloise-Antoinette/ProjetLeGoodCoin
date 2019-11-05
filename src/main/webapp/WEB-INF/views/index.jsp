<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

table {
border: solid;
border-collapse: collapse ;
}

tr{
border: solid;
border-collapse: collapse ;

}

td{
border: solid;
border-collapse: collapse ;
width: 174.667px;
text-align:center;

}

div{
margin : 2em;
padding-left : 2em;
padding-right : 2em;
padding-bottom : 2.5em;
border: solid;
background-color: LavenderBlush;
}

h1{
font-size: 2em;
color: DarkSlateBlue;
}

#annonce{
background-color : lavender;
margin-bottom : 1em;
border : groove;
padding : 0.9em;

}

#utilisateur{
background-color : MistyRose ;
margin-bottom : 1em;
border : groove;
padding : 0.9em;

} 

a{
padding : 0.6em;
margin : 0.6em;
border: solid;
border-color: DarkSlateGray;
color: DarkSlateGray;
float: center;
}

</style>
</head>
<body>
<div>
<h1>Rechercher une annonce</h1>

<form:form method="GET" action="/searchTitle" modelAttribute="annonce">
             
                <tr>
                    <td><form:label path="annonceTitle">Titre de l'annonce</form:label></td>
                    <td><form:input path="annonceTitle"/></td>
                    <form:errors path="annonceTitle" />
                    
                </tr>
                
        </form:form>
</div>
<div id="annonces">
<h1>Annonces</h1>



<c:forEach items="${annonces}" var="annonce">

<div id="annonce">
<p>${annonce.title}</p>
<p>${annonce.description}</p>
<p>${annonce.prix}€ seulement !</p>
<p>${annonce.postDate}</p>
<a href="http://localhost:8080/delete/?id=${annonce.annonceId}">Supprimer cette annonce</a>
</div>

</c:forEach>


<a href="http://localhost:8080/?page=${currentPage-1}">Previous page</a>       


<c:forEach begin = "0" end="${nbDePages}" var="nb">
<a href="http://localhost:8080/?page=${nb}">${nb+1}</a>       
</c:forEach>

<a href="http://localhost:8080/?page=${nb+1}">Next page</a>       

</div>


<div id="utilisateurs">
<h1>Utilisateurs</h1>

<c:forEach items="${utilisateurs}" var="utilisateur">
<div id="utilisateur">
<p>${utilisateur.utilisateurName}</p>
</div>
</c:forEach>
</div>

<a href="/formAnnonce">Ajouter une annonce</a>
<a href="/formUser">Creer un compte</a>       


</body>
</html>