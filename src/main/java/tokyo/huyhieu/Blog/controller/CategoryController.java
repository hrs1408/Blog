package tokyo.huyhieu.Blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tokyo.huyhieu.Blog.model.Category;
import tokyo.huyhieu.Blog.model.Tag;
import tokyo.huyhieu.Blog.service.define.BaseService;

import javax.validation.Valid;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private BaseService<Category> categoryService;

    @GetMapping("/list")
    public String listCategory(){
        return "admin/category/list-category";
    }

    @PostMapping("/save-category")
    public String saveCategory(@Valid @ModelAttribute("category") Category category, BindingResult br) {
        {
            if(br.hasErrors())
            {
                return "admin/category/form-add-category";
            }
            else
            {
                categoryService.save(category);
                return "redirect:/category/list";
            }
        }
    }

    @GetMapping("/add-category")
    public String addCategory(Model model) {
        model.addAttribute("category", new Tag());
        return "admin/category/form-add-category";
    }

    @GetMapping("/edit-category/{categoryId}")
    public String editCategory(@PathVariable("categoryId") long theId,
                          Model theModel) {
        Category category = categoryService.getByID(theId);
        theModel.addAttribute("category", category);
        return "admin/category/form-category";
    }

    @GetMapping("/delete-category/{categoryId}")
    public String deleteCategory(@PathVariable("categoryId") long theId) {
        categoryService.deleteById(theId);
        return "redirect:/category/list";
    }
}
