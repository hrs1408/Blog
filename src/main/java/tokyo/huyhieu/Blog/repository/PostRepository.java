package tokyo.huyhieu.Blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tokyo.huyhieu.Blog.model.Post;

@Repository("postRepository")
public interface PostRepository extends JpaRepository<Post, Long> {
}
