<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Hand Users</title>
    </head>
    <body>
        <h1>Welcome ${email}</h1>
        <h2>Handle Users</h2>
        <p>
            <a href="login">Log out</a>
        </p>
        
        <p>
            <c:if test="${message eq 'create'}">Account created</c:if>
            <c:if test="${message eq 'update'}">Account updated</c:if>
            <c:if test="${message eq 'delete'}">Account deleted</c:if>
            <c:if test="${message eq 'error'}">Sorry, something went wrong.</c:if>
            </p>
            <ul>
            <c:forEach items="${users}" var="user">
                <li><a href="users?action=view&amp;userEmail=${user.email}">${user.email} (${user.firstName}) (${user.lastName}) (${user.password})</a><br></li>
            </c:forEach>
        </ul>
        <c:if test="${selectedUser eq null}">
            <h2>Create a New User</h2>
            <form action="users" method="post">
                Email: <input type="text" name="email" value=""><br>
                First Name: <input type="text" name="fName" value=""> <br>
                Last Name: <input type="text" name="lName" value=""><br>
                Password: <input type="text" name="password" value=""><br>
                Role: <input type="number" name="role" value=""><br>
                <input type="hidden" name="active" value="1">
                <input type="hidden" name="action" value="create">
                <input type="submit" value="Create">
            </form>
        </c:if>
        <c:if test="${selectedUser ne null}">
            <h2>Edit User</h2>
            <form action="users" method="post">
                Email: <input type="text" name="email" value="${selectedUser.email}"><br>
                Active: <input type="number" name="active" value="${selectedUser.active}"><br>
                First Name: <input type="text" name="fName" value="${selectedUser.firstName}"><br>
                Last Name: <input type="text" name="lName" value="${selectedUser.lastName}"><br>
                Password: <input type="text" name="password" value="${selectedUser.password}"><br>
                Role: <input type="number" name="role" value="${selectedUser.role}"><br>
                
                <input type="hidden" name="userEmail" value="${selectedUser.email}">
                <input type="hidden" name="action" value="update">
                <input type="submit" value="Save">
            </form>

            <form action="users" method="post">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="noteId" value="${selectedUser.Email}">
                <input type="submit" value="Delete">
            </form>
            <a href="users">cancel edit</a>
        </c:if>
    </body>
</html>
