<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Notes</title>
    </head>
    <body>
        <h1>Notes App</h1>
        <h2>Login</h2>
        <form action="login" method="post">
            Email: <input type="text" name="email"><br>
            Password: <input type="password" name="password"><br>
            <input type="submit" value="Sign in">
        </form>
        <br>
        <h2>Sign Up!</h2>
        <<form action="signUp" method="post">
            Email: <input type="text" name="email"><br>
            Password: <input type="password" name="password"><br>
            First Name: <input type="fName" name="fName"><br>
            Last Name:<input type="lName" name="lName"><br>
        </form>
        
    </body>
</html>
