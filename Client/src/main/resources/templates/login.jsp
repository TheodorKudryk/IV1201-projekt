<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Kul att du �r intresserad av jobb p� gr�nan!</h1>
        <form method="POST" action="/loginAttempt">
            Anv�ndarnamn <input type="text" name="username" id="username"><br>
            L�senord <input type="text" name="password" id="password"><br>
            <input type="hidden">
            <input type="submit" value="Logga in">
        </form>
    </body>
</html>
