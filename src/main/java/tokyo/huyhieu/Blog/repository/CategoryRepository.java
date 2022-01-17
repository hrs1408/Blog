package tokyo.huyhieu.Blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tokyo.huyhieu.Blog.model.Category;

@Repository("categoryRepository")
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
