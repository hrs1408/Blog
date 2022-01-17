package tokyo.huyhieu.Blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tokyo.huyhieu.Blog.model.User;
import tokyo.huyhieu.Blog.repository.UserRepository;
import tokyo.huyhieu.Blog.service.define.BaseService;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements BaseService<User> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User object) {
        userRepository.save(object);

    }

    @Override
    public User getByID(long id) {
         return userRepository.findById(id).get();
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

}
