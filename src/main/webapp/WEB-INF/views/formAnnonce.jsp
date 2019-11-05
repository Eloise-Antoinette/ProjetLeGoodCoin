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

</style>
</head>
<body>
<form:form method="POST" action="/addAnnonce" modelAttribute="annonce">
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
                    <td><form:label path="proprietaire">
                      Propriétaire</form:label></td>
                    <td><form:input path="proprietaire"/></td>
                </tr>	
                <tr>
                    <td><input type="submit" value="SubmitAnnonce"/></td>
                </tr>
            </table>
        </form:form>

       


</body>
</html>