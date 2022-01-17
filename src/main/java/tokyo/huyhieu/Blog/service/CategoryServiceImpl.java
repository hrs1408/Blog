package tokyo.huyhieu.Blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tokyo.huyhieu.Blog.model.Category;
import tokyo.huyhieu.Blog.repository.CategoryRepository;
import tokyo.huyhieu.Blog.service.define.BaseService;

import java.util.List;

@Service("categoryService")
public class CategoryServiceImpl implements BaseService<Category> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void save(Category object) {
        categoryRepository.save(object);
    }

    @Override
    public Category getByID(long id) {
        return categoryRepository.getById(id);
    }

    @Override
    public void deleteById(long id) {
        categoryRepository.deleteById(id);
    }
}
