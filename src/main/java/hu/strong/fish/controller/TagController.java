package hu.strong.fish.controller;

import hu.strong.fish.model.User;
import hu.strong.fish.service.TagServiceImpl;
import hu.strong.fish.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TagController {

    @Autowired
    TagServiceImpl tagServiceImpl;

    @Autowired
    UserServiceImpl userServiceImpl;

    @GetMapping("/api/tags")
    public @ResponseBody
    List<String> getTags() {
        // TODO real user
        User user = userServiceImpl.getUserByName("joska");
        return tagServiceImpl.getAllTagNamesByUser(user);
    }



}

