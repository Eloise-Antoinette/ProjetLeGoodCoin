<%-- <form:form method="GET" action="/searchTitle" modelAttribute="annonce"> --%>
             
            
<%--                    <form:label path="annonceTitle">Titre de l'annonce</form:label> --%>
<%--                     <form:input path="annonceTitle"/> --%>
<%--                     <form:errors path="annonceTitle" /> --%>
                    
<!--  				<input type="submit" value="Submit"/>  -->
              
<%--       </form:form>  --%>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form method="POST" action="/search" >
             
            
                   <form:label path="annonceTitle">Titre de l'annonce</form:label>
                    <form:input path="annonceTitle"/>
                    <form:errors path="annonceTitle" />
                    
 				<input type="submit" value="Submit"/> 
              
      </form:form> 
       
<p>Bonjour</p>

</body>
</html>