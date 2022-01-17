package tokyo.huyhieu.Blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tokyo.huyhieu.Blog.model.Post;
import tokyo.huyhieu.Blog.repository.PostRepository;
import tokyo.huyhieu.Blog.service.define.BaseService;

import java.util.List;

@Service("postService")
public class PostServiceImpl implements BaseService<Post> {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }

    @Override
    public void save(Post object) {
        postRepository.save(object);
    }

    @Override
    public Post getByID(long id) {
        return postRepository.findById(id).get();
    }

    @Override
    public void deleteById(long id) {
        postRepository.deleteById(id);
    }
}
