package com.junopen.webapp.controller;

import com.junopen.webapp.model.User;
import com.junopen.webapp.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class SecurityController {

    @Autowired
    private UserService userService;

    @RequestMapping("")
    public String login(){
        return "login";
    }

    @PostMapping("/signup")
    public String signUp(@Valid User user, Model model, BindingResult result, RedirectAttributes redirect){
        if (result.hasErrors()){
            redirect.addFlashAttribute("mesage", "Create account fail");
            return "login";
        }
        redirect.addFlashAttribute("mesage", "Create account complete");

        model.addAttribute("user", user);
        userService.save(user);
        return "redirect:/login";
    }

    @PostMapping("/signin")
    public String signIn(Model model) {
        return null;
    }
}
