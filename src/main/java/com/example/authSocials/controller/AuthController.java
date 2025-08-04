package com.example.authSocials.controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * *******************************************************
 * Package: com.example.authSocials.controller
 * File: AuthController.java
 * Author: Ochwada
 * Date: Monday, 04.Aug.2025, 12:06 PM
 * Description:
 * Objective:
 * *******************************************************
 */

@Controller
public class AuthController {

    @GetMapping("/my_login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/dashboard")
    public  String dashboard(Model model, @AuthenticationPrincipal OidcUser user){

        String fullName = user.getAttribute("name");
        model.addAttribute( "name", fullName);

        model.addAttribute("email", user.getEmail());

        model.addAttribute("picture", user.getPicture());

        return "dashboard";
    }

    @GetMapping("/")
    public String home(){
        return  "home";
    }

}
