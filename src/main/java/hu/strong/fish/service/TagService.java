package hu.strong.fish.service;

import hu.strong.fish.model.Tag;
import hu.strong.fish.model.User;

import java.util.List;

public interface TagService {
    List<Tag> createTagList(List<String> tags, User user);
}
