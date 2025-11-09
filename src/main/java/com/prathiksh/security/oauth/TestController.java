package com.prathiksh.security.oauth;

import com.prathiksh.security.customannotation.CheckExecutionTime;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class TestController {

    @CheckExecutionTime
    @GetMapping("/home")
    public String testOauth(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/forwarded").forward(request,response);
        return "Hi OAuth Successfully Authenticated";
    }

    @GetMapping("/forwarded")
    public String testForwarded(){
        return "This is testForwarded";
    }


}
