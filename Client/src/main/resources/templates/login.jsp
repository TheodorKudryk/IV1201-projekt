<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Kul att du är intresserad av jobb på grönan!</h1>
        <form method="POST" action="/loginAttempt">
            Användarnamn <input type="text" name="username" id="username"><br>
            Lösenord <input type="text" name="password" id="password"><br>
            <input type="hidden">
            <input type="submit" value="Logga in">
        </form>
    </body>
</html>
