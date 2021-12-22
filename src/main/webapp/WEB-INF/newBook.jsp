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
<title>Title Here</title>
  <!-- Bootstrap -->
     
  <link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous">
</head>
<body>
    <div class="container"> <!-- Beginning of Container -->
    
    <h1>Add a Book to Your Book Shelf</h1>
    
    <br>
    <div>
    <form:form action="/newbook" method="post" modelAttribute="book">
    <form:hidden path="user" value="${user.id}"/>
    	<form:label path="title">Title</form:label>
    	<form:errors path="title"></form:errors>
    	<form:input path="title"/>
    	
    	<form:label path="author">Author</form:label>
    	<form:errors path="author"></form:errors>
    	<form:input path="author"/>
    	
    	<form:label path="description">My Thoughts</form:label>
    	<form:errors path="description"></form:errors>
    	<form:textarea path="description"/>
    	
    <input type="submit" value="Submit"/>
    </form:form>
    
    <a href="books/show/${id}"></a>
        </div>
    </div> <!-- End of Container -->
</body>
</html>
