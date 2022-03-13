
package com.iv1201.Client.controller;

import static com.iv1201.client.controller.LoginController.isAuthenticated;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * If an user tries to go to a nonexistent page, they will be redirected to the
 * front page with an error
 * @author Zarcez
 */
@RestController
public class MyErrorController implements ErrorController{

        @RequestMapping("/error")
        public void getErrorPath(HttpServletResponse response, HttpServletRequest request) throws IOException {
            if (isAuthenticated())
                 response.sendRedirect(request.getContextPath() +"/startpage?error");
            else{
                response.sendRedirect(request.getContextPath() +"/login?error");
            }
    }
}

