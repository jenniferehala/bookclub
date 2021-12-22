<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <!-- c:out ; c:forEach ; c:if -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
   <!-- Formatting (like dates) -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
   <!-- form:form -->
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
   <!-- for rendering errors on PUT routes -->
 <%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
  <!-- Bootstrap -->
  <link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous">
</head>
<body>
    <div class="container"> <!-- Beginning of Container -->
        
        <h3>Welcome <c:out value="${user.userName}"></c:out></h3>
        
        <p>Books from everyone's shelves:</p>
        
      
        <table border="2" bordercolor="black minwidhth="300">
        	<thead>
        		<tr>
        			<th>ID</th>
        			<th>Title</th>
        			<th>Author Name</th>
        			<th>Posted By</th>
        		</tr>
        	</thead>
        	<tbody>
        	<c:forEach var="i" items="${books}">
        		<tr>
        			<td> ${i.id}</td>
        			<td> <a href="/books/show/${i.id}"> ${i.title} </a></td>
        			<td> ${i.author}</td>
        			<td> ${i.user.userName}</td>
        		</tr>
        	</c:forEach>
        	</tbody>
        </table>
         <a href="/books/new">Add a book to my shelf</a><br>
        <a href="/logout">Logout</a><br>
        
    </div> <!-- End of Container -->
</body>
</html>
