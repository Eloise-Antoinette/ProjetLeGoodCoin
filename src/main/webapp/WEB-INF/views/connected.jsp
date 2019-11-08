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

<link href="https://fonts.googleapis.com/css?family=Supermercado+One&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Sigmar+One&display=swap" rel="stylesheet"> 
<link href="https://fonts.googleapis.com/css?family=Open+Sans&display=swap" rel="stylesheet"> 
<link href="https://fonts.googleapis.com/css?family=Marvel&display=swap" rel="stylesheet"> 
<jsp:include page="header.jsp" />
</head>

    <body>
        <h3>Felicitations ${utilisateurConnecte.utilisateurName} ! Vous êtes maintenant connecté(e) !</h3>
        
        <table>
            <tr>
                <td><a href="/session?utilisateur=${utilisateurConnecte.utilisateurName}">Retour au site</a></td>
            </tr>
        </table>
    </body>
 <jsp:include page="footer.jsp" />
</html>