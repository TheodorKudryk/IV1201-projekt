<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Login</title>
    </head>
    <body>
        <h1>Login page</h1>
        <form method="POST" action="/loginAttempt">
            Username <input type="text" name="username" id="username"><br>
            Password <input type="text" name="password" id="password"><br>
            <input type="hidden" name="action" value="login">
            <input type="submit" value="Login">
        </form>
    </body>
</html>
