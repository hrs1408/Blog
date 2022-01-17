package tokyo.huyhieu.Blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tokyo.huyhieu.Blog.model.Tag;
import tokyo.huyhieu.Blog.service.define.BaseService;

import javax.validation.Valid;

@Controller
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private BaseService<Tag> tagService;

    @GetMapping("/list")
    public String listTag(){
        return "admin/tag/list-tag";
    }

    @PostMapping("/save-tag")
    public String saveTag(@Valid @ModelAttribute("tag") Tag theTag, BindingResult br) {
        {
            if(br.hasErrors())
            {
                return "admin/tag/form-add-tag";
            }
            else
            {
                tagService.save(theTag);
                return "redirect:/tag/list";
            }
        }
    }

    @GetMapping("/add-tag")
    public String addTag(Model model ) {
        model.addAttribute("tag", new Tag());
        return "admin/tag/form-add-tag";
    }

    @GetMapping("/edit-tag/{tagId}")
    public String editTag(@PathVariable("tagId") long theId,
                           Model theModel) {
        Tag theTag = tagService.getByID(theId);
        theModel.addAttribute("tag", theTag);
        return "admin/tag/form-tag";
    }

    @GetMapping("/delete-tag/{tagId}")
    public String deleteTag(@PathVariable("tagId") long theId) {
        tagService.deleteById(theId);
        return "redirect:/tag/list";
    }
}
