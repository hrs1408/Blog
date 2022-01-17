package tokyo.huyhieu.Blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tokyo.huyhieu.Blog.model.User;
import tokyo.huyhieu.Blog.service.define.BaseService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private BaseService<User> userSerivce;

    @GetMapping("/list")
    public String listCustomers(Model theModel) {
        List<User> users = userSerivce.getAll();
        theModel.addAttribute("users", users);
        return "admin/user/list-users";
    }

    @PostMapping("/save-user")
    public String saveUser( @Valid @ModelAttribute("user")  User theUser, BindingResult br) {
        {
            if(br.hasErrors())
            {
                return "admin/user/form-add-user";
            }
            else
            {
                userSerivce.save(theUser);
                return "redirect:/user/list";
            }
        }
    }

    @GetMapping("/add-user")
    public String addUser(Model model ) {
        model.addAttribute("user", new User());
        return "admin/user/form-add-user";
    }

    @GetMapping("/edit-user/{userId}")
    public String editUser(@PathVariable("userId") long theId,
                                    Model theModel) {
        User theUser = userSerivce.getByID(theId);
        theModel.addAttribute("user", theUser);
        return "admin/user/form-user";
    }

    @GetMapping("/delete-user/{userId}")
    public String deleteUser(@PathVariable("userId") long theId) {
        userSerivce.deleteById(theId);
        return "redirect:/user/list";
    }
}
