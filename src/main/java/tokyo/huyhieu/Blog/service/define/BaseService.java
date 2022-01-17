package tokyo.huyhieu.Blog.service.define;

import java.util.List;

public interface BaseService<T> {
    public List<T> getAll();

    public void save(T object);

    public T getByID(long id);

    public void deleteById(long id) ;
}

