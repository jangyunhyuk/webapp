<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>

	<body>
	    <div class="login-form">
	        <h1>Webapp Hyuk</h1>
	        <h2>Login</h2>
	
	        <c:if test="${not empty error}">
	            <p class="error-message">${error}</p>
	        </c:if>
	
	        <form action="login" method="post">
	            <input type="text" id="username" name="username" placeholder="Username" required>            
	            <input type="password" id="password" name="password" placeholder="Password" required>
	            <input type="submit" value="Login">
	        </form>
	    </div>
	</body>
</html>