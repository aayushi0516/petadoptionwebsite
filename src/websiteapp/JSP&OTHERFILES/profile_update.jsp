<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Profile</title>
</head>
<body>
    <h2>Update Profile</h2>
    <form action="profile-update" method="post">
        <label for="name">Full Name:</label>
        <input type="text" id="name" name="name" value="${user.name}" required><br><br>
        
        <label for="phone">Phone Number:</label>
        <input type="text" id="phone" name="phone" value="${user.phoneNumber}" required><br><br>
        
        <label for="address">Address:</label>
        <textarea id="address" name="address" required>${user.address}</textarea><br><br>
        
        <button type="submit">Update</button>
    </form>

    <!-- Display error message if update fails -->
    <c:if test="${not empty error}">
        <p style="color:red;">${error}</p>
    </c:if>

    <p><a href="profile.jsp">Go back to Profile</a></p>
</body>
</html>
