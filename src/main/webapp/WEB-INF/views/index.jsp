<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
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


<p>Annonces</p>


<c:forEach items="${annonces}" var="annonces">

<p>${annonces.title}</p>
</c:forEach>


      <h1>Using GET Method to Read Form Data</h1>
      <ul>
         <li><p><b>titre de l'annonce :</b>
            <%= request.getParameter("title")%>
         </p></li>
         <li><p><b>Description:</b>
            <%= request.getParameter("description")%>
         </p></li>
                  <li><p><b>Prix:</b>
            <%= request.getParameter("prix")%>
         </p></li>
                  <li><p><b>Description:</b>
            <%= request.getParameter("description")%>
         </p></li>
                  <li><p><b>Description:</b>
            <%= request.getParameter("description")%>
         </p></li>
      </ul>




<!--  <form method="POST" -->
<!--   action="/addAnnonce" modelAttribute="annonces"> -->
<!--             <table> -->
<!--                <tr> -->
<!--                    <td><label path="title">Titre de l'annonce</label></td> -->
<!--                    <td><input path="title"/></td> -->
<!--                </tr> -->
<!--                <tr> -->
<!--                    <td><label path="description">Description :</label></td> -->
<!--                    <td><input path="description"/></td> -->
<!--                </tr> -->
<!--                <tr> -->
<!--                    <td><label type="number" path="prix"> -->
<!--                      Prix</label></td> -->
<!--                    <td><input path="prix"/></td> -->
<!--                </tr> -->
<!--                <tr> -->
<!--                <td><label path="codePostal"> -->
<!--                      Prix</label></td> -->
<!--                    <td><input type="number" path="codePostal"/></td> -->
<!--                 </tr> -->
<!-- 				<tr> -->
<!--                <td><label path="ville"> -->
<!--                      Prix</label></td> -->
<!--                    <td><input path="ville"/></td> -->
<!--                 </tr> -->
<!--                           <tr> -->
<!--                    <td><label type="date" path="date"> -->
<!--                      Prix</label></td> -->
<!--                    <td><input path="date"/></td> -->
<!--                </tr> -->
<!--                <tr> -->
<!--                    <td><input type="submit" value="Submit"/></td> -->
<!--                </tr> -->
               
               
<!--            </table> -->
<!--        </form> -->
       


</body>
</html>