package tokyo.huyhieu.Blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tokyo.huyhieu.Blog.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
}
