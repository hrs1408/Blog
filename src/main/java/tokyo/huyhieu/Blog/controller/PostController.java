package tokyo.huyhieu.Blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tokyo.huyhieu.Blog.model.Category;
import tokyo.huyhieu.Blog.model.Post;
import tokyo.huyhieu.Blog.model.Tag;
import tokyo.huyhieu.Blog.service.define.BaseService;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private BaseService<Post> postService;

    @Autowired
    private BaseService<Tag> tagService;

    @Autowired
    private BaseService<Category> categoryService;

    @GetMapping("/list")
    public String listPost(Model model){
        List<Post> posts = postService.getAll();
        model.addAttribute("posts", posts);
        return "admin/post/list-post";
    }

    @PostMapping("/save-post")
    public String savePost(@ModelAttribute("post") Post thePost) {
                postService.save(thePost);
                return "redirect:/post/list";
    }

    @GetMapping("/add-post")
    public String addPost(Model model ) {
        List<Tag> tags = tagService.getAll();
        List<Category> categories = categoryService.getAll();
        model.addAttribute("post", new Post());
        model.addAttribute("tags", tags);
        model.addAttribute("categories", categories);
        model.addAttribute("localDateTime", LocalDateTime.now());
        return "admin/post/form-add-post";
    }

    @GetMapping("/edit-post/{postId}")
    public String editPost(@PathVariable("postId") long theId,
                           Model theModel) {
        Post thePost = postService.getByID(theId);
        Category cateSelected = postService.getByID(theId).getCategory();
        List<Tag> tags = tagService.getAll();
        List<Category> categories = categoryService.getAll();
        theModel.addAttribute("post", thePost);
        theModel.addAttribute("tags", tags);
        theModel.addAttribute("categories", categories);
        theModel.addAttribute("localDateTime", LocalDateTime.now());
        theModel.addAttribute("cateSelected", cateSelected);
        return "admin/post/form-post";
    }

    @GetMapping("/delete-post/{postId}")
    public String deletePost(@PathVariable("postId") long theId) {
        postService.deleteById(theId);
        return "redirect:/post/list";
    }
}
