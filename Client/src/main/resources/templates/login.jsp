<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Kul att du är intresserad av jobb på grönan!</h1>
        <form method="GET" action="/L3ST/Users">
            Användarnamn <input type="text" name="username"><br>
            Lösenord <input type="text" name="password"><br>
            <input type="hidden" name="action" value="login">
            <input type="submit" value="Logga in">
        </form>
    </body>
</html>
