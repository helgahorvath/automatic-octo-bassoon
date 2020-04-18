package hu.strong.fish.service;

import hu.strong.fish.dto.PostDTO;
import hu.strong.fish.model.Tag;
import hu.strong.fish.model.User;
import hu.strong.fish.model.post.Post;

import java.util.List;

public interface PostService {
    List<Post> getAllPostsByUser(User user);

    List<PostDTO> createPostDTOs(List<Post> allPostsByUser);

    void saveNewPost(String title, String text, List<Tag> tags, User user);
}
