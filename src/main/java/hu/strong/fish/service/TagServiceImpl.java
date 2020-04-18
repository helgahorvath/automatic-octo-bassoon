package hu.strong.fish.service;

import hu.strong.fish.model.Tag;
import hu.strong.fish.model.User;
import hu.strong.fish.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    public List<String> getAllTagNamesByUser(User user) {
        return tagRepository.getAllByUser(user).stream().map(Tag::getTag).collect(Collectors.toList());
    }

    public Tag findTagIfExists(String tagName, User user) {
       return tagRepository.findByTagAndUser(tagName, user).orElse(null);
    }

    public List<Tag> createTagList(List<String> tagNames, User user) {
        List<Tag> tags = new ArrayList<>();
        for (String tagName: tagNames) {
            Tag foundTag = this.findTagIfExists(tagName, user);
            if (foundTag == null) {
                Tag newTag = new Tag(tagName, user);
                tags.add(newTag);
            } else {
                tags.add(foundTag);
            }
        }
        return tags;
    }




}
