package hu.strong.fish.repository;

import hu.strong.fish.model.Tag;
import hu.strong.fish.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

    List<Tag> getAllByUser(User user);
    Optional<Tag> findByTagAndUser(String tag, User user);

}
