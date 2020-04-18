package hu.strong.fish.controller;


import hu.strong.fish.dto.PostDTO;
import hu.strong.fish.model.Tag;
import hu.strong.fish.model.User;
import hu.strong.fish.service.PostService;
import hu.strong.fish.service.TagService;
import hu.strong.fish.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class PostController {

    private PostService postService;

    private TagService tagService;

    private UserService userService;

    @Autowired
    public PostController(PostService postService, TagService tagService, UserService userService) {
        this.postService = postService;
        this.tagService = tagService;
        this.userService = userService;
    }

    @GetMapping("/api/posts")
    public @ResponseBody List<PostDTO> getPosts() {
        User user = userService.getUserByName("joska");
        return postService.createPostDTOs(postService.getAllPostsByUser(user));
    }

    @PostMapping("/api/newpost")
    public void addNewPost(@RequestBody Map<String, Object> post) {
        // TODO real user

        User user = userService.getUserByName("joska");
        List<Tag> tags = tagService.createTagList((List<String>) post.get("tags"), user);
        postService.saveNewPost((String) post.get("title"), (String) post.get("text"), tags, user);
    }



}
