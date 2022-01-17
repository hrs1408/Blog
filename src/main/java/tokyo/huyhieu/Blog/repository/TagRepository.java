package tokyo.huyhieu.Blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tokyo.huyhieu.Blog.model.Tag;

@Repository("tagRepository")
public interface TagRepository extends JpaRepository<Tag, Long> {
}
