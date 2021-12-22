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
<title>Edit Page</title>
  <!-- Bootstrap -->
  <link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous">
</head>
<body>
    <div class="container"> <!-- Beginning of Container -->
        <div>
    <form:form action="/book/${book.id}/update" method="post" modelAttribute="book">
    <input type="hidden" name="_method" value="put">
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
    
    
        </div>
        
    </div> <!-- End of Container -->
</body>
</html>
