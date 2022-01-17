package tokyo.huyhieu.Blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tokyo.huyhieu.Blog.model.User;

import java.util.List;

@Controller
@RequestMapping("/admin-home")
public class AdminController {
    @GetMapping("/home")
    public String listCustomers() {
        return "admin/home-page";
    }

    @GetMapping("/login")
    public String login() {
        return "admin/sign-in";
    }

    @GetMapping("/register")
    public String register() {
        return "admin/sign-up";
    }

    @GetMapping("/profile")
    public String profile() {
        return "admin/profile";
    }

}
