package hu.strong.fish.service;

import hu.strong.fish.dto.PostDTO;
import hu.strong.fish.model.Tag;
import hu.strong.fish.model.User;
import hu.strong.fish.model.post.Post;
import hu.strong.fish.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPostsByUser (User user) {
        return postRepository.findAllByUser(user);
    }

    public List<PostDTO> createPostDTOs(List<Post> posts) {
        return posts.stream().map(post -> {
            PostDTO postDTO = new PostDTO();
            postDTO.setId(post.getId().toString());
            postDTO.setCreateDate(post.getCreateDate().toString());
            if (post.getEditDate() != null) {
                postDTO.setEditDate(post.getEditDate().toString());
            }
            if (post.getTag() != null) {
                postDTO.setTags(post.getTag().stream().map(Tag::getTag).collect(Collectors.toList()));
            }
            postDTO.setText(post.getText());
            postDTO.setTitle(post.getTitle());
            return postDTO;
        }).collect(Collectors.toList());
    }

    public void saveNewPost(String title, String text, List<Tag> tags, User user) {
        Post post = new Post();
        post.setTitle(title);
        post.setText(text);
        post.setTag(tags);
        post.setUser(user);
        post.setCreateDate(new Timestamp(System.currentTimeMillis()));

        postRepository.save(post);
    }

}
