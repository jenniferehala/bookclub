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
<title>Show Page</title>
  <!-- Bootstrap -->
  <link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous">
</head>
<body>
    <div class="container"> <!-- Beginning of Container -->
    <h1>Book details</h1>
    
    <h3><c:out value="${book.title}"></c:out></h3>
    
    <p><c:out value="${book.user.userName}"></c:out></p> read 
    <p><c:out value="${book.title}"></c:out></p> by 
    <p><c:out value="${book.author}"></c:out></p> 

<a href="/dashboard">Go Back</a>

			<c:if test="${book.user.id == user.id}">
                <div class="d-flex justify-content-around">
                  <a href="/book/${book.id}/edit" class="btn btn-outline-warning">Edit</a>
                  <a href="/delete/${book.id}" class="btn btn-outline-danger">Delete</a>
                </div>
              </c:if>
              <c:if test="${book.user.id != user.id}">
                can't edit/delete
              </c:if>
              
              

        
    </div> <!-- End of Container -->
</body>
</html>
