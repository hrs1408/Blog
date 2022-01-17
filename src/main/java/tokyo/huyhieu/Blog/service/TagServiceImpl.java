package tokyo.huyhieu.Blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tokyo.huyhieu.Blog.model.Tag;
import tokyo.huyhieu.Blog.repository.TagRepository;
import tokyo.huyhieu.Blog.service.define.BaseService;

import java.util.List;

@Service("tagService")
public class TagServiceImpl implements BaseService<Tag> {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public List<Tag> getAll() {
        return tagRepository.findAll();
    }

    @Override
    public void save(Tag object) {
        tagRepository.save(object);
    }

    @Override
    public Tag getByID(long id) {
        return tagRepository.getById(id);
    }

    @Override
    public void deleteById(long id) {
        tagRepository.deleteById(id);
    }
}
